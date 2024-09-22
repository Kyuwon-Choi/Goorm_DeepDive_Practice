package com.example.board_pratice.domain.board.controller;

import com.example.board_pratice.domain.board.dto.CommentRequestDto;
import com.example.board_pratice.domain.board.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards/{boardId}/comments")
@Tag(name = "comment", description = "댓글 API")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Operation(summary = "댓글 작성")
    @PostMapping
    public void createComment(@PathVariable Long boardId, @RequestBody CommentRequestDto requestDto) {
        commentService.createComment(boardId, requestDto);
    }

    @Operation(summary = "댓글 수정")
    @PutMapping("/{id}")
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        commentService.updateComment(id, requestDto);
    }

    @Operation(summary = "댓글 삭제")
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }

}
