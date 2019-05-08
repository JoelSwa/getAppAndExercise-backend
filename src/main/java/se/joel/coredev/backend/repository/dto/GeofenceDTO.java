package se.joel.coredev.backend.repository.dto;

/**
 * Objects of this class are created for the purpose of being
 * able to easily receive and transfer data.
 *
 */
public class GeofenceDTO {

    // ***********************************************************
    // Fields
    // ***********************************************************

    private double latitude;
    private double longitude;
    private int radius;
    private String username;

    // ***********************************************************
    // Constructors
    // ***********************************************************

    public GeofenceDTO(double latitude, double longitude, int radius, String username){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.username = username;
    }

    public GeofenceDTO(double latitude, double longitude, int radius){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    // ***********************************************************
    // Public methods
    // ***********************************************************

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getRadius() {
        return radius;
    }

    public String getUsername() {
        return username;
    }
}
