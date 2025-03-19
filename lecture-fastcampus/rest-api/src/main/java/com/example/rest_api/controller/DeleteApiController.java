package com.example.rest_api.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeleteApiController {

    private final PostApiController postApiController;

    DeleteApiController(PostApiController postApiController) {
        this.postApiController = postApiController;
    }
    
    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
        @PathVariable String userName
    ) {
        log.info("user-name : {}", userName);
    }

}
