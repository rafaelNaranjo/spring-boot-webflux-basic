package com.rafaelnaranjo.pbb.users.service;

import com.rafaelnaranjo.pbb.users.dto.User;
import com.rafaelnaranjo.pbb.users.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserServicesTest {
    @InjectMocks
    private UserServices userServices;
    @Mock
    private UserRepository userRepository;

    @Test
    void findAllUserTest() {
        User user = User.builder().name("Rafael").lastname("Naranjo").birthdate(new Date()).build();
        when(userRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(Arrays.asList(user)));
        Mono<Page<User>> response = userServices.findAllUser(0,15);
        response.subscribe(u->assertNotNull(u.getContent()));
        verify(userRepository, times(1)).findAll((Pageable) any());
    }

    @Test
    void findUserByNameTest() {
        User user = User.builder().name("Rafael").lastname("Naranjo").birthdate(new Date()).build();
        when(userRepository.findUserByName(anyString())).thenReturn(user);
        Mono<User> response = userServices.findUserByName(anyString());
        response.subscribe(p->assertNotNull(p.getName()));
        verify(userRepository, times(1)).findUserByName(anyString());
    }
}