package com.rafaelnaranjo.pbb.users;

import com.rafaelnaranjo.pbb.users.dto.User;
import com.rafaelnaranjo.pbb.users.repository.UserRepository;
import com.rafaelnaranjo.pbb.users.service.UserServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = UsersController.class)
@Import(UserServices.class)
@AutoConfigureWebTestClient(timeout = "10000")
class UsersControllerTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private WebTestClient webClient;

    @Test
    public void getAllUserPaginateTest(){
        User user = User.builder().name("Rafael").lastname("Naranjo").birthdate(new Date()).build();
        when(userRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(Arrays.asList(user)));
        webClient.get()
                .uri("/users")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isNotEmpty();
        verify(userRepository, times(1)).findAll((Pageable) any());
    }

    @Test
    public void getAllUserPaginateTestError(){
        when(userRepository.findAll((Pageable) any())).thenThrow(new NullPointerException());
        webClient.get()
                .uri("/users")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isEmpty();
        verify(userRepository, times(1)).findAll((Pageable) any());
    }

    @Test
    public void getUserByName(){
        User user = User.builder().name("Rafael").lastname("Naranjo").birthdate(new Date()).build();
        when(userRepository.findUserByName(anyString())).thenReturn(user);
        webClient.get()
                .uri("/users/Rafael")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isNotEmpty();
        verify(userRepository, times(1)).findUserByName(anyString());
    }

    @Test
    public void getUserByNameError(){
        User user = User.builder().name("Rafael").lastname("Naranjo").birthdate(new Date()).build();
        when(userRepository.findUserByName(anyString())).thenThrow(new NullPointerException());
        webClient.get()
                .uri("/users/Rafael")
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEmpty();
        verify(userRepository, times(1)).findUserByName(anyString());
    }
}