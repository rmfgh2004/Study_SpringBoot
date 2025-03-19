package com.example.jpa.member.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.jpa.member.db.MemberEntity;
import com.example.jpa.member.db.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final MemberRepository memberRepository;

    @GetMapping("/find-all")
    public List<MemberEntity> findAll() {
        return memberRepository.findAll();
    }

    @GetMapping("/name")
    public void autoSave(
        @RequestParam String name
    ) {
        var member = MemberEntity.builder()
            .name(name)
            .build();

        memberRepository.save(member);
    }
    
}
