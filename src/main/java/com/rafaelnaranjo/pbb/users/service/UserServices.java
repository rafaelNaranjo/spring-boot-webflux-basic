package com.rafaelnaranjo.pbb.users.service;

import com.rafaelnaranjo.pbb.users.dto.User;
import com.rafaelnaranjo.pbb.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public Mono<Page<User>> findAllUser(Integer page, Integer itemsByPage){
        return Mono.fromCallable(()->userRepository.findAll(PageRequest.of(page, itemsByPage)));
    }
    public Mono<User> findUserByName(String name){
        return Mono.fromCallable(()->userRepository.findUserByName(name));
    }
}
