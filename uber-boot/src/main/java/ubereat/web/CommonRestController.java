package ubereat.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ubereat.model.Status;
import ubereat.model.Transport;
import ubereat.model.TypesPlats;
import ubereat.model.TypesRestos;

@RestController
@CrossOrigin("*")
public class CommonRestController {

	
	 @GetMapping("/transports")
	    public Transport[] getTransport() {
	        return Transport.values();
	    }
	 @GetMapping("/status")
	    public Status[] getStatus() {
	        return Status.values();
	    }

	 @GetMapping("/typesRestos")
	 public TypesRestos[] getTypesRestos() {
		 return TypesRestos.values();
	 }
	 @GetMapping("/typesplats")
	 public TypesPlats[] getTypesPlats() {
		 return TypesPlats.values();
	 }
}
