package dk.kea.techsomeprotocol.controllers;

import dk.kea.techsomeprotocol.repositories.RelationRepository;
import dk.kea.techsomeprotocol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Julius Panduro
 */
@RestController
public class RequestController {

    @Autowired
    UserRepository users;

    @Autowired
    RelationRepository relations;

    /* DB opsætning -> tilføj jsonignore?
        users table (name, email, domæne)
        One
        V
        Many
        table med relationer mellem users (user1, user2, friends(true/false), blocked(true/false))
     */

    @PostMapping("/")
    public HttpStatus tmpName() {
        //method sp srcEmail sp srcHost sp desEmail sp desHost sp version cr lf
        String requestString = "add srcEmail srcHost desEmail desHost vers";
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

        switch (method) { //-> service? gem i db
            case "add": addRequest(requestString); break; //des email gets a request to be friends (sends a response that is has been seen)
            case "accept": break;//des email accepts the request and "link" the two emails together (sends a response that they are connected)
            case "deny": break;//des email denies the request (sends a response that invitation is denied)
            case "remove": break;//des email remove another email "unlink" the two emails (sends a response that they are unlinked)
            case "block": break;//des email blocks another email, will "unlink" and remove email (sends response that they are blocked)
            default: return HttpStatus.METHOD_NOT_ALLOWED;
        }
        return HttpStatus.OK;
    }


    public void addRequest(String friendshipRequest){
        //tilføj til request table i db

    }

    public void acceptRequest(String friendshipReply){
        //få fat på request i request table, add friend connect i db
    }

//?method=get&src=a@b.c&src_host=deresIPadresse


}
