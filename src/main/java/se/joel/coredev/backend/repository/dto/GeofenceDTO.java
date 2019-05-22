package se.joel.coredev.backend.repository.dto;

/**
 * Objects of this class are created for the purpose of being
 * able to easily receive and transfer data.
 */
public class GeofenceDTO {

    // ***********************************************************
    // Fields
    // ***********************************************************
    private Long id;
    private String username;
    private String name;
    private double latitude;
    private double longitude;
    private int radius;
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

    public GeofenceDTO(String name, double latitude, double longitude, int radius) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    // ***********************************************************
    // Public methods
    // ***********************************************************

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getRadius() {
        return radius;
    }

    public int getTransition() {
        return transition;
    }
}
