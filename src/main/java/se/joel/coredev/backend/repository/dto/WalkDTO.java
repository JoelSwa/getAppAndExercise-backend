package se.joel.coredev.backend.repository.dto;

import java.util.Collection;

public class WalkDTO {
    private Long id;
    private String username;
    private String name;
    private Collection<GeofenceDTO> geofenceCollection;

    public WalkDTO(){}

    public WalkDTO(String username, String name, Collection<GeofenceDTO> geofenceDTOCollection){
        this.username = username;
        this.name = name;
        this.geofenceCollection = geofenceDTOCollection;
    }

    public WalkDTO(String name, Collection<GeofenceDTO> geofenceDTOCollection){
        this.name = name;
        this.geofenceCollection = geofenceDTOCollection;
    }

    public WalkDTO(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public WalkDTO(String name){
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public Long getId(){
        return this.id;
    }

    public Collection<GeofenceDTO> getGeofenceCollection() {
        return geofenceCollection;
    }
}
