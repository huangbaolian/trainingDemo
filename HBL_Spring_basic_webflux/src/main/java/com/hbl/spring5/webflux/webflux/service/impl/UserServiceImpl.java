package com.hbl.spring5.webflux.webflux.service.impl;

import com.hbl.spring5.webflux.webflux.entity.User;
import com.hbl.spring5.webflux.webflux.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserServiceImpl implements UserService {

    //创建一个map集合存储数据
    private final Map<Integer,User> userMap = new HashMap<>();

    public UserServiceImpl() {
        this.userMap.put(1,new User("aaa","男",20));
        this.userMap.put(2,new User("bbb","女",19));
        this.userMap.put(3,new User("ccc","女",18));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.userMap.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(person->{
            //向map集合里面放值
            int id = userMap.size()+1;
            userMap.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
