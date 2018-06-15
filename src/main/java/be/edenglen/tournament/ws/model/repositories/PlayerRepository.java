package be.edenglen.tournament.ws.model.repositories;

import be.edenglen.tournament.ws.model.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
