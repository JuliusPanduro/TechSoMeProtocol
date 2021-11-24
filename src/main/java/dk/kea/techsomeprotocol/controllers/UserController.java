package dk.kea.techsomeprotocol.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julius Panduro
 */
@RestController
public class UserController {

    @PostMapping("/users")
    public String createNewUser(){
        return null;
    }


}
