package duboo.demo.controller;

import dubbo.demo.api.IDemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: chenyin
 * @date: 2019/12/20 下午2:39
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Reference(loadbalance = RandomLoadBalance.NAME,version = "${dubbo.service.version}",timeout = 3000)
    private IDemoService demoService;

    @Value("${dubbo.service.version}")
    private String dubboVersion;

    @GetMapping(value = "/flowRule")
    public String flowRule() {
        return "flowRule";
    }
    @GetMapping(value = "/degradeRule")
    public String degradeRule() {
        return "degradeRule";
    }
    @GetMapping(value = "/dubboTest")
    public String dubboTest() {
        return demoService.sayHello();
    }
    @GetMapping(value = "/read")
    public String read(Long userId) {
        System.out.println(demoService.read(userId));
        return "";
    }
    @GetMapping(value = "/write")
    public String write(Long userId) {
        System.out.println(demoService.write(userId));
        return "";
    }
}
