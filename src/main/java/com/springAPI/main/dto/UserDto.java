package com.springAPI.main.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

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
}
