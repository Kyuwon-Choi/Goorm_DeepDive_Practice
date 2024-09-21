package com.example.board_pratice.domain.board.service;

import com.example.board_pratice.domain.board.dto.BoardRequestDto;
import com.example.board_pratice.domain.board.dto.BoardResponseDto;
import com.example.board_pratice.domain.board.entity.Board;
import com.example.board_pratice.domain.board.repsoitory.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto.title(), boardRequestDto.content());
        Board savedBoard = boardRepository.save(board);
        return new BoardResponseDto(savedBoard);
    }

    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        board.update(boardRequestDto.title(), boardRequestDto.content());
        return new BoardResponseDto(board);
    }

    public Page<BoardResponseDto> getBoards(int page, int size) {
        return boardRepository.findAll(PageRequest.of(page, size)).map(BoardResponseDto::new);
    }






}
