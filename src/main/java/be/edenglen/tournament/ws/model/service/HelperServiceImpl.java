package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.ImmutableHelper;
import be.edenglen.tournament.ws.model.entities.HelperEntity;
import be.edenglen.tournament.ws.model.repositories.HelperRepository;

@Service
class HelperServiceImpl implements HelperService {

    private final HelperRepository helperRepository;

    @Autowired
    HelperServiceImpl(HelperRepository helperRepository) {
        this.helperRepository = helperRepository;
    }


    @Override
    public Helper get(Long id) {
        return helperRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<Helper> find(Long id) {
        return helperRepository.findById(id)
                .map(this::toDTO);
    }

    @Override
    public List<Helper> findAll() {
        return helperRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Helper create(Helper helper) {
        return toDTO(
                helperRepository.save(
                        Optional.of(helper)
                                .map(HelperEntity::new)
                                .orElseThrow(IllegalArgumentException::new)
                )
        );
    }

    private Helper toDTO(Helper helper) {
        return ImmutableHelper.copyOf(helper);
    }
}
