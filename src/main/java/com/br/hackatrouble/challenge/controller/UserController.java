package com.br.hackatrouble.challenge.controller;

import com.br.hackatrouble.challenge.dto.UserDTO;
import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("motum/user")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody UserDTO userDTO){
        User user = userService.save(userDTO);
        return new ResponseEntity(userDTO.convertToUserDTO(user), HttpStatus.CREATED);
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity validadeUserRegister(@RequestBody UserDTO userDTO) {
        Optional<User> user = userService.validadeUserRegister(userDTO);
        if(user.isPresent()){
            User userResponse = user.get();
            return ResponseEntity.ok(userDTO.convertToUserDTO(userResponse));
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
}
