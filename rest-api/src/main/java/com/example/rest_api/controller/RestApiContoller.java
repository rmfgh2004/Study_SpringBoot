package com.example.rest_api.controller;

import com.example.rest_api.RestApiApplication;
import com.example.rest_api.model.BookQueryParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiContoller {

    private final RestApiApplication restApiApplication;

    RestApiContoller(RestApiApplication restApiApplication) {
        this.restApiApplication = restApiApplication;
    }

    @GetMapping(path = "/hello")
    public String hello() {
        var html = "<html> <body> <h1> Hello Spring Boot </h1> </body> </html>";

        return html;
    }

    // Path Variable
    @GetMapping("/echo/{message}")
    public String echo(
        @PathVariable(name = "message") String msg
    ) {
        System.out.println("echo message : " + msg);

        return msg;
    }

    @GetMapping(path = "/book")
    public void queryParam(
        @RequestParam String category,
        @RequestParam String issuedYear,
        @RequestParam(name = "issued-month") String issuedMonth,
        @RequestParam(name = "issued_day") String issuedDay
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParamDto(
        BookQueryParam bookQueryParam
    ) {
        System.out.println(bookQueryParam);
    }

}