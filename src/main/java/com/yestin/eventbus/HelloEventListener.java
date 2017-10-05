package com.yestin.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

/**
 * Created by yinlu on 2017/8/3.
 */
public class HelloEventListener {
    @Subscribe
    @AllowConcurrentEvents
    public void listen(OrderEvent event) {
        System.out.println("---我来了");
        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            i++;
//            for (int j = 0; j < 8; j++) {
//                j++;
//            }
//        }
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("---耗时"+(System.currentTimeMillis()-start));
        System.out.println("receive msg:"+event.getMessage());
    }
}
