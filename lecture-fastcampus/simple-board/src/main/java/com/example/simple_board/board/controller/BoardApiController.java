package com.example.simple_board.board.controller;

import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.model.BoardDto;
import com.example.simple_board.board.model.BoardRequest;
import com.example.simple_board.board.service.BoardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;
    
    @PostMapping("")
    public BoardDto create(
        @Valid
        @RequestBody
        BoardRequest boardRequest
    ) {
        
        return boardService.create(boardRequest);
    }

    @GetMapping("/id/{id}")
    public BoardDto view(
        @PathVariable Long id
    ) {
        var entity = boardService.view(id);
        log.info("board : {}", entity);
        return entity;
    }
}
