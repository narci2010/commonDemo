package com.yestin.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by yinlu on 2017/4/7.
 */
public class CommonUtils {

    private static final Logger logger = LogManager.getLogger(CommonUtils.class);

    public static String getUniqueId() {
        return System.currentTimeMillis() + get4random();
    }

    public static String get4random() {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        return String.valueOf(sb);
    }

    // 打印MAP
    public static void printMap(HashMap<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            logger.info("遍历key和value:::::key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
    }
}
