package aop.demo.service;

/**
 * @author: chenyin
 * @date: 2019-11-06 11:58
 */
public class AopDemoProxy implements AopDemoService {
    private AopDemoService targetService = new AopDemoServiceImpl();
    @Override
    public void sayHello() {
        System.out.println("start");
        targetService.sayHello();
        System.out.println("end");
    }
}
