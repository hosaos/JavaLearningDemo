package aop.demo.javaproxy;

import aop.demo.service.AopDemoService;
import aop.demo.service.AopDemoServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: chenyin
 * @date: 2019-10-29 15:02
 */
public class JavaproxyDemo {

    public static void main(String[] args) {
        InvocationHandler handler = new DynamicHandler(new AopDemoServiceImpl());

        AopDemoService proxyService = (AopDemoService) Proxy.newProxyInstance(AopDemoService.class.getClassLoader(),
                AopDemoServiceImpl.class.getInterfaces(), handler);
        proxyService.sayHello();
    }

}
