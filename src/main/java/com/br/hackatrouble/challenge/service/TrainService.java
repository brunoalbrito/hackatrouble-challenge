package com.br.hackatrouble.challenge.service;

import com.br.hackatrouble.challenge.dto.TrainDTO;
import com.br.hackatrouble.challenge.enums.Status;
import com.br.hackatrouble.challenge.model.Car;
import com.br.hackatrouble.challenge.model.Train;
import com.br.hackatrouble.challenge.repository.CarRepository;
import com.br.hackatrouble.challenge.repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TrainService {

    private final TrainRepository trainRepository;

    private final CarRepository carRepository;

    public TrainDTO register(TrainDTO trainDTO) {
        Train train = new Train(trainDTO.getNumber(), trainDTO.getLineName());
        train.setCars(createCars());
        return trainRepository.save(train).convertToDTO();
    }

    public List createCars(){
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Car car = new Car(String.valueOf(i), Status.VAZIO);
            car = carRepository.save(car);
            cars.add(car);
        }

        return cars;
    }

    public List<Train> listAll() {
        return trainRepository.findAll();
    }
}
