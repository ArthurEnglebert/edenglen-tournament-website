package be.edenglen.tournament.ws.model.repositories;

import be.edenglen.tournament.ws.model.entities.EaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EaterRepository extends JpaRepository<EaterEntity, Long> {
}
