/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.dto.POEShortListDto;
import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.services.POEService;
import com.aelion.suivi.services.exception.NotFoundException;

/**
 * @author Aelion
 *
 */
@RestController
@RequestMapping("/poe")
public class POEController {
	
	@Autowired
	private POEService service;
	
	@GetMapping()
	public List<POEEntity> findAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	  public ResponseEntity<?> findOne(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(this.service.getOne(id));
        } catch (NotFoundException e) {
        return e.send();
        }
    }
	
	@PostMapping()
	public POEEntity add(@RequestBody POEEntity poe) {
		return this.service.add(poe);
	}
	
	@GetMapping("/shortlist")
	public List<POEShortListDto> shortList() {
		return this.service.shortlist();
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            this.service.delete((long)id);
            return ResponseEntity.noContent().build();
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<String>("Id was not provided", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
	
	@PutMapping()
	public ResponseEntity<?> update(@RequestBody POEEntity poe){
		this.service.update(poe);
		return ResponseEntity.noContent().build() ;
	// public void update(POEEntity ,poe)marche aussi
	}
	
}

