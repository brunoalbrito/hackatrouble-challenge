package com.br.hackatrouble.challenge.model;

import com.br.hackatrouble.challenge.enums.Status;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Car(String number, Status status){
        this.number = number;
        this.status = Status.VAZIO;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }
}

