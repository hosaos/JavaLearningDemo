package aop.demo.agent;

import aop.demo.service.AopDemoServiceWithoutInterface;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author: chenyin
 * @date: 2019-11-05 16:49
 */
public class AttachAgent {

    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MyClassTransformer(), true);
        try {
            // TODO: 重新对类加载 触发MyClassTransformer
            instrumentation.retransformClasses(AopDemoServiceWithoutInterface.class);
            System.out.println("attach agent 加载完毕");
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        }
    }
}
