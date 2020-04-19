package com.br.hackatrouble.challenge.controller;

import com.br.hackatrouble.challenge.dto.GameDTO;
import com.br.hackatrouble.challenge.dto.RankDTO;
import com.br.hackatrouble.challenge.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("motum/game")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GameController {

    private final GameService gameService;

    @PostMapping
    public ResponseEntity receiveVote(@RequestBody GameDTO gameDTO){
        GameDTO game = gameService.receiveVote(gameDTO);
        return game != null ? ResponseEntity.ok(game) : ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping("rank")
    public ResponseEntity rank(){
        return ResponseEntity.ok(gameService.rank());
    }
}
