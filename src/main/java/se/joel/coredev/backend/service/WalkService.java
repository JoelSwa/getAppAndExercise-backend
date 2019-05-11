package se.joel.coredev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.joel.coredev.backend.exception.NotFoundException;
import se.joel.coredev.backend.repository.GeofenceRepository;
import se.joel.coredev.backend.repository.UserRepository;
import se.joel.coredev.backend.repository.WalkRepository;
import se.joel.coredev.backend.repository.dto.GeofenceDTO;
import se.joel.coredev.backend.repository.dto.WalkDTO;
import se.joel.coredev.backend.repository.model.Geofence;
import se.joel.coredev.backend.repository.model.User;
import se.joel.coredev.backend.repository.model.Walk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public final class WalkService {
    @Autowired
    private final WalkRepository walkRepository;

    @Autowired
    private final GeofenceRepository geofenceRepository;

    @Autowired
    private final UserRepository userRepository;

    public WalkService(WalkRepository walkRepository, GeofenceRepository geofenceRepository, UserRepository userRepository) {
        this.walkRepository = walkRepository;
        this.geofenceRepository = geofenceRepository;
        this.userRepository = userRepository;
    }

    public Walk addWalk(WalkDTO walkDTO) {
        Optional<User> userOptional = userRepository.findByUsername(walkDTO.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Geofence> geofences = new ArrayList<>();
            for (GeofenceDTO geo : walkDTO.getGeofenceCollection()) {
                Optional<Geofence> geofenceOptional = geofenceRepository.findById(geo.getId());
                if (geofenceOptional.isPresent()) {
                    geofences.add(geofenceOptional.get());
                } else {
                    System.out.println("Error: Geofence not found");
                }
            }
            return walkRepository.save(new Walk(user, walkDTO.getName(), geofences));
        }
        throw new NotFoundException("Could not add geofence, user not found");
    }
}
