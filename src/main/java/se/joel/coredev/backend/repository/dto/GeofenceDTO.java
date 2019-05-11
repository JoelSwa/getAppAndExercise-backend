package se.joel.coredev.backend.repository.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Objects of this class are created for the purpose of being
 * able to easily receive and transfer data.
 */
public class GeofenceDTO {

    // ***********************************************************
    // Fields
    // ***********************************************************

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "username",
            "name",
            "latitude",
            "longitude",
            "radius",
            "transition"
    })

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String username;
    @JsonProperty("name")
    private String name;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("radius")
    private int radius;
    @JsonProperty("transition")
    private int transition;

    // ***********************************************************
    // Constructors
    // ***********************************************************

    public GeofenceDTO(){ }

    public GeofenceDTO(String username, String name, double latitude, double longitude, int radius, int transition) {
        this.username = username;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.transition = transition;
    }

    public GeofenceDTO(Long id, String name, double latitude, double longitude, int radius, int transition) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.transition = transition;
    }

    public GeofenceDTO(String name, double latitude, double longitude, int radius, int transition) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.transition = transition;
    }

    public GeofenceDTO(double latitude, double longitude, int radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    // ***********************************************************
    // Public methods
    // ***********************************************************

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    @JsonProperty("radius")
    public int getRadius() {
        return radius;
    }

    @JsonProperty("transition")
    public int getTransition() {
        return transition;
    }
}
