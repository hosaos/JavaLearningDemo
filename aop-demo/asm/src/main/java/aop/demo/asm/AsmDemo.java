package aop.demo.asm;



import aop.demo.service.AopDemoServiceImpl;
import aop.demo.service.AopDemoServiceWithoutInterface;
import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: chenyin
 * @date: 2019-10-29 19:10
 */
public class AsmDemo {
    public static void main(String[] args) throws IOException {
        new AopDemoServiceWithoutInterface().sayHelloFinal();
        // TODO: 读取字节码
        ClassReader classReader = new ClassReader("aop/demo/service/AopDemoServiceWithoutInterface");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        // TODO: 字节码增强
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        // TODO: 输出字节码到class文件
        File f = new File("/Users/chenyin/IdeaProjects/JavaLearningDemo/aop-demo/aop-service/target/classes/aop/demo/service/AopDemoServiceWithoutInterface.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        new AopDemoServiceWithoutInterface().sayHelloFinal();

    }

}
