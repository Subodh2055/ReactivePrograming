package com.example.reactiveprograming.service;

import com.example.reactiveprograming.dto.UserDto;
import com.example.reactiveprograming.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Subodh Bhandari on 6/28/2023
 */

public interface UserService {

    Mono<User> createUser(Mono<UserDto> userDto);

    Mono<User> retrieveUser(Long userId);

    Mono<User> updateUser(Long userId, Mono<UserDto> userDto);

    Mono<Void> deleteByUserId(Long userId);

    Flux<User> listOfUsers();
}
