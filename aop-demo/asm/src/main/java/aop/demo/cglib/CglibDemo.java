package aop.demo.cglib;

import aop.demo.service.AopDemoServiceWithoutInterface;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: chenyin
 * @date: 2019-10-29 15:56
 */
public class CglibDemo {

    public static void main(String[] args) {
        CglibMethodInterceptor methodInterceptor = new CglibMethodInterceptor();
        Enhancer enhancer = new Enhancer();
        // TODO: 指定父类
        enhancer.setSuperclass(AopDemoServiceWithoutInterface.class);
        enhancer.setCallback(methodInterceptor);

        AopDemoServiceWithoutInterface proxy = (AopDemoServiceWithoutInterface)enhancer.create();
        proxy.sayHello();
        System.out.println("------------");
        proxy.sayHelloFinal();
    }
}
