package com.yestin.controller;

/**
 * Created by yinlu on 2017/8/1.
 */

import com.google.common.eventbus.AsyncEventBus;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.yestin.async.Task;
import com.yestin.disruptor.LongEvent;
import com.yestin.disruptor.LongEventFactory;
import com.yestin.disruptor.LongEventHandler;
import com.yestin.disruptor.LongEventProducer;
import com.yestin.domain.User;
import com.yestin.domain.UserRepository;
import com.yestin.eventbus.HelloEventListener;
import com.yestin.eventbus.OrderEvent;
import com.yestin.redis.MyRedisTemplate;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Reactor;
import reactor.event.Event;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @RestController:spring mvc的注解，
 * 相当于@Controller与@ResponseBody的合体，可以直接返回json
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private MyRedisTemplate myRedisTemplate;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Task task;

    @Autowired
    @Qualifier("reportReactor")
    private Reactor rx;



    @RequestMapping("/testJedisCluster")
    @ResponseBody
    public String testJedisCluster() {
        myRedisTemplate.set("panic", "mytest", "123");
        String value = myRedisTemplate.get("panic:mytest");
        return value;
    }
    @RequestMapping("/testevent")
    @ResponseBody
    public String testevent() {
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));
        eventBus.register(new HelloEventListener());
        for (int i = 0; i < 500; i++) {
            eventBus.post(new OrderEvent(String.valueOf(i)));
            System.out.println("****"+i);
        }
//        eventBus.post(new OrderEvent(String.valueOf(1)));
        return "sss";
    }
    @RequestMapping("/testdisruptor")
    @ResponseBody
    public String testdisruptor() {
        // Executor that will be used to construct new threads for consumers
        Executor executor = Executors.newCachedThreadPool();
        // The factory for the event
        LongEventFactory factory = new LongEventFactory();
        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;
        // Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor(factory, bufferSize,
                Executors.defaultThreadFactory());



        // Connect the handler
        disruptor.handleEventsWith(new LongEventHandler());
        // Start the Disruptor, starts all threads running
        disruptor.start();
        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);


        for (int i = 0; i < 500; i++) {
            producer.onData(i);
            System.out.println("****"+i);
        }
        return "sss";
    }
    @RequestMapping("/testdisruptorfz")
    @ResponseBody
    public String testdisruptorfz() {

        return "sss";
    }




    @RequestMapping("/testreactor")
    @ResponseBody
    public void testreactor() {
        for (int i = 0; i < 500; i++) {
            rx.notify("step1", Event.wrap("好"+i));
            System.out.println("****"+i);
        }
    }

    @RequestMapping("/testrabbit")
    @ResponseBody
    public String testrabbit() {
        for (int i = 0; i < 100000; i++) {
            this.rabbitTemplate.convertAndSend("hello", String.valueOf(i));
            System.out.println("****"+i);
        }
        return "sss";
    }
    @RequestMapping("/testmongo")
    @ResponseBody
    public String testmongo() {
        // 创建三个User，并验证User总数
        userRepository.save(new User(1L, "didi", 30));
        userRepository.save(new User(2L, "mama", 40));
        userRepository.save(new User(3L, "kaka", 50));
        System.out.println("****"+userRepository.findAll().size());
        // 删除一个User，再验证User总数
        User u = userRepository.findOne(1L);
        userRepository.delete(u);
        System.out.println("****"+userRepository.findAll().size());

        // 删除一个User，再验证User总数
        u = userRepository.findByUsername("mama");
        userRepository.delete(u);
        System.out.println("****"+userRepository.findAll().size());
        return "sss";
    }

    @RequestMapping("/testasync")
    @ResponseBody
    public String testasync() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
        return "sss";
    }

}