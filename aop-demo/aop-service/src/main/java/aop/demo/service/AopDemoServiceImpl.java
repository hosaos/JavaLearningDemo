package aop.demo.service;

/**
 * @author: chenyin
 * @date: 2019-10-29 15:05
 */
public class AopDemoServiceImpl implements AopDemoService  {
    @Override
    public void sayHello() {
        System.out.println("hello this is aop demo service");
    }
}
