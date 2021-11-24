package dk.kea.techsomeprotocol.models;

import lombok.Data;


/**
 * @author Julius Panduro
 */
@Data
public class User {
    private String email;
    private String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
