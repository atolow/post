package com.example.post.dto;

import lombok.Getter;

@Getter
public class SignResponseMemberDto {
    private Long id;

    private String username;

    private String password;

    private String email;

    public SignResponseMemberDto(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
