package com.salad.lib.util.proxy;


import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cuishifeng
 * @date 2019-05-16
 */
public class CGLIBDynamicProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o, objects);
    }

    public static <T> T proxy(Class<T> clazz) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new CGLIBDynamicProxy());
        return (T) enhancer.create();
    }


    public static void main(String[] args) {

        HelloService helloService = proxy(HelloServiceImpl.class);
        String s = helloService.sayHello("cui");
        System.out.println(s);
        String name = helloService.getName("123");
        System.out.println(name);


    }
}
