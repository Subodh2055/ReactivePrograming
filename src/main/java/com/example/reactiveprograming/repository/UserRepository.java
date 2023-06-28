package com.example.reactiveprograming.repository;

import com.example.reactiveprograming.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Subodh Bhandari on 6/28/2023
 */

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
