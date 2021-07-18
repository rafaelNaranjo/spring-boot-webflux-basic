package com.rafaelnaranjo.pbb.users;

import com.rafaelnaranjo.pbb.users.dto.User;
import com.rafaelnaranjo.pbb.users.service.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserServices userServices;

    @GetMapping
    public Mono<Page<User>> indexView(@RequestParam(name = "page", defaultValue = "0") Integer page, @RequestParam(name = "items", defaultValue = "15") Integer items){
        return userServices.findAllUser(page, items)
                .onErrorResume( error-> Mono.just(Page.empty()));
    }
    @GetMapping("/{name}")
    public Mono<User>getUserById(@PathVariable String name){
        return userServices.findUserByName(name)
                .onErrorResume(error -> Mono.just(new User()));
    }
}
