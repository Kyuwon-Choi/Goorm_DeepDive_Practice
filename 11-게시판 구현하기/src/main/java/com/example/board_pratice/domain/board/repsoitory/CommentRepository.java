package com.example.board_pratice.domain.board.repsoitory;

import com.example.board_pratice.domain.board.entity.Board;
import com.example.board_pratice.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardAndDeletedFalse(Board board);
    @Transactional
    void deleteByBoard(Board board);
}
