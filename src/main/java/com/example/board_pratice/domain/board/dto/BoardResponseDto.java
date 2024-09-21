package com.example.board_pratice.domain.board.dto;

public record BoardResponseDto(
        Long id,
        String title,
        String content
) {
}
