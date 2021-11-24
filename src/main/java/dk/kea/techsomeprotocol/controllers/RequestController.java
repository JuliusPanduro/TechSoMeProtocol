package dk.kea.techsomeprotocol.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julius Panduro
 */
@RestController
public class RequestController {

    @GetMapping("/")
    public String index(){
        return "Hello";
    }









}
