package com.data.tructure.array.design.代理模式;

import org.junit.Test;

public class Client {

    public static void main(String[] args) {
        Buyer buyer = new InternetBuyer();
        Buyer proxy = (Buyer) DynamicProxy.DynamicProxy(buyer);
        proxy.buy();
        proxy.doSomeThing();

        System.out.println("----------------");

        InternetBuyer proxy2 = DynamicProxy.cglibDynamicProxy(InternetBuyer.class);
        proxy2.buy();
    }

    @Test
    public void test() throws Exception {
        System.out.println("time:" + (long) 1000 * 3600 * 24 * 30 * 2);
        long add = 2592000000l;
        long time = 1582438727000L;
        System.out.println("time add:" + (time + add * 2));

    }
}
