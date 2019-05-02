package se.joel.coredev.backend.repository.data;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue()
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AUTHORITY")
    private String authority;

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
}
