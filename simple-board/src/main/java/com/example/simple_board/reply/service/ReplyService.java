package com.example.simple_board.reply.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simple_board.crud.CRUDAbstractService;
import com.example.simple_board.post.db.PostRepository;
import com.example.simple_board.reply.db.ReplyEntity;
import com.example.simple_board.reply.db.ReplyRepository;
import com.example.simple_board.reply.model.ReplyDto;
import com.example.simple_board.reply.model.ReplyRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService extends CRUDAbstractService<ReplyDto, ReplyEntity> {

    // private final ReplyRepository replyRepository;
    // private final PostRepository postRepository;

    // public ReplyEntity create(
    //     ReplyRequest replyRequest
    // ) {

    //     var postEntity = postRepository.findById(replyRequest.getPostId()).get();

    //     var entity = ReplyEntity.builder()
    //         .post(postEntity)
    //         .userName(replyRequest.getUserName())
    //         .password(replyRequest.getPassword())
    //         .status("REGISTERED")
    //         .title(replyRequest.getTitle())
    //         .content(replyRequest.getContent())
    //         .repliedAt(LocalDateTime.now())
    //         .build();

    //     return replyRepository.save(entity);
    // }

    // public List<ReplyEntity> findAllByPostId(Long postId) {
    //     return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
    // }
    
}
