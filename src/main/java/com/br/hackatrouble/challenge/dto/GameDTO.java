package com.br.hackatrouble.challenge.dto;

import lombok.Data;

@Data
public class GameDTO {


    private String email;

    private String vote;

    private String score;

    private String amount;

    private String trem;

    private String vagao;

    public GameDTO(String email, String vote, String score, String amount) {
        this.email = email;
        this.vote = vote;
        this.score = score;
        this.amount = amount;
    }
}
