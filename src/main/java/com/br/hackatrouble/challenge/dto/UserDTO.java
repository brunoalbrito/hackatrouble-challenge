package com.br.hackatrouble.challenge.dto;


import com.br.hackatrouble.challenge.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {

    private String name;

    private String email;

    private String password;

    public static UserDTO convertToUserDTO(User user){
        return new UserDTO(user.getName(), user.getEmail(), user.getPassword());
    }
}
