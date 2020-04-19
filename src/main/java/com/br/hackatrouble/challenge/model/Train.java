package com.br.hackatrouble.challenge.model;


import com.br.hackatrouble.challenge.dto.TrainDTO;
import com.br.hackatrouble.challenge.enums.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    private String lineName;

    @Setter
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Car> cars;

    public Train(String number, String lineName) {
        this.number = number;
        this.lineName = lineName;
    }

    public TrainDTO convertToDTO() {
        return new TrainDTO(this.number, this.cars.size(), this.lineName);
    }
}
