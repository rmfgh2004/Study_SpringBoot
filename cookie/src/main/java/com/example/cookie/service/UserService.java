package com.example.cookie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String login(
        LoginRequest loginRequest,
        HttpServletResponse response
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();
        
        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();
            
            if (userDto.getPassword().equals(pw)) {
                return userDto.getId();
            } else {
                throw new RuntimeException("Password Not Match");    
            }
        } else {
            return null;
            // throw new RuntimeException("User Not Found");
        }
    }
    
}
