package com.springAPI.main.controller;

import com.springAPI.main.entity.PostEntity;
import com.springAPI.main.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<PostEntity> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostEntity getPostById(@PathVariable Long id) {
        return postService.findById(id).orElse(null);
    }

    @PostMapping
    public PostEntity createPost(@RequestBody PostEntity post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public PostEntity updatePost(@PathVariable Long id, @RequestBody PostEntity post) {
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }
}