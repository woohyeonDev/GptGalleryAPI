package com.springAPI.main.service.impl;

import com.springAPI.main.converter.UserConverter;
import com.springAPI.main.dto.UserDto;
import com.springAPI.main.entity.UserEntity;
import com.springAPI.main.repository.UserRepository;
import com.springAPI.main.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = userRepository.findByEmail(userDto.getEmail())
                .map(existingUser -> UserConverter.updateUserEntityFromDto(userDto, existingUser))
                .orElseGet(() -> UserConverter.createUserEntityFromDto(userDto));

        return userRepository.save(userEntity);
    }


    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
