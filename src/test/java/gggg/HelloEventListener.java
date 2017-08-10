package gggg;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

/**
 * Created by yinlu on 2017/8/3.
 */
public class HelloEventListener {
    @Subscribe
    @AllowConcurrentEvents
    public void listen(OrderEvent event) {
        System.out.println("---我来了");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            i++;
            for (int j = 0; j < 100000000; j++) {
                j++;
            }
        }
        System.out.println("---耗时"+(System.currentTimeMillis()-start));
        System.out.println("receive msg:"+event.getMessage());
    }

    @Test
    public void t() {
        System.out.println("---我来了");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            i++;
            for (int j = 0; j < 80000; j++) {
                j++;
            }
        }
        System.out.println("---耗时"+(System.currentTimeMillis()-start));
    }
}
