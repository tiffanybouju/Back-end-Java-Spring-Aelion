/**
 * 
 */
package com.aelion.suivi.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Aelion
 *
 */
public class NotFoundException extends Exception implements HttpErrorInterface {
	public NotFoundException() {
		super();
	}
	public NotFoundException(String message) {
		super(message);
	}
	
public ResponseEntity<String> send() {
	return new ResponseEntity<>(this.getMessage(),HttpStatus.NOT_FOUND);
	 //getMessage pour choper le message de l'exception en retour de la méthode du service
    //new ResponseEntity<> car on veut reprendre le message du service en plus du notfound dpnc il faut pouvoir lui ajouter en paramètre et donc l'instancier
    // si on veut pas prendre le message de l'exception : return ResponseEntity.notFound().build() aurait suffit
    
}
}
