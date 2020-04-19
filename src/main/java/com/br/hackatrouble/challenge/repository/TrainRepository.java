package com.br.hackatrouble.challenge.repository;

import com.br.hackatrouble.challenge.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
}
