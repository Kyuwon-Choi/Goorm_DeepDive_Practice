package com.example.board_pratice.domain.board.dto;

import com.example.board_pratice.domain.board.entity.Board;
import com.example.board_pratice.domain.board.entity.Comment;

import java.util.List;
import java.util.stream.Collectors;

public record BoardResponseDto(
        Long id,
        String title,
        String content,
        List<CommentResponseDto> comments
) {
    public BoardResponseDto(Board board, List<Comment> comments) {
        this(board.getId(), board.getTitle(), board.getContent(),
                comments.stream().map(CommentResponseDto::new).collect(Collectors.toList()));
    }
}
