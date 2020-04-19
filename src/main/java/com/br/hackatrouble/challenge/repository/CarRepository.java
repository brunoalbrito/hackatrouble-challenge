package com.br.hackatrouble.challenge.repository;

import com.br.hackatrouble.challenge.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
