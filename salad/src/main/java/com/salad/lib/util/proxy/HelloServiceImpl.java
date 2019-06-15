package com.salad.lib.util.proxy;

/**
 * @author cuishifeng
 * @date 2019-05-16
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {
        return "hello : " + name;
    }

    @Override
    public String getName(String id) {
        return "获取名称: " + id;
    }


    public void chat() {
        System.out.println("123");
    }
}
