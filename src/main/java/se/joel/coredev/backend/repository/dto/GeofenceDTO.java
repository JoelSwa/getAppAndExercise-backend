package se.joel.coredev.backend.repository.dto;

public class GeofenceDTO {
    private double latitude;
    private double longitude;
    private int radius;
    private String username;

    public GeofenceDTO(double latitude, double longitude, int radius, String username){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.username = username;
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

    public String getUsername() {
        return username;
    }
}
