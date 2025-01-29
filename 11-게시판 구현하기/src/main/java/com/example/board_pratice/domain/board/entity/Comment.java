package com.example.board_pratice.domain.board.entity;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    public Comment(String content, Board board) {
        this.content = content;
        this.board = board;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void update(String content) {
        this.content = content;
    }

    public void delete() {
        this.deleted = true;
    }
}
