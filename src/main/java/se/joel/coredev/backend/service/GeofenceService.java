package se.joel.coredev.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.joel.coredev.backend.exception.NotFoundException;
import se.joel.coredev.backend.repository.GeofenceRepository;
import se.joel.coredev.backend.repository.UserRepository;
import se.joel.coredev.backend.repository.dto.GeofenceDTO;
import se.joel.coredev.backend.repository.dto.UserDTO;
import se.joel.coredev.backend.repository.dto.WalkDTO;
import se.joel.coredev.backend.repository.model.Geofence;
import se.joel.coredev.backend.repository.model.User;
import se.joel.coredev.backend.repository.model.Walk;

import java.util.ArrayList;
import java.util.List;
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

    public Geofence addGeofence(GeofenceDTO geofenceDTO) {
        Optional<User> userOptional = userRepository.findByUsername(geofenceDTO.getUsername());
        if (userOptional.isPresent()) {
            return geofenceRepository.save(new Geofence(
                    geofenceDTO.getName(),
                    geofenceDTO.getLatitude(),
                    geofenceDTO.getLongitude(),
                    geofenceDTO.getRadius(),
                    geofenceDTO.getTransition(),
                    userOptional.get()));
        }
        throw new NotFoundException("Could not add geofence, user not found");
    }

    public List<GeofenceDTO> getGeofencesForUser(UserDTO userDTO) {
        List<GeofenceDTO> geofences = new ArrayList<>();
        System.out.println("userDTO username: " + userDTO.getUsername());
        Optional<User> userOptional = userRepository.findByUsername(userDTO.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (null != user.getGeofences() && user.getGeofences().size() > 0) {
                for (Geofence geo : user.getGeofences()) {
                    geofences.add(new GeofenceDTO(geo.getId(), geo.getName(), geo.getLatitude(), geo.getLongitude(), geo.getRadius(), geo.getTransition()));
                }
                return geofences;
            }
            throw new NotFoundException("No geofences found for user");
        }
        throw new NotFoundException("User not found");
    }

    public List<GeofenceDTO> getGeofencesForWalk(WalkDTO walkDTO) {
        Optional<User> userOptional = userRepository.findByUsername(walkDTO.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            System.out.println("WalkDTO.name: " + walkDTO.getName());
            for (Walk w : user.getWalks()) {
                System.out.println("Walk.name: " + w.getName());
                if (w.getName().equals(walkDTO.getName())) {
                    List<GeofenceDTO> geofences = new ArrayList<>();
                    for (Geofence geo : w.getGeofences()) {
                        geofences.add(new GeofenceDTO(geo.getName(), geo.getLatitude(), geo.getLongitude(), geo.getRadius(), geo.getTransition()));
                    }
                    return geofences;
                }
            }
            throw new NotFoundException("Walk not found");
        }
        throw new NotFoundException("User not found");
    }
}
