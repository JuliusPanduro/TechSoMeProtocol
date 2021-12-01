package dk.kea.techsomeprotocol.repositories;

import dk.kea.techsomeprotocol.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
