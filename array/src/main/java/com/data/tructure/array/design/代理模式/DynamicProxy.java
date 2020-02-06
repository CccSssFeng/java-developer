package com.data.tructure.array.design.代理模式;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements MethodInterceptor {


    public static <T> T cglibDynamicProxy(Class<T> tClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(new DynamicProxy());
        return (T) enhancer.create();
    }

    public static <T> T DynamicProxy(Object object) {
        InvocationHandler invocationHandler = new MyInvocationHandler(object);
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), invocationHandler);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before Method Invoke");
        methodProxy.invokeSuper(o, objects);
        System.out.println("After Method Invoke");
        return o;
    }

    static class MyInvocationHandler implements InvocationHandler {

        public Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(target, args);
        }

    }
}