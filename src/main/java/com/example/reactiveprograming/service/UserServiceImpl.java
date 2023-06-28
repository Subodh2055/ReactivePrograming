package com.example.reactiveprograming.service;

import com.example.reactiveprograming.UserUtils;
import com.example.reactiveprograming.dto.UserDto;
import com.example.reactiveprograming.model.User;
import com.example.reactiveprograming.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Subodh Bhandari on 6/28/2023
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<User> createUser(Mono<UserDto> userDto) {
        return userDto.map(UserUtils::toUser).flatMap(userRepository::save);
    }

    @Override
    public Mono<User> retrieveUser(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Mono<User> updateUser(Long userId, Mono<UserDto> userDto) {
        return userRepository.findById(userId)
                .flatMap(user -> userDto.map(UserUtils::toUser)
                        .doOnNext(u -> u.setId(userId)))
                .flatMap(userRepository::save);
    }

    @Override
    public Mono<Void> deleteByUserId(Long userId) {
        return userRepository.deleteById(userId);
    }

    @Override
    public Flux<User> listOfUsers() {
        return userRepository.findAll();
    }
}
