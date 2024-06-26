package com.springAPI.main.service;

import com.springAPI.main.dto.PostDto;
import com.springAPI.main.entity.PostEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface PostService {
    PostEntity save(PostDto post);
    PostDto create(PostDto post);
    PostDto update(PostDto post);
    PostDto findById(Long id);
    List<PostEntity> findAll();
    void deleteById(Long id);
    List<PostDto> findAllPosts();
}