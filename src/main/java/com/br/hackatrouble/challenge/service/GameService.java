package com.br.hackatrouble.challenge.service;

import com.br.hackatrouble.challenge.dto.GameDTO;
import com.br.hackatrouble.challenge.dto.PlayerDTO;
import com.br.hackatrouble.challenge.dto.RankDTO;
import com.br.hackatrouble.challenge.enums.Status;
import com.br.hackatrouble.challenge.model.Car;
import com.br.hackatrouble.challenge.model.Score;
import com.br.hackatrouble.challenge.model.Train;
import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.repository.CarRepository;
import com.br.hackatrouble.challenge.repository.ScoreRepository;
import com.br.hackatrouble.challenge.repository.TrainRepository;
import com.br.hackatrouble.challenge.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class GameService {


    private final UserRepository userRepository;

    private final ScoreRepository scoreRepository;

    private final TrainRepository trainRepository;

    private final CarRepository carRepository;

    public GameDTO receiveVote(GameDTO gameDTO) {
        Status status = Status.valueOfLabel(gameDTO.getVote());
        Optional<User> userFound = gameScoreLogic(gameDTO);
        updateCarTrainStatusLogic(gameDTO);
        gameDTO.setScore(userFound.get().getPoints());
        gameDTO.setAmount(userFound.get().getAmount());
        return gameDTO;
    }

    private void updateCarTrainStatusLogic(GameDTO gameDTO) {
        Status status = Status.valueOfLabel(gameDTO.getVote());
        Optional trainFound = trainRepository.findAll().stream().filter(train -> train.getNumber().equals(gameDTO.getTrem())).findFirst();
        Optional carFound = ((Train) trainFound.get()).getCars().stream().filter(car -> car.getNumber().equals(gameDTO.getVagao())).findFirst();
        Car carEntity = (Car) carFound.get();
        carEntity.changeStatus(status);
        gameDTO.setTrem(((Train) trainFound.get()).getNumber());
        gameDTO.setVagao(carEntity.getNumber());
        carRepository.save(carEntity);
    }

    private Optional<User> gameScoreLogic(GameDTO gameDTO) {
        Optional<User> userFound = userRepository.findAll().stream().filter(user -> user.getEmail().equals(gameDTO.getEmail())).findFirst();
        userFound.ifPresent(user -> {
            if (user.getScore() != null) {
                user.addPointsAndScore();
                scoreRepository.save(user.getScore());
                ;
            } else {
                Score score = new Score();
                Long points = new Long((int) (Math.random() * 500));
                score.addPoints(points);
                score.addAmount(new BigDecimal("0.10"));
                scoreRepository.save(score);
                ;
                user.setScore(score);
            }
            userRepository.save(user);
        });
        return userFound;
    }

    public RankDTO rank() {
        RankDTO rankDTO = new RankDTO();
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        userRepository.findAll().stream().forEach(user -> {
            PlayerDTO playerDTO = new PlayerDTO(user.getName(), user.getScore());
            playerDTOList.add(playerDTO);
        });
        rankDTO.setPlayers(sortByScore(playerDTOList));
        return rankDTO;
    }

    private List<PlayerDTO> sortByScore(List<PlayerDTO> playerDTOList) {
        return playerDTOList.stream()
                            .sorted(Comparator.comparingLong(PlayerDTO::getScore))
                            .collect(Collectors.toList());
    }
}