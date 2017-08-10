import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Created by yinlu on 2017/8/3.
 */
public class MemberDeletedEventListener implements EventListener {
    private static final Logger logger = LogManager.getLogger(MemberDeletedEventListener.class);

    @Override
    @Subscribe
    @AllowConcurrentEvents
    public void action(SystemEvent event) {
        logger.info(String.format("*************[MemberDeletedEventListener ] action event=%s", event.toString()));
        MemberDeletedEvent subEvent = (MemberDeletedEvent) event;
//        invoke(subEvent);

        //...业务代码

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            i++;

//            for (int j = 0; j < 1000000000; j++) {
//                j++;
//            }
        }

        logger.info("---耗时"+(System.currentTimeMillis()-start));

        logger.info("--------------处理业务" + subEvent.getEventName() + "," + subEvent.getE164ListToOper());
    }

    @Test
    public void time () {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            i++;

            for (int j = 0; j < 1000000000; j++) {
                j++;
            }
        }

        logger.info("---耗时"+(System.currentTimeMillis()-start));
    }

    public void invoke(MemberDeletedEvent memberDeletedEvent) {
        //...业务代码
        logger.info("--------------处理业务" + memberDeletedEvent.getEventName() + "," + memberDeletedEvent.getE164ListToOper());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            i++;

            for (int j = 0; j < 1000000000; j++) {
                j++;
            }
        }

        logger.info("---耗时"+(System.currentTimeMillis()-start)/1000);
    }
}