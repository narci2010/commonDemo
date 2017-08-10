import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import com.yestin.aspect.WebLogAspect;
import org.apache.logging.log4j.LogManager;

/**
 * Created by yinlu on 2017/8/3.
 */
public class TestEventListener implements EventListener{

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(TestEventListener.class);
    @Override
    @Subscribe
    @AllowConcurrentEvents
    public void action(SystemEvent event) {
        logger.info(String.format("[TestEventListener ] action, listener=%s event=%s", this.toString(), event.toString()));
        TestEvent subEvent = (TestEvent) event ;
        invoke(subEvent) ;
    }

    public void invoke(TestEvent testEvent) {
        logger.info(String.format("[TestEventListener ] action testEvent=%s", testEvent.toString()));
    }

}
