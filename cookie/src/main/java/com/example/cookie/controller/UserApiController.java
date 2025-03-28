package com.example.cookie.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
        HttpServletRequest httpServletRequest,

        @CookieValue(name = "authorization-cookie", required = false)
        String authorizationCookie
    ) {
        log.info("cookie : {}", authorizationCookie);

        var optionalUserDto = userRepository.findById(authorizationCookie);

        // var cookies = httpServletRequest.getCookies();
        
        // if (cookies != null) {
            
        //     for (Cookie cookie : cookies) {
        //         log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
        //     }

        // }

        return optionalUserDto.get();
    }

    @GetMapping("/me2")
    public UserDto me2(
        @RequestHeader(name = "authorization", required = false)
        String authorizationHeader
    ) {
        log.info("authorizationHeader : {}", authorizationHeader);
        var optionalUserDto = userRepository.findById(authorizationHeader);

        return optionalUserDto.get();
    }
    
}
