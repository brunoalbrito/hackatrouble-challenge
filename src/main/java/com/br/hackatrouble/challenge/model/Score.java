package com.br.hackatrouble.challenge.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Entity
@NoArgsConstructor
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long points;

    private BigDecimal amount;


    public void addPoints(Long points){
        if(this.points == null){
            this.points = points;
        }else{
            this.points += points;
        }
    }

    public void addAmount(BigDecimal amount) {
        if (this.amount == null) {
            this.amount = amount;
        } else {
           this.amount = this.amount.add(amount);
        }
    }
}
