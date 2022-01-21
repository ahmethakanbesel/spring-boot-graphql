package com.basketball.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.basketball.graphql.dto.PlayerDto;
import com.basketball.graphql.entity.Player;
import com.basketball.graphql.repo.PlayerRepository;

import java.util.Date;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerRepository PlayerRepository;

    public Player createPlayer(PlayerDto PlayerDto) {
        return PlayerRepository.save(dtoToEntity(PlayerDto));
    }

    private Player dtoToEntity(PlayerDto PlayerDto) {
        Player Player = new Player();
        Player.setName(PlayerDto.getName());
        Player.setSurname(PlayerDto.getSurname());
        Player.setPosition(PlayerDto.getPosition());
        return Player;
    }
}
