package be.edenglen.tournament.ws.model.service;

import java.util.List;
import java.util.Optional;
import be.edenglen.tournament.ws.model.Helper;

public interface HelperService {
    Helper get(Long id);
    Optional<Helper> find(Long id);
    List<Helper> findAll();
    Helper create(Helper helper);
}
