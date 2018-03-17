package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.exception.NotFoundException;
import be.edenglen.tournament.ws.model.Helper;
import be.edenglen.tournament.ws.model.ImmutableHelper;
import be.edenglen.tournament.ws.model.entities.HelperEntity;
import be.edenglen.tournament.ws.model.repositories.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
