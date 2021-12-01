package dk.kea.techsomeprotocol.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseController {

    //todo køb en ny mus

    @PostMapping("/friendship/{friendshipId}/{reply}") //variable path?
    public void acceptFriendship(@PathVariable Long friendshipId, @PathVariable String reply){ //enums til reply?
        //id på anmodning / email?
        //svar som string

        /*
        response:
        version sp status sp phrase? cr lf
         */
        String response = "1 200 ?\r\n";

    }

    @PostMapping("/friendship/no")
    public void denyFriendship(){

    }
    //Opret bruger
    //Anmode om venskab
    //oplyse hvilken server den nye ven er på ("Host Lookup" kommer senere)
    //Svare på venneanmodninger

    //Accepter
    //Nej
    //Blokér

    //Slet ven
    //Se alle venner
    //Krav til Server:
    //Skal give status koder, an på behov
    //Skal have en offentlig IP (gerne et domæne navn)
}
