package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Player;

import java.util.Optional;

public interface PlayerService {
    Player get(Long id);
    Optional<Player> find(Long id);
    Player create(Player player);
}
