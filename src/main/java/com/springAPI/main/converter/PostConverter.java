package com.springAPI.main.converter;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.springAPI.main.dto.PostDto;
import com.springAPI.main.dto.UserDto;
import com.springAPI.main.entity.PostEntity;
import com.springAPI.main.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PostConverter {
    public static PostDto convertToPostDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setCategory(postEntity.getCategory());
        postDto.setTitle(postEntity.getTitle());
        postDto.setContent(postEntity.getContent());
        postDto.setLink(postEntity.getLink());
        postDto.setLastDate(postEntity.getLastDate());

        Optional.ofNullable(postEntity.getUser())
                .ifPresent(user -> {
                    UserDto userDto = new UserDto();
                    userDto.setName(user.getName());
                    userDto.setEmail(user.getEmail());
                    userDto.setImage(user.getImg());
                    postDto.setUser(userDto);
                });

        return postDto;
    }

    public static PostEntity createPostEntityFromDto(PostDto postDto, UserEntity userEntity) {
        return PostEntity.builder()
                .user(userEntity)
                .category(postDto.getCategory())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .link(postDto.getLink())
                .postDate(LocalDateTime.now())
                .lastId(userEntity != null ? userEntity.getEmail() : "anonymous")
                .lastDate(LocalDateTime.now())
                .build();
    }

    public static PostEntity updatePostEntityFromDto(PostDto postDto, PostEntity postEntity){
        postEntity.setCategory(postDto.getCategory());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        postEntity.setLink(postDto.getLink());
        postEntity.setLastDate(LocalDateTime.now());
        postEntity.setLastId(postDto.getUser().getEmail());
        return postEntity;
    }
}
