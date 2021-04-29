package com.hbl.spring5.webflux.webflux;

import com.hbl.spring5.webflux.webflux.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

//使用webClient调用
public class WClient {
    public static void main(String[] args) {
        //调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:63327");
        //通过id查询用户

        String id = "1";
        User user = webClient.get().uri("/user/{id}",id).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(User.class).block();
        System.out.println(user.getName());

        ////查询所有用户
        Flux<User> userFlux = webClient.get().uri("/users").accept(MediaType.APPLICATION_JSON).retrieve().bodyToFlux(User.class);
        userFlux.map(user1 ->user1.getName()).buffer().doOnNext(System.out::println).blockFirst();
    }



}
