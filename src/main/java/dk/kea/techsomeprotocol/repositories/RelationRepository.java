package dk.kea.techsomeprotocol.repositories;

import dk.kea.techsomeprotocol.models.Relation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationRepository extends JpaRepository<Relation, Long> {
}
