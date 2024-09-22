package com.example.board_pratice.domain.board.service;

import com.example.board_pratice.domain.board.dto.BoardListResponseDto;
import com.example.board_pratice.domain.board.dto.BoardRequestDto;
import com.example.board_pratice.domain.board.dto.BoardResponseDto;
import com.example.board_pratice.domain.board.entity.Board;
import com.example.board_pratice.domain.board.entity.Comment;
import com.example.board_pratice.domain.board.repsoitory.BoardRepository;
import com.example.board_pratice.domain.board.repsoitory.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private CommentRepository commentRepository;

    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto.title(), boardRequestDto.content());
        Board savedBoard = boardRepository.save(board);
        return new BoardResponseDto(savedBoard, List.of());
    }

    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        List<Comment> comments = commentRepository.findByBoardAndDeletedFalse(board);
        return new BoardResponseDto(board, comments);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        board.update(boardRequestDto.title(), boardRequestDto.content());
        return new BoardResponseDto(board, List.of());
    }

    public Page<BoardListResponseDto> getBoards(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate")); // 최신순 정렬 추가
        return boardRepository.findByDeletedFalse(pageable)
                .map(BoardListResponseDto::new);
    }







}
