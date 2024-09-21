package com.example.board_pratice.domain.board.repsoitory;

import com.example.board_pratice.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
