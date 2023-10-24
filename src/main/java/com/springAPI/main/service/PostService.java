package com.springAPI.main.service;

import com.springAPI.main.entity.PostEntity;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostEntity save(PostEntity postEntity);
    Optional<PostEntity> findById(Long id);
    List<PostEntity> findAll();
    void deleteById(Long id);
}