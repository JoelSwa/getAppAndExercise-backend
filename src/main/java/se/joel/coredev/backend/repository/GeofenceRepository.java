package se.joel.coredev.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.joel.coredev.backend.repository.model.Geofence;

/**
 * This interface provides several easy predefined ways to search for,
 * access, post and delete objects of Geofence to and from the database.
 * You may also add custom methods that can be interpreted automatically
 * with the right syntax for JpaRepository<T, ID>.
 *
 */
public interface GeofenceRepository extends JpaRepository<Geofence, Long> {
}
