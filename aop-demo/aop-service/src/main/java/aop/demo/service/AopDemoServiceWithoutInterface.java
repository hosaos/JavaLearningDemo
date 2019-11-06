package aop.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author: chenyin
 * @date: 2019-10-29 15:05
 */
@Service
public class AopDemoServiceWithoutInterface {
    public void sayHello() {
        System.out.println("hello(normal method)");
    }

    public final void sayHelloFinal() {
        System.out.println("hello(final method)");
    }
}
