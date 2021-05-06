package com.hbl.sBoot.controller;

import com.hbl.sBoot.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    //浏览器,客户端都返回json
  /*  @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> HandleException(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        return map;
    }*/


    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code","user.notexist");
        map.put("message","出错了");
        request.setAttribute("add",map);
        return "forward:/error";
    }


}
