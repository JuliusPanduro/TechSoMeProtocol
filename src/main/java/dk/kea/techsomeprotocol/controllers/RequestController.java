package dk.kea.techsomeprotocol.controllers;

import dk.kea.techsomeprotocol.models.FriendRequest;
import dk.kea.techsomeprotocol.models.Request;
import dk.kea.techsomeprotocol.repositories.FriendRequestRepository;
import dk.kea.techsomeprotocol.repositories.RelationRepository;
import dk.kea.techsomeprotocol.repositories.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Julius Panduro
 */
@RestController
public class RequestController {

    @Autowired
    UserRepository users;

    @Autowired
    RelationRepository relations;

    @Autowired
    FriendRequestRepository friendRequests;

    private String ourDomain = "http://localhost:8080"; //temp

    @PostMapping("/")
    public ResponseEntity endpointForThisServer(@RequestBody Request request) {
        System.out.println(request.toString());
        System.out.println(request.method);

        switch (request.method) { //-> service? gem i db
            case "add":
                addRequest(request);
                return new ResponseEntity<>("Friend added on " + ourDomain, HttpStatus.CREATED); //des email gets a request to be friends (sends a response that is has been seen)
            case "accept":
                break;//des email accepts the request and "link" the two emails together (sends a response that they are connected)
            case "deny":
                break;//des email denies the request (sends a response that invitation is denied)
            case "remove":
                break;//des email remove another email "unlink" the two emails (sends a response that they are unlinked)
            case "block":
                break;//des email blocks another email, will "unlink" and remove email (sends response that they are blocked)
            default:
                return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
        }

        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    /*deprecated
    @PostMapping("/{requestString}")
    public HttpStatus tmpName(@PathVariable String requestString) {
        //method sp srcEmail sp srcHost sp desEmail sp desHost sp version cr lf
        String[] splitter = requestString.split(" ");
        String method = splitter[0];

        switch (method) { //-> service? gem i db
            case "add":
                addRequest(requestString);
                return HttpStatus.OK; //des email gets a request to be friends (sends a response that is has been seen)
            case "accept":
                break;//des email accepts the request and "link" the two emails together (sends a response that they are connected)
            case "deny":
                break;//des email denies the request (sends a response that invitation is denied)
            case "remove":
                break;//des email remove another email "unlink" the two emails (sends a response that they are unlinked)
            case "block":
                break;//des email blocks another email, will "unlink" and remove email (sends response that they are blocked)
            default:
                return HttpStatus.METHOD_NOT_ALLOWED;
        }
        return HttpStatus.OK;
    }
*/

    public void addRequest(Request request) {
        //hvis desHost er vores, så opret friendship. hvis desHost er et andet sted, så send request der til
        if (ourDomain.equals(request.desHost)) {
            FriendRequest friendRequest = new FriendRequest(request.srcEmail, request.srcHost, request.desEmail, request.desHost);
            friendRequests.save(friendRequest);
        } else {
            //other domain redirect
            WebClient webClient = WebClient.builder()
                    .baseUrl(request.desHost)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("method", request.method);
            jsonObject.put("srcEmail", request.srcEmail);
            jsonObject.put("srcHost", request.srcHost);
            jsonObject.put("desEmail", request.desEmail);
            jsonObject.put("desHost", request.desHost);
            jsonObject.put("version", request.version);

            String response = webClient.post()
                    .body(Mono.just(jsonObject.toString()), String.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            System.out.println(response);

            /* URLConnection connection = null;
            try {
                connection = new URL(request.desHost).openConnection();
                connection.setDoOutput(true); //POST
                connection.setRequestProperty("Accept-Charset", "UTF-8");
                connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }

    }

    public void acceptRequest(String friendshipReply) {
        //få fat på request i request table,
        //fjern fra request table
        // add friend connect i relation db
    }


}
