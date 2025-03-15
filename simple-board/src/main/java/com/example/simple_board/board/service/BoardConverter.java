package com.example.simple_board.board.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.simple_board.board.db.BoardEntity;
import com.example.simple_board.board.model.BoardDto;
import com.example.simple_board.post.service.PostConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDto toDto(BoardEntity boardEntity) {

        var postList = boardEntity.getPostList()
            .stream()
            .map(postEntity -> postConverter.toDto(postEntity))
            .collect(Collectors.toList());
        
        return BoardDto.builder()
            .id(boardEntity.getId())
            .boardName(boardEntity.getBoardName())
            .status(boardEntity.getStatus())
            .postList(postList)
            .build();
    }

}
