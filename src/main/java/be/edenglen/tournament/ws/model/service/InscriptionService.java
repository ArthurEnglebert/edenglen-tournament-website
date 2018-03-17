package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Inscription;

import java.util.Optional;

public interface InscriptionService {
    Inscription get(Long id);
    Optional<Inscription> find(Long id);
    Inscription create(Inscription inscription);
}
