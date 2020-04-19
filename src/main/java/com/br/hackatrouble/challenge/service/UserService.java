package com.br.hackatrouble.challenge.service;

import com.br.hackatrouble.challenge.dto.UserDTO;
import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

    private final UserRepository repository;

    public User save(final UserDTO userDTO){
        User user = User.of(userDTO);
        return repository.save(user);
    }

    public Optional validadeUserRegister(UserDTO userDTO) {
        User userFound = repository.findByEmail(userDTO.getEmail())
                .map(user ->validadePassword(user, userDTO)).orElse(null);
        return Optional.ofNullable(userFound);
    }

    private User validadePassword(User user, UserDTO userDTO) {
        return user.validadePassword(userDTO.getPassword()) ? user : null;
    }
}
