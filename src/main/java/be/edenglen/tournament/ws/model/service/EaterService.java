package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import be.edenglen.tournament.ws.model.Eater;

public interface EaterService {
    Eater get(Long id);
    Optional<Eater> find(Long id);
    List<Eater> findAll();
}
