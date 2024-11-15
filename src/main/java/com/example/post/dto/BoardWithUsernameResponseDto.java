package com.example.post.dto;

import lombok.Getter;

@Getter
public class BoardWithUsernameResponseDto {
    private Long id;

    private String title;

    private String contents;

    private String username;

    public BoardWithUsernameResponseDto(Long id, String title, String contents, String username) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
    }
}