package se.joel.coredev.backend.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

/**
 * Objects of this class are created for the purpose of being
 * stored in the database.
 *
 */
@Entity(name = "Geofence")
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
    @GeneratedValue()
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private int radius;
    private int transition;
    @ManyToOne
    @JsonIgnore
    private User user;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Walk> walks;

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

    public Geofence(String name, double latitude, double longitude, int radius, int transition, User user){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
        this.transition = transition;
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

    public String getName() {
        return name;
    }

    public int getTransition() {
        return transition;
    }

    public Collection<Walk> getWalks() { return walks; }

    public void setName(String name) {
        this.name = name;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setWalks(Collection<Walk> walks) {
        this.walks = walks;
    }
}
