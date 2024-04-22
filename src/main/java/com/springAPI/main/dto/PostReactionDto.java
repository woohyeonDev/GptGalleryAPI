package com.springAPI.main.dto;


import com.springAPI.main.entity.ReactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class PostReactionDto {
    private Long id;
    private UserDto user;
    private PostDto post;
    private ReactionType type;
    private LocalDateTime reactionDate;
}
