package com.hbl.sBoot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Map;


//@RestController
@Controller
public class HelloController {

    /*@RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }
*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        Logger logger = LoggerFactory.getLogger(HelloController.class);
        logger.info("this is slf4j");
        return "Hello World";
    }
    //查出一些数据在页面
    @RequestMapping("/success")
    public String success(Map<String,Object> maps){
        maps.put("hello","<h1>你好</h1>");
        maps.put("users", Arrays.asList("aaa","bbb","xccc"));
        //classpath:/templates//success.html
        return "success";
    }

}
