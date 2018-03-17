package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.ImmutableInscription;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.entities.InscriptionEntity;
import be.edenglen.tournament.ws.model.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    @Autowired
    InscriptionServiceImpl(InscriptionRepository inscriptionRepository) {
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Inscription get(Long id) {
        return inscriptionRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<Inscription> find(Long id) {
        return inscriptionRepository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public Inscription create(Inscription inscription) {
        return toDTO(
                inscriptionRepository.save(Optional.of(inscription)
                        .map(InscriptionEntity::new)
                        .orElseThrow(IllegalArgumentException::new)
                )
        );
    }

    private Inscription toDTO(Inscription inscription) {
        return ImmutableInscription.copyOf(inscription);
    }
}
