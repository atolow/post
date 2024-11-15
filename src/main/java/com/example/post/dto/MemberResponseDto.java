package com.example.post.dto;

import com.example.post.entity.Member;
import lombok.Getter;



@Getter
public class MemberResponseDto {
    private Long id;
    private String username;
    private String email;

    public MemberResponseDto() {
    }

    public MemberResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static MemberResponseDto toDto(Member member){
        return new MemberResponseDto(member.getId(),member.getUsername(), member.getEmail());
    }
}
