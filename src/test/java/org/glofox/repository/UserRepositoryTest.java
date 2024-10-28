package org.glofox.repository;

import org.glofox.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRepositoryTest {
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    public void save_ShouldAddUser_WhenCalled() {
        User user = new User(1L, "john.doe", "password");
        userRepository.save(user);

        assertEquals(1, userRepository.findAll().size());
        assertEquals(user, userRepository.findAll().get(0));
    }

    @Test
    public void findAll_ShouldReturnAllUsers() {
        User user1 = new User(1L, "john.doe", "password");
        User user2 = new User(2L, "jane.doe", "password");

        userRepository.save(user1);
        userRepository.save(user2);

        assertEquals(2, userRepository.findAll().size());
    }

    @Test
    public void findUserById_ShouldReturnUser_WhenExists() {
        User user = new User(1L, "john.doe", "password");
        userRepository.save(user);

        User foundUser = userRepository.findUserById(1L);

        assertEquals(user, foundUser);
    }


}
