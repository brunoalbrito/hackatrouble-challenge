package com.br.hackatrouble.challenge.controller;

import com.br.hackatrouble.challenge.dto.TrainDTO;
import com.br.hackatrouble.challenge.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("motum/train")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TrainController {

    private final TrainService trainService;

    @PostMapping
    public ResponseEntity register(@RequestBody TrainDTO train){
        return ResponseEntity.ok(trainService.register(train));
    }

    @GetMapping
    public ResponseEntity listAll(){
        return ResponseEntity.ok(trainService.listAll());
    }
}
