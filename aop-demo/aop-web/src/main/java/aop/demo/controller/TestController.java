package aop.demo.controller;

import aop.demo.service.AopDemoServiceWithoutInterface;
import com.sun.tools.attach.VirtualMachine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author: chenyin
 * @date: 2019-10-24 10:45
 */
@RequestMapping("test")
@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private AopDemoServiceWithoutInterface aopDemoServiceWithoutInterface;

    @GetMapping("/javaAgentTest")
    public String javaAgentTest() {
        aopDemoServiceWithoutInterface.sayHelloFinal();
        return "success";
    }
    @GetMapping("/attachAgentTest")
    public String attachAgentTest(String pid) throws Exception {
        if (StringUtils.isEmpty(pid)) {
            return "pid can not be empty";
        }
        VirtualMachine vm = VirtualMachine.attach(pid);
        vm.loadAgent("/Users/chenyin/IdeaProjects/JavaLearningDemo/out/artifacts/attach_agent_jar/attach-agent.jar");
        vm.detach();
        return "success";
    }

}
