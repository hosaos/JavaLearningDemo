package aop.demo.agent;


import java.lang.instrument.Instrumentation;

/**
 * @author: chenyin
 * @date: 2019-11-05 16:49
 */
public class JavaAgent {

    public static void premain(String agentArgs, Instrumentation instrumentation) {
        instrumentation.addTransformer(new MyClassTransformer(), true);
    }
}
