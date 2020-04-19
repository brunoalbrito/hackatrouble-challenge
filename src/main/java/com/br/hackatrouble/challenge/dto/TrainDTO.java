package com.br.hackatrouble.challenge.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrainDTO {

    private String number;

    private Integer qtdCars;

    @JsonProperty(value = "line_name")
    private String lineName;
}
