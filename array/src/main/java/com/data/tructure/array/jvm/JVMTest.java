package com.data.tructure.array.jvm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author cuishifeng
 * @date 2019-08-13
 */
public class JVMTest {

    private static Map<String, User> map = new HashMap<>();

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 1000; i++) {
            //            byte[] name = new byte[50];
            User user = new User("12345678910" + i, "9876543210" + i);
            //            map.put(i + "", new User("12345678910" + i, "9876543210" + i));
            System.out.println("循环: " + i);
            TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class User {
        private String name;
        private String title;
    }
}
