package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.Eater;
import be.edenglen.tournament.ws.model.ImmutableEater;
import be.edenglen.tournament.ws.model.repositories.EaterRepository;

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
    public List<Eater> findAll() {
        return eaterRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private Eater toDTO(Eater eater) {
        return ImmutableEater.copyOf(eater);
    }
}
