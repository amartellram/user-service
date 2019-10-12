package com.forceclose.microservices.user.controller;

import com.forceclose.microservices.user.domain.User;
import com.forceclose.microservices.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id){
        log.info("user service findById() for {} ", id);
        Optional<User> user = userService.findById(id);

        return user
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        Collection<User> users = null;
        users = userService.findAll();

        return users != null && users.size() > 0 ? new ResponseEntity(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) throws Exception {
        user = userService.register(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
