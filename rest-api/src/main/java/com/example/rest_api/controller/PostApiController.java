package com.example.rest_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_api.model.BookRequst;

@RestController
@RequestMapping("/api")
public class PostApiController {
    
    @PostMapping("/post")
    public BookRequst post(
        @RequestBody BookRequst bookRequst
    ) {
        System.out.println(bookRequst);
        return bookRequst;
    }

}
