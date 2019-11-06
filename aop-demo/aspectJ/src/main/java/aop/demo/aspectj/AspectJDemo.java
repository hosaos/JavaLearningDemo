package aop.demo.aspectj;

import aop.demo.service.AopDemoServiceWithoutInterface;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: chenyin
 * @date: 2019-10-30 09:41
 */
@Aspect
public class AspectJDemo {
    // TODO: 第一个*号是指返回值不限，第二个*号是指方法名不限
    @Pointcut("execution(* aop.demo.service.AopDemoServiceWithoutInterface.*.*(..))")
    private void aspectJMethod(){};


    @Around("execution(* aop.demo.service.AopDemoServiceWithoutInterface.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{

        System.out.println("start");
        //核心逻辑
        Object retval=pjp.proceed();
        System.out.println("end");
        return retval;
    }

    public static void main(String[] args) {
        new AopDemoServiceWithoutInterface().sayHelloFinal();
    }

}
