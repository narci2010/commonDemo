package com.yestin.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * Created by yestin on 2017/10/2.
 */
public class LongEventHandler implements EventHandler<LongEvent>
{
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch)
    {
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
        System.out.println("****Event: " + event.getValue());
    }



}