package se.joel.coredev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.joel.coredev.backend.repository.data.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
