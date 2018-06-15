package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.ImmutablePlayer;
import be.edenglen.tournament.ws.model.Player;
import be.edenglen.tournament.ws.model.repositories.PlayerRepository;

@Service
class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository repository;

    @Autowired
    PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Player get(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<Player> find(Long id) {
        return repository.findById(id).map(this::toDTO);
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private Player toDTO(Player entity) {
        return ImmutablePlayer.copyOf(entity);
    }
}
