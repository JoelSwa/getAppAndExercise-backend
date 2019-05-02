package se.joel.coredev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.joel.coredev.backend.exception.NotFoundException;
import se.joel.coredev.backend.repository.GeofenceRepository;
import se.joel.coredev.backend.repository.UserRepository;
import se.joel.coredev.backend.repository.model.Geofence;
import se.joel.coredev.backend.repository.model.User;

import java.util.Collection;
import java.util.Optional;

@Service
public final class GeofenceService {

    @Autowired
    private final GeofenceRepository geofenceRepository;

    @Autowired
    private final UserRepository userRepository;

    public GeofenceService(GeofenceRepository geofenceRepository, UserRepository userRepository) {
        this.geofenceRepository = geofenceRepository;
        this.userRepository = userRepository;
    }

    public Geofence addGeofence(Long userId, Geofence geofence) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return geofenceRepository.save(new Geofence(
                    geofence.getLatitude(),
                    geofence.getLongitude(),
                    geofence.getRadius(),
                    userOptional.get()));
        }
        throw new NotFoundException("Could not add geofence, User not found");
    }

    public Collection<Geofence> getGeofencesForUser(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            if(null != user.getGeofences() && user.getGeofences().size() > 0){
                return user.getGeofences();
            }
            throw new NotFoundException("No geofences found for user");
        }
        throw new NotFoundException("User not found");
    }
}
