package com.example.board_pratice.domain.board.service;

import com.example.board_pratice.domain.board.dto.CommentRequestDto;
import com.example.board_pratice.domain.board.dto.CommentResponseDto;
import com.example.board_pratice.domain.board.entity.Board;
import com.example.board_pratice.domain.board.entity.Comment;
import com.example.board_pratice.domain.board.repsoitory.BoardRepository;
import com.example.board_pratice.domain.board.repsoitory.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BoardRepository boardRepository;

    public CommentResponseDto createComment(Long boardId, CommentRequestDto commentRequestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        Comment comment = new Comment(commentRequestDto.content(), board);
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponseDto(savedComment);
    }

    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        comment.update(commentRequestDto.content());
        return new CommentResponseDto(comment);
    }

    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));
        comment.delete();
    }


}
