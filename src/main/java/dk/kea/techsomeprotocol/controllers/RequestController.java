package dk.kea.techsomeprotocol.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julius Panduro
 */
@RestController
public class RequestController {
    HttpStatus httpStatus;

    @PostMapping("/")
    public String tmpName() {
        //get srcEmail srcHost desEmail desHost vers
        String requestString = "block srcEmail srcHost desEmail desHost vers";
        String[] splitter = requestString.split(" ");
        for (String item : splitter) {
            System.out.println(item);
        }
        String method = splitter[0];
        String srcEmail = splitter[1];
        String srcHost = splitter[2];
        String desEmail = splitter[3];
        String desHost = splitter[4];
        String version = splitter[5];

        switch (method) {
            case "add": //des email gets a request to be friends (sends a response that is has been seen)
            case "accept": //des email accepts the request and "link" the two emails together (sends a response that they are connected)
            case "deny": //des email denies the request (sends a response that invitation is denied)
            case "remove": //des email remove another email "unlink" the two emails (sends a response that they are unlinked)
            case "block":
                return "you have been blocked" + HttpStatus.I_AM_A_TEAPOT;//des email blocks another email, will "unlink" and remove email (sends response that they are blocked)
        }


        return "Hello " + httpStatus + 418;
    }

//?method=get&src=a@b.c&src_host=deresIPadresse


}
