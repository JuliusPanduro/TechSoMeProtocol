package dk.kea.techsomeprotocol.controllers;

import dk.kea.techsomeprotocol.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Julius Panduro
 */
@RestController
public class UserController {
List<User> userList;

    @PostMapping("/users")
    public String createNewUser(@RequestBody User newUser) {
     userList.add(newUser);
     return "ok";
    }

}
