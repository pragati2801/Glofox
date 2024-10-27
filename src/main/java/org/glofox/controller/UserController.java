package org.glofox.controller;

import lombok.extern.slf4j.Slf4j;
import org.glofox.model.User;
import org.glofox.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("v1/user")
public class UserController {
    @Autowired UserService userService;

    @GetMapping()
    public ResponseEntity<User> getUser(@RequestParam("userId")  Long userId )
    {
        return ResponseEntity.ok(userService.getUserById(userId));

    }

    @PostMapping()
  public ResponseEntity<User> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.createUser(user));

    }
    @GetMapping("/allUSers")
    public ResponseEntity<List<User>> getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }


}
