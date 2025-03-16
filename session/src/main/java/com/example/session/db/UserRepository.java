package com.example.session.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.session.model.UserDto;

import jakarta.annotation.PostConstruct;

@Service
public class UserRepository {
    
    private List<UserDto> userList = new ArrayList<UserDto>();

    public Optional<UserDto> findByName(String name) {
        return userList
            .stream()
            .filter(it -> it.getName().equals(name))
            .findFirst();
    }

    @PostConstruct
    public void init() {
        
        userList.add(new UserDto("홍길동", "1234"));
        userList.add(new UserDto("유관순", "1234"));
        userList.add(new UserDto("이순신", "1234"));

    }

}
