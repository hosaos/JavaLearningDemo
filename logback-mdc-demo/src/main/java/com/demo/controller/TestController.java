package com.demo.controller;

import com.demo.util.MdcUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: chenyin
 * @date: 2019-10-24 10:45
 */
@RequestMapping("test")
@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/log")
    public String log() {
        //模拟拦截中获取用户信息，并将用户名称写入MDC中
        try {
            MdcUtil.put("userName","chenyin");
            //能够正常日志中输出 chenyin
            logger.info("父线程处理业务");
            //子线程输出日志中不带 chenyin （ch.qos.logback.classic.util.LogbackMDCAdapter基于ThreadLocal实现）
            new Thread(() -> logger.info("子线程处理业务")).start();
        }finally {
            //需要调用clear或者remove来清除Mdc中的值
            MdcUtil.clear();
        }
        return "success";
    }

}
