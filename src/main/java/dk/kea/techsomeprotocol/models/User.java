package dk.kea.techsomeprotocol.models;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Julius Panduro
 */
@Data
@NoArgsConstructor
public class User {
    private String email;
    private String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }
}
