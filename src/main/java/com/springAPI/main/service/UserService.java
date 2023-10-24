package com.springAPI.main.service;

import com.springAPI.main.entity.UserEntity;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserEntity save(UserEntity user);
    Optional<UserEntity> findById(Long id);
    List<UserEntity> findAll();
    void deleteById(Long id);
}