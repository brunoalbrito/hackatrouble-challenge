package com.br.hackatrouble.challenge.model;

import com.br.hackatrouble.challenge.dto.UserDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
}
