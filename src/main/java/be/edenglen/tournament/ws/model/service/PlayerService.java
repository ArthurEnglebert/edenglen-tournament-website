package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Player get(Long id);
    Optional<Player> find(Long id);
    List<Player> findAll();
    Player create(Player player);
}
