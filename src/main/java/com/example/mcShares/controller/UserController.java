package com.example.mcShares.controller;

import com.example.mcShares.model.User;
import com.example.mcShares.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that expose REST APIs for user
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserRepository userRepository;

    /**
     * @param username
     * @param password
     * @return User
     * create user in db
     */
    @PostMapping(value = {"/createUser/{username}/{password}"})
    public User createUser(@PathVariable String username, @PathVariable String password) {
        LOGGER.info("START createUser for username {}", username);
        User user = new User(username, password);
        userRepository.save(user);
        LOGGER.info("END createUser for username {}", username);
        return user;
    }
}
