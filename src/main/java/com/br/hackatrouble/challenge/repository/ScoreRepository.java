package com.br.hackatrouble.challenge.repository;

import com.br.hackatrouble.challenge.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
