package com.example.post.dto;

import com.example.post.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private Long id;

    private String title;

    private String contents;

    private String username;

    public BoardResponseDto(Long id, String title, String contents, String username) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

    public static BoardResponseDto toDto(Board board){
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents(), board.getUsername());
    }
}