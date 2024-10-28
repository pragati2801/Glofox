package org.glofox.controller;

import org.glofox.model.User;
import org.glofox.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getUser_ShouldReturnUser_WhenUserExists() {
        User user = new User(1L, "John Doe", "1234567890");
        when(userService.getUserById(1L)).thenReturn(user);

        ResponseEntity<User> response = userController.getUser(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    public void createUser_ShouldReturnCreatedUser() {
        User user = new User(null, "Jane Doe", "0987654321");
        User createdUser = new User(2L, "Jane Doe", "0987654321");
        when(userService.createUser(any(User.class))).thenReturn(createdUser);

        ResponseEntity<User> response = userController.createUser(user);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(createdUser, response.getBody());
        verify(userService, times(1)).createUser(user);
    }

    @Test
    public void getAllUser_ShouldReturnListOfUsers() {
        User user1 = new User(1L, "John Doe", "1234567890");
        User user2 = new User(2L, "Jane Doe", "0987654321");
        List<User> users = Arrays.asList(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        ResponseEntity<List<User>> response = userController.getAllUser();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(users, response.getBody());
        verify(userService, times(1)).getAllUsers();
    }

}
