package com.example.board_pratice.domain.board.dto;

import com.example.board_pratice.domain.board.entity.Board;

public record BoardResponseDto(
        Long id,
        String title,
        String content
) {
    public BoardResponseDto(Board board) {
        this(board.getId(), board.getTitle(), board.getContent());
    }
}
