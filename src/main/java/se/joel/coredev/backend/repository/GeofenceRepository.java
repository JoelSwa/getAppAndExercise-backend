package se.joel.coredev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.joel.coredev.backend.repository.model.Geofence;

public interface GeofenceRepository extends JpaRepository<Geofence, Long> {
}
