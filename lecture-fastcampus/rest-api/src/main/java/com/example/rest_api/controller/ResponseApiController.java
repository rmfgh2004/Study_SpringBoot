package com.example.rest_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_api.model.UserRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api/v1")
public class ResponseApiController {

    // http://localhost:8080/api/v1
    //@RequestMapping(path = "", method = RequestMethod.GET)
    @GetMapping("")
    @ResponseBody
    public UserRequest user() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("gmail.com");

        log.info("user: {}", user);

        var response = ResponseEntity
            .status(HttpStatus.OK)
            .body(user);

        return user;
    }

}