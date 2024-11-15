package com.example.post.dto;

import lombok.Getter;

@Getter
public class UpdateTitleOrContentsRequestDto {
    private String oldTitle;

    private String newTitle;

    private String OldContents;

    private String newContents;

    public UpdateTitleOrContentsRequestDto(String oldTitle, String newTitle, String oldContents, String newContents) {
        this.oldTitle = oldTitle;
        this.newTitle = newTitle;
        OldContents = oldContents;
        this.newContents = newContents;
    }

    public UpdateTitleOrContentsRequestDto() {
    }
}
