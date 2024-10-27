package org.glofox.repository;

import org.glofox.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public User findUserById(Long userId)
    {
        return users.stream().filter(user->
            user.getId().equals(userId)).findFirst().get();
    }

}
