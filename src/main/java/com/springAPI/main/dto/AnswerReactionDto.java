package com.springAPI.main.dto;


import com.springAPI.main.entity.ReactionType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class AnswerReactionDto {
    private Long id;
    private UserDto user;
    private AnswerDto answer;
    private ReactionType type;
    private LocalDateTime reactionDate;
}
