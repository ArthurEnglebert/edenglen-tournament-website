package be.edenglen.tournament.ws.model.service;

import be.edenglen.tournament.ws.model.Helper;

import java.util.Optional;

public interface HelperService {
    Helper get(Long id);
    Optional<Helper> find(Long id);
    Helper create(Helper helper);
}
