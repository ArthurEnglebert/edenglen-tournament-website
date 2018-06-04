package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.ImmutableInscription;
import be.edenglen.tournament.ws.model.Inscription;
import be.edenglen.tournament.ws.model.entities.InscriptionEntity;
import be.edenglen.tournament.ws.model.repositories.InscriptionRepository;

@Service
@Transactional
class InscriptionServiceImpl implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final AmountCalculatorService amountCalculatorService;
    private final MailService mailService;

    @Autowired
    InscriptionServiceImpl(InscriptionRepository inscriptionRepository,
                           AmountCalculatorService amountCalculatorService,
                           MailService mailService) {
        this.inscriptionRepository = inscriptionRepository;
        this.amountCalculatorService = amountCalculatorService;
        this.mailService = mailService;
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

        //fixme implements listener around transaction start / commit to decouple dependencies
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                mailService.sendConfirmationMail(entity);
            }
        });

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
