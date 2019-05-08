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
    private String test;

    // ***********************************************************
    // Constructors
    // ***********************************************************

    public UserDTO(String username, String test){
        this.username = username;
        this.test = test;
    }

    // ***********************************************************
    // Public methods
    // ***********************************************************

    public String getUsername() {
        return username;
    }

    public String getTest(){
        return test;
    }
}
