package com.br.hackatrouble.challenge.service;

import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

    private final UserRepository repository;

    public void save(User user){
        repository.save(user);
    }
}
