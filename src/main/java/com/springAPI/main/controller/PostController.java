package com.springAPI.main.controller;

import com.springAPI.main.dto.PostDto;
import com.springAPI.main.entity.PostEntity;
import com.springAPI.main.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.findAllPosts();
        if(posts.isEmpty()){
            return ResponseEntity.ok().body(Collections.emptyList());
        }
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public PostEntity getPostById(@PathVariable Long id) {
        return postService.findById(id).orElse(null);
    }

    @PostMapping
    public PostEntity createPost(@RequestBody PostDto post) {
        return postService.save(post);
    }

    @PutMapping("/{id}")
    public PostEntity updatePost(@PathVariable Long id, @RequestBody PostDto post) {
        return postService.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }
}