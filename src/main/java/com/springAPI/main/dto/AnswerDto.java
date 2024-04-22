package com.springAPI.main.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class AnswerDto {
    private Long id;
    private UserDto user;
    private PostDto post;
    private String content;
    private LocalDateTime answerDate;
    private String lastId;
    private LocalDateTime lastDate;
    private List<AnswerReactionDto> answerReactions;
    private AnswerDto parent; // 부모 댓글
    private List<AnswerDto> replies; // 이 댓글의 대댓글들
    private String deleteYn;
}
