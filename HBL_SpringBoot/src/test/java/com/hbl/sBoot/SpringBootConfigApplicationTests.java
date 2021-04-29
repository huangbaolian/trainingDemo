package com.hbl.sBoot;

import com.hbl.sBoot.bean.Person;
import com.hbl.sBoot.controller.HelloController;
import com.hbl.sBoot.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Springboot单元测试
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTests {
    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;
    @Test
    public void contextLoads(){
        Logger logger = LoggerFactory.getLogger(getClass());
        //由低到高trace<debug<info<warn<error由低到高trace<debug<info<warn<error
        //以后可以调整日志级别
        logger.trace("this is trace");
        logger.debug("this is debug");
        logger.info("this is info");
        logger.warn("this is warn");
        logger.error("this is error");
        //System.out.println(person);
    }
    @Test
    public void testHelloService(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

}
