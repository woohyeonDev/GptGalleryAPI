package com.springAPI.main.controller;

import com.springAPI.main.dto.UserDto;
import com.springAPI.main.entity.UserEntity;
import com.springAPI.main.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String email) {
        return userService.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Consider using ResponseEntity for proper handling.
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@Valid  @RequestBody UserDto user) {
        UserEntity savedUser =  userService.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @Valid  @RequestBody UserDto user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
