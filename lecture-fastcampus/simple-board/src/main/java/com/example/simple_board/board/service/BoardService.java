package com.example.simple_board.board.service;

import org.springframework.stereotype.Service;
import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.db.BoardRepository;
import com.example.simple_board.board.model.BoardDto;
import com.example.simple_board.board.model.BoardRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(
        BoardRequest boardRequest
    ) {
        var entity = BoardEntity.builder()
            .boardName(boardRequest.getBoardName())
            .status("REGISTERED")
            .build();

        var saveEntity = boardRepository.save(entity);

        return boardConverter.toDto(saveEntity);
    }


    public BoardDto view(Long id) {
        var entity = boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
    
}
