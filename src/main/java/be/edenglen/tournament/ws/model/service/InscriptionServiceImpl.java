package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.ImmutableInscription;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.entities.InscriptionEntity;
import be.edenglen.tournament.ws.model.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final AmountCalculatorService amountCalculatorService;

    @Autowired
    InscriptionServiceImpl(InscriptionRepository inscriptionRepository,
                           AmountCalculatorService amountCalculatorService) {
        this.inscriptionRepository = inscriptionRepository;
        this.amountCalculatorService = amountCalculatorService;
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
        ImmutableInscription toCreate = ImmutableInscription.builder()
                .from(inscription)
                .amount(amountCalculatorService.calculateDue(inscription))
                .build();

        InscriptionEntity entity = inscriptionRepository.save(Optional.of(toCreate)
                .map(InscriptionEntity::new)
                .orElseThrow(IllegalArgumentException::new)
        );
        return toDTO(entity);
    }

    @Override
    public Inscription update(Long id, InscriptionUpdateRequest request) {
        Inscription inscription = get(id);
        ImmutableInscription.Builder from = ImmutableInscription.builder().from(inscription);

        request.switchPaidStatus().ifPresent(paid -> from.isPaid(!inscription.isPaid()));
        request.updateAmount().ifPresent(from::amount);

        ImmutableInscription updated = from.build();
        return toDTO(
                inscriptionRepository.save(Optional.of(updated)
                .map(InscriptionEntity::new)
                .orElseThrow(IllegalArgumentException::new)
                )
        );
    }

    @Override
    public List<Inscription> findAll() {
        return inscriptionRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private Inscription toDTO(Inscription inscription) {
        return ImmutableInscription.copyOf(inscription);
    }
}
