package com.example.board_pratice.domain.board.dto;

import com.example.board_pratice.domain.board.entity.Comment;

public record CommentResponseDto(
        Long id,
        String content
) {
    public CommentResponseDto(Comment comment) {
        this(comment.getId(), comment.getContent());

    }
}
