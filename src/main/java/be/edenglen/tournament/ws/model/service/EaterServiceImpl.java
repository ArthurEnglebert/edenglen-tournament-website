package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.ImmutableEater;
import be.edenglen.tournament.ws.model.entities.EaterEntity;
import be.edenglen.tournament.ws.model.repositories.EaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class EaterServiceImpl implements EaterService {

    private final EaterRepository eaterRepository;

    @Autowired
    EaterServiceImpl(EaterRepository eaterRepository) {
        this.eaterRepository = eaterRepository;
    }

    @Override
    public Eater get(Long id) {
        return eaterRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<Eater> find(Long id) {
        return eaterRepository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public Eater create(Eater eater) {
        return toDTO(
                eaterRepository.save(Optional.of(eater)
                        .map(EaterEntity::new)
                        .orElseThrow(IllegalArgumentException::new)
                )
        );
    }

    private Eater toDTO(Eater eater) {
        return ImmutableEater.copyOf(eater);
    }
}
