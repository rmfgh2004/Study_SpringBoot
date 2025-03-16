package com.example.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.filter.interceptor.OpenApi;
import com.example.filter.model.UserRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @OpenApi
    @PostMapping("")
    public UserRequest register(
        @RequestBody
        UserRequest userRequest
    ) {
        log.info("{}", userRequest);
        return userRequest;
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        return "hello";
    }
    
}
