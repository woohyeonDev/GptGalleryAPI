package com.springAPI.main.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private String link;
    private UserDto user;
}
