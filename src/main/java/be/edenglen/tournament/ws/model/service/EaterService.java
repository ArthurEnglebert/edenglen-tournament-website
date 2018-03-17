package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Eater;

import java.util.Optional;

public interface EaterService {
    Eater get(Long id);
    Optional<Eater> find(Long id);
    Eater create(Eater eater);
}
