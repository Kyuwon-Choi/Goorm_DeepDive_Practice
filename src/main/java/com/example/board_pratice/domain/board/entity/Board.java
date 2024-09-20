package com.example.board_pratice.domain.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Board {
    @Id
    private Long id;
    private String title;
    private String content;
}
