package com.springAPI.main.converter;

import com.springAPI.main.dto.UserDto;
import com.springAPI.main.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class UserConverter {
    public static UserEntity createUserEntityFromDto(UserDto userDto) {
        return UserEntity.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .img(userDto.getImage())
                .joinDate(LocalDateTime.now()) // 새로운 사용자의 가입 날짜 설정
                .lastDate(LocalDateTime.now()) // 마지막 날짜 설정
                .build();
    }

    public static UserEntity updateUserEntityFromDto(UserDto userDto, UserEntity existingUser) {
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setImg(userDto.getImage());
        existingUser.setLastDate(LocalDateTime.now()); // 마지막 날짜 업데이트
        return existingUser;
    }
}
