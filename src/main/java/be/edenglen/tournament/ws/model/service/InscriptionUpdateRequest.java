package be.edenglen.tournament.ws.model.service;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface InscriptionUpdateRequest {
    Optional<Boolean> switchPaidStatus();
    Optional<Integer> updateAmount();
}
