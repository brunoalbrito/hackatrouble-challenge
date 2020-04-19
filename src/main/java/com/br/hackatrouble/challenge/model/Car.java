package com.br.hackatrouble.challenge.model;

import com.br.hackatrouble.challenge.enums.Status;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Car(String number, Status status){
        this.status = Status.VAZIO;
    }
}
