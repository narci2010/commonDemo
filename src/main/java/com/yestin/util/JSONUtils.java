
package com.yestin.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;
import java.util.List;


public class JSONUtils {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JSONUtils.class);
    /**
     * 将java类型的对象转换为JSON格式的字符串
     *
     * @param object java类型的对象
     * @return JSON格式的字符串
     */
    public static <T> String toJSON(T object) {
        return JSON.toJSONString(object);
    }

    /**
     * 将JSON格式的字符串转换为java类型的对象或者java数组类型的对象，不包括java集合类型
     *
     * @param json JSON格式的字符串
     * @param clz  java类型或者java数组类型，不包括java集合类型
     * @return java类型的对象或者java数组类型的对象，不包括java集合类型的对象
     */
    public static <T> T fromJson(String json, Class<T> clz) {
        return JSON.parseObject(json, clz);
    }

    /**
     * 将JSON格式的字符串转换为List<T>类型的对象
     *
     * @param json JSON格式的字符串
     * @param clz  指定泛型集合里面的T类型
     * @return List<T>类型的对象
     */
    public static <T> List<T> fromJsonToList(String json, Class<T> clz) {
        return JSON.parseArray(json, clz);
    }

    /**
     * 将JSON格式的字符串转换成任意Java类型的对象
     *
     * @param json JSON格式的字符串
     * @param type 任意Java类型
     * @return 任意Java类型的对象
     */
    public static <T> T fromJson(String json, TypeReference<T> type) {
        return JSON.parseObject(json, type);
    }


    static class User {
        String name;
        String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User u = new User();
        u.setName("张三");
        u.setAge("13");
        userList.add(u);
        User u2 = new User();
        u2.setName("张三");
        u2.setAge("13");
        userList.add(u2);

        logger.info(toJSON(userList));
    }

}