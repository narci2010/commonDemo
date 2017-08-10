package com.yestin.eventbus;

/**
 * Created by yinlu on 2017/8/3.
 */
public class OrderEvent {
    private String message;
    public OrderEvent(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
