package com.hbl.spring5.webflux.webflux.handler;

import com.hbl.spring5.webflux.webflux.entity.User;
import com.hbl.spring5.webflux.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class Userhandler {
    private final UserService userService;
    public Userhandler(UserService userService) {
        this.userService = userService;
    }
    //通过id查询用户
    public Mono<ServerResponse> getUserById(ServerRequest serverRequest){
        //获取id
        int id = Integer.valueOf(serverRequest.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notfound = ServerResponse.notFound().build();
        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(id);
        //把userMono进行转换返回
        //使用Reactor操作符flatMap
        return userMono
                .flatMap(person->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromObject(person)))
                .switchIfEmpty(notfound);
    };
    //查询所有用户
  public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest){
      Flux<User> user= this.userService.getAllUser();
      return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(user,User.class);
   }
    //添加用户
  public Mono<ServerResponse> saveUser(ServerRequest request){
      //获取到对象
      Mono<User> userMono = request.bodyToMono(User.class);
      return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
  }
}
