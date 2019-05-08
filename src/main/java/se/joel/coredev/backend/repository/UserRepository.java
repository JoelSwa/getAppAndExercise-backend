package se.joel.coredev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.joel.coredev.backend.repository.model.User;

import java.util.Optional;

/**
 * This interface provides several easy predefined ways to search for,
 * access, post and delete objects of User to and from the database.
 * You may also add custom methods that can be interpreted automatically
 * with the right syntax for JpaRepository<T, ID>.
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
