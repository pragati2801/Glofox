package org.glofox.service.impl;

import lombok.extern.slf4j.Slf4j;


import org.glofox.model.User;
import org.glofox.repository.UserRepository;
import org.glofox.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        log.info("Creating a new user: {}", user.getName());
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        log.info("Fetching all users");
        return userRepository.findUserById(userId);
    }
}
