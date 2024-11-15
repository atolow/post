package com.example.post.dto;

import lombok.Getter;

@Getter
public class SignRequestMemberDto {
    private String username;

    private String password;

    private String email;

    public SignRequestMemberDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
