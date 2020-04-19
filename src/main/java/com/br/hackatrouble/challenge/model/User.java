package com.br.hackatrouble.challenge.model;

import com.br.hackatrouble.challenge.dto.GameDTO;
import com.br.hackatrouble.challenge.dto.UserDTO;
import com.br.hackatrouble.challenge.enums.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.math.BigDecimal;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    @OneToOne
    private Score score;

    private User(final String name,final String email,final String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public static User of(final UserDTO userDTO){
        User user = new User(userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());
        return user;
    }


    public boolean validadePassword(final String password){
        return this.password.equals(password);
    }

    public void addPointsAndScore() {
        if(score != null){
            score.addAmount(new BigDecimal("0.10"));
            score.addPoints(new Long((int)(Math.random() * 500)));
        }
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getPoints() {
        return String.valueOf(this.getScore().getPoints());
    }


    public String getAmount() {
        return this.getScore().getAmount().toString();
    }


    public GameDTO parseToGameDTO(Status status) {
        return new GameDTO(this.getEmail(), status.name(), this.getScore().getPoints().toString(), this.getAmount());
    }
}
