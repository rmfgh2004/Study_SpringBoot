package com.example.simple_board.board.service;

import org.springframework.stereotype.Service;
import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.db.BoardRepository;
import com.example.simple_board.board.model.BoardRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardEntity create(
        BoardRequest boardRequest
    ) {
        var entity = BoardEntity.builder()
            .boardName(boardRequest.getBoardName())
            .status("REGISTERED")
            .build();

        return boardRepository.save(entity);
    }
    
}
