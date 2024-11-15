package com.example.post.dto;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {

    private String title;

    private String contents;

    private String username;

    public CreateBoardRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    public CreateBoardRequestDto() {
    }
}
