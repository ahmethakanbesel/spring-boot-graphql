package com.basketball.graphql.repo;

import com.basketball.graphql.entity.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllBy();
    List<Player> getByPositionLike(String position);

}

