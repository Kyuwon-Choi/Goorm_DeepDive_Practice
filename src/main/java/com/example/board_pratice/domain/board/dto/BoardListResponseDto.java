package com.example.board_pratice.domain.board.dto;

import com.example.board_pratice.domain.board.entity.Board;

public record BoardListResponseDto(
        Long id,
        String title
) {
    public BoardListResponseDto(Board board) {
        this(board.getId(), board.getTitle());
    }
}
