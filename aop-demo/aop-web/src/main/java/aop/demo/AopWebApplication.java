package aop.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopWebApplication {

    // TODO: 验证javaagent启动方式  -javaagent:/Users/chenyin/IdeaProjects/JavaLearningDemo/out/artifacts/java_agent_jar/java-agent.jar
    // TODO: 验证attach方式 调用 aop.demo.controller.TestController.attachAgentTest 接口进行attach
    public static void main(String[] args) {
        SpringApplication.run(AopWebApplication.class, args);
    }

}
