package com.yestin.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 翟永超
 * @create 2016/9/25.
 * @blog http://blog.didispace.com
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("---我来了");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            i++;
            for (int j = 0; j < 8000; j++) {
                j++;
            }
        }
        System.out.println("---耗时"+(System.currentTimeMillis()-start));
        System.out.println("Receiver : " + hello);
    }

}
