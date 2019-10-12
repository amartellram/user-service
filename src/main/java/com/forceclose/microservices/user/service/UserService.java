package com.forceclose.microservices.user.service;

import com.forceclose.microservices.user.domain.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(User user);
    Optional<User> findById(String id);

    List<User> findAll();
}
