package dk.kea.techsomeprotocol.controllers;

import dk.kea.techsomeprotocol.repositories.RelationRepository;
import dk.kea.techsomeprotocol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Julius Panduro
 */
@RestController
public class RequestController {

    @Autowired
    UserRepository users;

    @Autowired
    RelationRepository relations;

    private String ourDomain = "http://localhost:8080"; //temp

    @PostMapping("/{requestString}")
    public HttpStatus tmpName(@PathVariable String requestString) {
        //method sp srcEmail sp srcHost sp desEmail sp desHost sp version cr lf
        String[] splitter = requestString.split(" ");
        String method = splitter[0];

        switch (method) { //-> service? gem i db
            case "add": addRequest(requestString); return HttpStatus.OK; //des email gets a request to be friends (sends a response that is has been seen)
            case "accept": break;//des email accepts the request and "link" the two emails together (sends a response that they are connected)
            case "deny": break;//des email denies the request (sends a response that invitation is denied)
            case "remove": break;//des email remove another email "unlink" the two emails (sends a response that they are unlinked)
            case "block": break;//des email blocks another email, will "unlink" and remove email (sends response that they are blocked)
            default: return HttpStatus.METHOD_NOT_ALLOWED;
        }
        return HttpStatus.OK;
    }

    public void addRequest(String friendshipRequest){

        //hvis desHost er vores, så opret friendship. hvis desHost er et andet sted, så send request der til
        String[] splitRequest = friendshipRequest.split(" ");
        String method = splitRequest[0];
        String srcEmail = splitRequest[1];
        String srcHost = splitRequest[2];
        String desEmail = splitRequest[3];
        String desHost = splitRequest[4];
        String version = splitRequest[5]; //??

        if(ourDomain.equals(desHost)){
            //opret request table
                //srcEmail, srcHost, desEmail, desHost
            //tilføj til request table i db
            System.out.println("friend added");
        }
        else {
            //other domain redirect
            URLConnection connection = null;
            try {
                connection = new URL(desHost + "/" + friendshipRequest).openConnection();
                connection.setDoOutput(true); //POST
                connection.setRequestProperty("Accept-Charset", "UTF-8");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void acceptRequest(String friendshipReply){
        //få fat på request i request table,
        //fjern fra request table
        // add friend connect i relation db
    }


}
