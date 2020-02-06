package com.data.tructure.array.design.代理模式;

public class InternetBuyer implements Buyer {

    @Override
    public void buy() {
        System.out.println("网络购物....");
    }

    @Override
    public void doSomeThing() {
        System.out.println("额外做点啥事...");
    }
}
