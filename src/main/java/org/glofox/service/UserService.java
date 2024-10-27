package org.glofox.service;

import org.glofox.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();

    User getUserById(Long userId);
}
