package com.br.hackatrouble.challenge.controller;

import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
    public String olaMundo(){
        return "Ola Mundo";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody User user){
        userService.save(user);
    }
}
