package aop.demo.javaassist;

import aop.demo.service.AopDemoServiceWithoutInterface;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * @author: chenyin
 * @date: 2019-10-29 20:28
 */
public class JavaassistDemo {
    public static void main(String[] args) throws Exception {
        // TODO: 模拟Class先加载的情况
//        AopDemoServiceWithoutInterface a = new AopDemoServiceWithoutInterface();
        // TODO: 获取ClassPool
        ClassPool classPool = ClassPool.getDefault();
//        CtClass ctClass = classPool.get(AopDemoServiceWithoutInterface.class.getCanonicalName() + "");
        CtClass ctClass = classPool.get("aop.demo.service.AopDemoServiceWithoutInterface");
        // TODO: 获取sayHelloFinal方法
        CtMethod ctMethod = ctClass.getDeclaredMethod("sayHelloFinal");
        // TODO: 方法前后进行增强
        ctMethod.insertBefore("{ System.out.println(\"start\");}");
        ctMethod.insertAfter("{ System.out.println(\"end\"); }");
        // TODO: CtClass对应的字节码加载到JVM里
        Class c = ctClass.toClass();
//        ctClass.writeFile("/Users/chenyin/IdeaProjects/JavaLearningDemo/aop-demo/aop-service/target/classes/");

        AopDemoServiceWithoutInterface aopDemoServiceWithoutInterface = (AopDemoServiceWithoutInterface) c.newInstance();
        aopDemoServiceWithoutInterface.sayHelloFinal();
    }

//    public static void main(String[] args) {
//        new AopDemoServiceWithoutInterface().sayHelloFinal();
//    }

}
