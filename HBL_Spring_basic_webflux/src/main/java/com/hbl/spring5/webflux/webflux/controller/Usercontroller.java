package com.hbl.spring5.webflux.webflux.controller;

import com.hbl.spring5.webflux.webflux.entity.User;
import com.hbl.spring5.webflux.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.jws.soap.SOAPBinding;
//通过函数式，不再需要Controller
@RestController
public class Usercontroller {
    //注入service

    @Autowired
    private UserService userService;

    //通过id查询用户
    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserById(id);
    }
    //查询所有用户
    @GetMapping("/users")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }
    //添加用户
    @GetMapping("/saveUser")
    public Mono<Void> saveUsers(@PathVariable User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }
}
