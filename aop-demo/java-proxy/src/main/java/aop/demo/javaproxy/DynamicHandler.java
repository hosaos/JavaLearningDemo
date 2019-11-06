package aop.demo.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: chenyin
 * @date: 2019-10-29 15:09
 */
public class DynamicHandler implements InvocationHandler {
    private Object target;

    public DynamicHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start");
        Object result = method.invoke(target, args);
        System.out.println("end");
        return result;
    }
}
