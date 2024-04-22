package com.springAPI.main.service.impl;

import com.springAPI.main.converter.PostConverter;
import com.springAPI.main.dto.PostDto;
import com.springAPI.main.dto.UserDto;
import com.springAPI.main.entity.PostEntity;
import com.springAPI.main.entity.UserEntity;
import com.springAPI.main.repository.PostRepository;
import com.springAPI.main.repository.UserRepository;
import com.springAPI.main.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public PostEntity save(PostDto postDto) {
        UserDto user = postDto.getUser();
        UserEntity userEntity = userRepository.findByEmail(user.getEmail())
                .orElseGet(() -> null);
        PostEntity postEntity = postRepository.findById(postDto.getId())
                .map(existingPost->PostConverter.updatePostEntityFromDto(postDto,existingPost))
                .orElseGet(()->PostConverter.createPostEntityFromDto(postDto,userEntity));
        return postRepository.save(postEntity);
    }
    @Override
    @Transactional
    public PostDto create(PostDto postDto) {
        UserDto user = postDto.getUser();
        UserEntity userEntity = userRepository.findByEmail(user.getEmail())
                .orElseGet(() -> null);
        PostEntity postEntity = PostConverter.createPostEntityFromDto(postDto,userEntity);
        PostEntity savePost = postRepository.save(postEntity);
        return PostConverter.convertToPostDto(savePost);
    }

    @Override
    @Transactional
    public PostDto update(PostDto postDto) {
        UserDto user = postDto.getUser();
        PostEntity postEntity = postRepository.findById(postDto.getId())
                .map(existingPost->PostConverter.updatePostEntityFromDto(postDto,existingPost))
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + postDto.getId()));
        PostEntity savePost = postRepository.save(postEntity);
        return PostConverter.convertToPostDto(savePost);
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id)
                .map(PostConverter::convertToPostDto)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id " + id));
    }

    @Override
    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities.stream()
                .map(PostConverter::convertToPostDto)
                .collect(Collectors.toList());
    }
}

