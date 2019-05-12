package se.joel.coredev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.joel.coredev.backend.repository.model.Walk;

import java.util.Optional;

public interface WalkRepository extends JpaRepository<Walk, Long> {
}
