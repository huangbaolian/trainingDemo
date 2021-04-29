package com.hbl.spring5.webflux.webflux.service;

import com.hbl.spring5.webflux.webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//用户操作接口
//Flux对象实现发布者，返回N个元素；Mono实现发布至，返回0或者1个元素

public interface UserService {
    //通过id查询用户
    Mono<User> getUserById(int id);
    //查询所有用户
    Flux<User> getAllUser();
    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
