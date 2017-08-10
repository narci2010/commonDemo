/**
 * Created by yinlu on 2017/8/3.
 */

public class TestEvent extends SystemEvent {

    private String testField;

    public String getTestField() {
        return testField;
    }

    public void setTestField(String testField) {
        this.testField = testField;
    }

    public TestEvent() {}

    public TestEvent(String eventName, String testField) {
        super(eventName) ;
        this.testField = testField ;
    }

}


