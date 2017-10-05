package com.yestin.reactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import reactor.core.Reactor;
import reactor.event.Event;
import reactor.spring.annotation.Selector;
/**
 * Created by yestin on 2017/10/2.
 */
@Component
public class IndexHandler {

    @Autowired
    @Qualifier("reportReactor")
    private Reactor rx ;



    @Selector(value="step1",reactor="@reportReactor")
    public void step1(Event<String> evt)throws Exception{
        System.out.println("step1xxxxxx**********");
        String data = evt.getData();
        System.out.println(data);
//        rx.notify("step2", Event.wrap(data));
    }
    @Selector(value="step2",reactor="@reportReactor")
    public void step2(Event<String> evt)throws Exception{
        System.out.println("step2xxxxxx**********");
        String data = evt.getData();
        System.out.println(data);
        rx.notify("step3", Event.wrap(data));
    }
    @Selector(value="step3",reactor="@reportReactor")
    public void step3(Event<String> evt)throws Exception{
        System.out.println("step3xxxxxx**********");
        String data = evt.getData();
        System.out.println(data);
        rx.notify("step4", Event.wrap(data));
    }
    @Selector(value="step4",reactor="@reportReactor")
    public void step4(Event<String> evt)throws Exception{
        System.out.println("4xxxxxx**********");
        String data = evt.getData();
        System.out.println(data);
    }

}