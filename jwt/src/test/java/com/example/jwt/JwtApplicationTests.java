package com.example.jwt;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jwt.service.JwtService;

@SpringBootTest
class JwtApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
	}

	@Test
	void tokenCreate() {
		var claims = new HashMap<String, Object>();
		claims.put("user_id", 923);
		
		var expiredAt = LocalDateTime.now().plusSeconds(20);
		
		var jwtToken = jwtService.create(claims, expiredAt);
		System.out.println(jwtToken);
	}

	@Test
	void tokenValidation() {
		var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTc0MjIxOTkxOX0.VLxr4g4VcLAS0O6O9dUqN3KZ2GyIEpfMNZAw9rzRqM4";

		jwtService.validation(token);
	}

}
