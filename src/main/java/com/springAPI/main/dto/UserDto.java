package com.springAPI.main.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    @NotEmpty
    private String email;
    @NotEmpty
    private String name;
    @NotEmpty
    private String image;
    private LocalDateTime joinDate;
    private LocalDateTime lastDate;
    private List<PostDto> postList;
    private List<AnswerDto> answerList;
    private List<PostReactionDto> postReactions;
    private List<AnswerReactionDto> answerReactions;
}