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
import java.util.Collections;
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
        Optional<User> userOptional = userRepository.findByUsername(userDTO.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            for (Geofence geo : user.getGeofences()) {
                geofences.add(new GeofenceDTO(geo.getId(), geo.getName(), geo.getLatitude(), geo.getLongitude(), geo.getRadius(), geo.getTransition()));
            }
            return geofences;
        }
        throw new NotFoundException("User not found");
    }

    public List<GeofenceDTO> getGeofencesForWalk(WalkDTO walkDTO) {
        Optional<User> userOptional = userRepository.findByUsername(walkDTO.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            for (Walk w : user.getWalks()) {
                if (w.getName().equals(walkDTO.getName())) {
                    List<GeofenceDTO> geofences = new ArrayList(w.getGeofences());
                    //The collection being retrieved comes in reversed order
                    Collections.reverse(geofences);
                    return geofences;
                }
            }
            throw new NotFoundException("Walk not found");
        }
        throw new NotFoundException("User not found");
    }

    public Geofence updateGeofence(GeofenceDTO geofenceDTO) {
        Optional<User> userOptional = userRepository.findByUsername(geofenceDTO.getUsername());
        if (userOptional.isPresent()) {
            Optional<Geofence> geofenceOptional = geofenceRepository.findById(geofenceDTO.getId());
            if (geofenceOptional.isPresent()) {
                Geofence geofence = geofenceOptional.get();
                geofence.setName(geofenceDTO.getName());
                geofence.setLatitude(geofenceDTO.getLatitude());
                geofence.setLongitude(geofenceDTO.getLongitude());
                geofence.setRadius(geofenceDTO.getRadius());
                return geofenceRepository.save(geofence);
            }
            throw new NotFoundException("Geofence not found");
        }
        throw new NotFoundException("User not found");
    }

    public void deleteGeofence(GeofenceDTO geofenceDTO) {
        Optional<User> userOptional = userRepository.findByUsername(geofenceDTO.getUsername());
        if (userOptional.isPresent()) {
            Optional<Geofence> geofenceOptional = geofenceRepository.findById(geofenceDTO.getId());
            if (geofenceOptional.isPresent()) {
                Geofence geofence = geofenceOptional.get();
                geofence.setWalks(null);
                geofence.setUser(null);
                geofenceRepository.save(geofence);
                geofenceRepository.deleteById(geofenceDTO.getId());
                return;
            }
            throw new NotFoundException("Geofence not found");
        }
        throw new NotFoundException("User not found");
    }
}
