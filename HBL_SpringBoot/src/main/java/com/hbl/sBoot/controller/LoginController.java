package com.hbl.sBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //@GetMapping
    //@PutMapping
    //@DeleteMapping
    @PostMapping(value = "/user/login")
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password
            , Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)) {
            //登录成功,为了防止表单重复提交，可以重定向到main页面
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
