package com.example.board_pratice.domain.board.controller;

import com.example.board_pratice.domain.board.dto.BoardListResponseDto;
import com.example.board_pratice.domain.board.dto.BoardRequestDto;
import com.example.board_pratice.domain.board.dto.BoardResponseDto;
import com.example.board_pratice.domain.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@Tag(name = "board", description = "게시글 API")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Operation(summary = "게시글 작성")
    @PostMapping("/write")
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.createBoard(boardRequestDto);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping("/{id}/update")
    public BoardResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.updateBoard(id, boardRequestDto);
    }

    @Operation(summary = "게시글 목록 조회")
    @GetMapping
    public Page<BoardListResponseDto> getBoards(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return boardService.getBoards(page, size);
    }

    @Operation(summary = "게시글 단건 조회")
    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }




}
