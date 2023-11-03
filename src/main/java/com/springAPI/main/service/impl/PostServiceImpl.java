package com.springAPI.main.service.impl;

import com.springAPI.main.dto.PostDto;
import com.springAPI.main.dto.UserDto;
import com.springAPI.main.entity.PostEntity;
import com.springAPI.main.entity.UserEntity;
import com.springAPI.main.repository.PostRepository;
import com.springAPI.main.repository.UserRepository;
import com.springAPI.main.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PostEntity save(PostDto post) {
        UserDto user = post.getUser();
        Optional<UserEntity> existingUserOpt = userRepository.findByEmail(user.getEmail());
        if(existingUserOpt.isPresent()){
            UserEntity userEntity = existingUserOpt.get();
            PostEntity postEntity = PostEntity.builder()
                    .user(userEntity)
                    .title(post.getTitle())
                    .content(post.getContent())
                    .link(post.getLink())
                    .postDate(LocalDateTime.now())
                    .lastId(user.getEmail())
                    .lastDate(LocalDateTime.now())
                    .build();
            return postRepository.save(postEntity);
        }else{
            PostEntity postEntity = PostEntity.builder()
                    .title(post.getTitle())
                    .content(post.getContent())
                    .link(post.getLink())
                    .postDate(LocalDateTime.now())
                    .lastId("anonymous")
                    .lastDate(LocalDateTime.now())
                    .build();
            return postRepository.save(postEntity);
        }

    }

    @Override
    public Optional<PostEntity> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostDto> findAllPosts() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private PostDto convertToDTO(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setTitle(postEntity.getTitle());
        postDto.setContent(postEntity.getContent());
        postDto.setLink(postEntity.getLink());

        if (postEntity.getUser() != null) {
            UserDto userDto = new UserDto();
            userDto.setName(postEntity.getUser().getName());
            userDto.setEmail(postEntity.getUser().getEmail());
            userDto.setImage(postEntity.getUser().getImg());

            postDto.setUser(userDto); // PostDto에 UserDto를 설정합니다.
        }

        return postDto;
    }
}

