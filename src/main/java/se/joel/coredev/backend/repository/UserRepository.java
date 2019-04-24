package se.joel.coredev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.joel.coredev.backend.repository.data.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
