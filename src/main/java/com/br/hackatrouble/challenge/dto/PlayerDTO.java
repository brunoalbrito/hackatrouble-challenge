package com.br.hackatrouble.challenge.dto;

import com.br.hackatrouble.challenge.model.Score;
import lombok.Data;

@Data
public class PlayerDTO {

    private String name;

    private Long score;

    public PlayerDTO(String name, Score score) {
        this.name = name;
        if(score != null) {
            this.score = score.getPoints();
        }
    }
}
