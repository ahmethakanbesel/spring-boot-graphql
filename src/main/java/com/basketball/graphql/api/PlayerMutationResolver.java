package com.basketball.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.basketball.graphql.dto.PlayerDto;
import com.basketball.graphql.entity.Player;
import com.basketball.graphql.repo.PlayerRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerRepository PlayerRepository;
    private static final Set<String> allowedPositions = new HashSet<String>(Arrays.asList(
            "Point guard(PG)", "Shooting guard(SG)", "Small forward(SF)", "Power forward(PF)", "Center(C)"));

    public Player createPlayer(PlayerDto PlayerDto) {
        return PlayerRepository.save(dtoToEntity(PlayerDto));
    }

    public Boolean deletePlayer(long playerId) {
        try {
            PlayerRepository.deleteById(playerId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Player dtoToEntity(PlayerDto PlayerDto) {
        String position = PlayerDto.getPosition();
        if (allowedPositions.contains(position)) {
            Player Player = new Player();
            Player.setName(PlayerDto.getName());
            Player.setSurname(PlayerDto.getSurname());
            Player.setPosition(PlayerDto.getPosition());
            return Player;
        } else {
            throw new IllegalArgumentException("Position is not valid");
        }
    }
}
