package se.joel.coredev.backend.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity(name = "Geofence")
@Table(name = "GEOFENCE")
public class Geofence {

    @Id
    @Column(name = "ID")
    @GeneratedValue()
    private Long id;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "RADIUS")
    private int radius;

    @ManyToOne
    @JsonIgnore
    private User user;

    protected Geofence(){
    }

    public Geofence(double latitude, double longitude, int radius, User user){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }
}
