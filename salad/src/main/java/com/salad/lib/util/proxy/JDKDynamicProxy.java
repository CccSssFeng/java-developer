package com.salad.lib.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cuishifeng
 * @date 2019-05-16
 */
public class JDKDynamicProxy implements InvocationHandler {

    private Object object;

    public JDKDynamicProxy(Class<?> clazz) {
        try {
            this.object = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }

    public static <T> T proxy(Class<T> clazz) {
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(clazz);
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), jdkDynamicProxy);
    }


    public static void main(String[] args) {

        HelloService helloService =  proxy(HelloServiceImpl.class);
        String result = helloService.sayHello("tom");
        System.out.println(result);

        String name = helloService.getName("666");
        System.out.println(name);

    }
}
