package com.br.hackatrouble.challenge.controller;

import com.br.hackatrouble.challenge.dto.UserDTO;
import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("motum/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user = User.of(userDTO);
        return new ResponseEntity(userService.save(user), HttpStatus.CREATED);
    }
}
