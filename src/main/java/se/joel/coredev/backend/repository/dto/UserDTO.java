package se.joel.coredev.backend.repository.dto;

/**
 * Objects of this class are created for the purpose of being
 * able to easily receive and transfer data.
 *
 */
public class UserDTO {

    // ***********************************************************
    // Fields
    // ***********************************************************

    private String username;

    // ***********************************************************
    // Constructors
    // ***********************************************************

    public UserDTO(String username){
        this.username = username;
    }

    // ***********************************************************
    // Public methods
    // ***********************************************************

    public String getUsername() {
        return username;
    }
}
