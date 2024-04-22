package com.springAPI.main.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDto {
    private Long id;
    private UserDto user;
    @NotEmpty
    private String category;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String link;
    private String postId;
    private LocalDateTime postDate;
    private String lastId;
    private LocalDateTime lastDate;
    private List<AnswerDto> answerList;
    private List<PostReactionDto> postReactions;
    private String deleteYn;
}
