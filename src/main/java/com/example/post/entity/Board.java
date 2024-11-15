package com.example.post.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board(String title, String contents,String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;

    }

    public Board() {
    }

    public void setMember(Member member) {
        this.member = member;
    }
    public void updateTitleOrContents(String title,String contents) {
        this.title = title;
        this.contents=contents;
    }
}
