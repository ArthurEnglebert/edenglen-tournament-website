package be.edenglen.tournament.ws.model.repositories;

import be.edenglen.tournament.ws.model.entities.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {
}
