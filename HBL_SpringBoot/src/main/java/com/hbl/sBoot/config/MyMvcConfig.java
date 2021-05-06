package com.hbl.sBoot.config;

import com.hbl.sBoot.component.LoginHandlerInterceptor;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import sun.rmi.runtime.Log;

//使用WebMvcConfigurerAdapter可以扩展SpringMVC功能
//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hbl").setViewName("success");
    }
    //所有的WebMvcConfigurerAdapter组件都会一起作用
    @Bean//将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer(){

       WebMvcConfigurer adapter = new WebMvcConfigurer() {
           @Override
           public void addViewControllers(ViewControllerRegistry registry) {
               registry.addViewController("/").setViewName("login");
               registry.addViewController("/index.html").setViewName("login");
               registry.addViewController("/main.html").setViewName("dashboard");
           }
           //注册拦截器
          /* @Override
           public void addInterceptors(InterceptorRegistry registry) {
               registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                       .excludePathPatterns("/index.html","/","/user/login","asserts/**","/webjars/**");
           }*/
       };
       return adapter;
    }

}
