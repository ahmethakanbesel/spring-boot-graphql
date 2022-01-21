package com.basketball.graphql.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.basketball.graphql.entity.Player;
import com.basketball.graphql.repo.PlayerRepository;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerRepository PlayerRepository;

    public List<Player> getPlayers() {
        return PlayerRepository.findAllBy();
    }

    public List<Player> getPlayersByPosition(String position) {
        return PlayerRepository.getByPositionLike(position);
    }

    public Optional<Player> getById(Long id) {
        return PlayerRepository.findById(id);
    }
}
