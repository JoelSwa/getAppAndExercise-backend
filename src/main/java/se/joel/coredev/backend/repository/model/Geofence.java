package se.joel.coredev.backend.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Objects of this class are created for the purpose of being
 * stored in the database.
 *
 */
@Entity(name = "Geofence")
@Table(name = "GEOFENCE")
public final class Geofence {

    // ***********************************************************
    // Fields
    // ***********************************************************

    /**
     * Every object created of this class will automatically receive
     * an Id in the database while making sure there are no duplicates.
     * If an object is deleted from the database, its Id is deleted as well
     * and will not be reused.
     *
     */
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

    // ***********************************************************
    // Constructors
    // ***********************************************************

    /**
     * This no-arg constructor is necessary for JAX-RS to create an object of this
     * class for database storage. It is not meant to be used for any other purpose.
     *
     */
    protected Geofence(){
    }

    public Geofence(double latitude, double longitude, int radius, User user){
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.user = user;
    }

    // ***********************************************************
    // Public methods
    // ***********************************************************

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
