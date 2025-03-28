package com.example.simple_board.reply.service;

import org.springframework.stereotype.Service;

import com.example.simple_board.crud.Converter;
import com.example.simple_board.post.db.PostRepository;
import com.example.simple_board.reply.db.ReplyEntity;
import com.example.simple_board.reply.model.ReplyDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {

    private final PostRepository postRepository;

    @Override
    public ReplyDto toDto(ReplyEntity replyEntity) {
        return ReplyDto.builder()
            .id(replyEntity.getId())
            .postId(replyEntity.getPost().getId())
            .status(replyEntity.getStatus())
            .title(replyEntity.getTitle())
            .content(replyEntity.getContent())
            .userName(replyEntity.getUserName())
            .password(replyEntity.getPassword())
            .repliedAt(replyEntity.getRepliedAt())
            .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {
        
        var postEntity = postRepository.findById(replyDto.getPostId());

        return ReplyEntity.builder()
            .id(replyDto.getId())
            .post(postEntity.get())
            .status(replyDto.getStatus())
            .title(replyDto.getTitle())
            .content(replyDto.getContent())
            .userName(replyDto.getUserName())
            .password(replyDto.getPassword())
            .repliedAt(replyDto.getRepliedAt())
            .build();
    }
    
}
