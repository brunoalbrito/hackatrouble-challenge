package com.br.hackatrouble.challenge.service;

import com.br.hackatrouble.challenge.dto.GameDTO;
import com.br.hackatrouble.challenge.dto.PlayerDTO;
import com.br.hackatrouble.challenge.dto.RankDTO;
import com.br.hackatrouble.challenge.enums.Status;
import com.br.hackatrouble.challenge.model.Score;
import com.br.hackatrouble.challenge.model.User;
import com.br.hackatrouble.challenge.repository.ScoreRepository;
import com.br.hackatrouble.challenge.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class GameService {


    private final UserRepository userRepository;

    private final ScoreRepository scoreRepository;

    public GameDTO receiveVote(GameDTO gameDTO) {
        Status status = Status.valueOfLabel(gameDTO.getVote());
        Optional<User> userFound = userRepository.findAll().stream().filter( user -> user.getEmail().equals(gameDTO.getEmail())).findFirst();
        userFound.ifPresent(user -> {
            if(user.getScore() != null){
                user.addPointsAndScore();
                scoreRepository.save(user.getScore());;
            }else{
                Score score = new Score();
                Long points = new Long((int)(Math.random() * 500));
                score.addPoints(points);
                score.addAmount(new BigDecimal("0.10"));
                scoreRepository.save(score);;
                user.setScore(score);
            }
            userRepository.save(user);
        });
        return userFound.map(user -> user.parseToGameDTO(status)).orElse(null);
    }

    public RankDTO rank() {
        RankDTO rankDTO = new RankDTO();
        List<PlayerDTO> playerDTOList = new ArrayList<>();
        userRepository.findAll().stream().forEach(user -> {
            PlayerDTO playerDTO = new PlayerDTO(user.getName(), user.getScore());
            playerDTOList.add(playerDTO);
        });
        rankDTO.setPlayers(playerDTOList);
        return rankDTO;
    }
}