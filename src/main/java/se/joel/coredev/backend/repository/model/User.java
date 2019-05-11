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
@Entity(name = "User")
public final class User {

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
    private String username;
    private String password;
    private String authority;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",
            orphanRemoval = true)
    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Geofence> geofences;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",
            orphanRemoval = true)
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

    protected User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.authority = "user";
    }

    public User(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
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

    public String getPassword() {
        return password;
    }

    public String getAuthority() {
        return authority;
    }

    public Collection<Geofence> getGeofences() { return geofences; }

    public Collection<Walk> getWalks() {
        return walks;
    }
}
