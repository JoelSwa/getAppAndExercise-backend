package se.joel.coredev.backend.repository.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity(name = "Walk")
public final class Walk {

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
    @ManyToOne
    private User user;
    private String name;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Geofence> geofences;

    protected Walk(){}

    public Walk(User user, String name, Collection<Geofence> geofences){
        this.user = user;
        this.name = name;
        this.geofences = geofences;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Collection<Geofence> getGeofences() {
        return geofences;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGeofences(Collection<Geofence> geofences) {
        this.geofences = geofences;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
