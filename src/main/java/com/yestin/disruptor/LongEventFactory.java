package com.yestin.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by yestin on 2017/10/2.
 */
public class LongEventFactory implements EventFactory<LongEvent>
{
    public LongEvent newInstance()
    {
        return new LongEvent();
    }
}