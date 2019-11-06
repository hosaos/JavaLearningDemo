package aop.demo.agent;

import aop.demo.service.AopDemoServiceWithoutInterface;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author: chenyin
 * @date: 2019-11-05 16:49
 */
public class JavaAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MyClassTransformer(), true);
//        try {
//            // TODO:
//            instrumentation.retransformClasses(AopDemoServiceWithoutInterface.class);
//            System.out.println("java agent 加载完毕");
//        } catch (UnmodifiableClassException e) {
//            e.printStackTrace();
//        }
    }
}
