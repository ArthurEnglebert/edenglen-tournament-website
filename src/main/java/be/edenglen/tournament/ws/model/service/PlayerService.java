package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import be.edenglen.tournament.ws.model.Player;

public interface PlayerService {
    Player get(Long id);
    Optional<Player> find(Long id);
    List<Player> findAll();
}
