package gggg;

import com.google.common.eventbus.AsyncEventBus;
import org.junit.Test;

import java.util.concurrent.Executors;

/**
 * Created by yinlu on 2017/8/3.
 */
public class tttt {

    @Test
    public void testevent() {
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool());

        //register all subscriber
        eventBus.register(new HelloEventListener());

        //publish event
        eventBus.post(new OrderEvent("hello"));
        eventBus.post(new OrderEvent("world"));
    }
}
