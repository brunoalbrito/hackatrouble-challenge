package com.br.hackatrouble.challenge.repository;

import com.br.hackatrouble.challenge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long > {
}
