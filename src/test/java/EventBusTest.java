import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by yinlu on 2017/8/3.
 */
public class EventBusTest {

    //测试重复注册监听器
    @Test
    public void testRepeatRegister() {
        final EventBus bus = new EventBus();
        bus.register(new TestEventListener());
        bus.register(new TestEventListener());

        TestEvent event = new TestEvent(SystemEvent.TEST_EVENT, "123");
        bus.post(event);
    }

    //测试并发操作
    @Test
    public void testConcurrcy() {
//        List<String> list = Lists.newArrayList("001#01");
//        MemberDeletedEvent event = new MemberDeletedEvent(SystemEvent.MEMBER_DELETE_EVENT, "123", list, 1);
//        for(int i=0 ; i < 10 ; i++) {
//            final int cnt = i ;
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("第"+ cnt+ "次");
//                    EventBusFactory.build().register(MemberDeletedEventListener.class) ;
//                }
//            }) ;
//            t.start();
//        }

        ArrayList list1 = Lists.newArrayList(Integer.class);

//        for (int i = 0; i < 3; i++) {
//            list1.add(i);
//            EventBusFactory.build().registerAsync(MemberDeletedEventListener.class);
//            EventBusFactory.build().postsAsyncEvent(new MemberDeletedEvent(SystemEvent.MEMBER_DELETE_EVENT, "123", list1, 1));
//            System.out.println(i + "次");
//        }

        list1.add(1);
        EventBusFactory.build().registerAsync(MemberDeletedEventListener.class);
        EventBusFactory.build().postsAsyncEvent(new MemberDeletedEvent(SystemEvent.MEMBER_DELETE_EVENT, "123", list1, 1));
        System.out.println( "次");

    }

    //测试继承结构下的事件分发
    @Test
    public void testInherit() {
        TestEvent event = new TestEvent(SystemEvent.TEST_EVENT, "123");
        EventBusFactory.build().register(TestEventListener.class);
        EventBusFactory.build().postsEvent(event);
    }
}
