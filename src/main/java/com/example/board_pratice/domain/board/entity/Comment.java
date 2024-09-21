package com.example.board_pratice.domain.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Long boardId;

    private boolean deleted = false;

    public Comment(String content, Long boardId) {
        this.content = content;
        this.boardId = boardId;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Long getBoardId() {
        return boardId;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
