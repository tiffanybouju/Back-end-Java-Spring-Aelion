/**
 * 
 */
package com.aelion.suivi.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.dto.InternInputDto;
import com.aelion.suivi.dto.InternShortListDto;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.services.InternService;

/**
 * @author Aelion
 *
 */
@RestController
@RequestMapping("/intern")
public class InternController {
	
	@Autowired
	private InternService internService;
	
	/**
	 * @param InternInputDto
	 * @return 201 http-status
	 */
	@PostMapping
	@CrossOrigin
	public InternEntity add(@RequestBody InternInputDto intern) {
		return this.internService.addInternAndPoes(intern);
	}
	
//	/**
//	 * 
//	 * @param intern
//	 * @return
//	 */
//	
//	@PostMapping()
//	@CrossOrigin()
//	public InternEntity add(@RequestBody InternEntity intern) {
//		return this.internService.add(intern);
//	}
	
	@GetMapping("/shortlist")
	public List<InternShortListDto> shortList() {
		return this.internService.shortlist();
	}
	
	@GetMapping("/byemail")
	@CrossOrigin
	public ResponseEntity<?> byEmail(@RequestParam() String email) {
	return this.internService.byEmail(email);
	}
	//@RequestParam() fait référence au paramètre passé dans une URI sous la forme suivante :
	//http://127.0.0.1:5000/intern/bymail?email=truc@machin.com
	//On appelle ce qui se situe après le ? la Query String.
				
	@GetMapping("/{id}")
	//la route
	@CrossOrigin
	public ResponseEntity<?> findOne(@PathVariable Long id) {
		Optional<InternEntity> oInternEntity = this.internService.findOne(id);
		
		if (oInternEntity.isPresent()) {
			return ResponseEntity.ok(oInternEntity.get());
		}	//envoie 200 
		return ResponseEntity.notFound().build();
	}	//envoie 404
	
	@GetMapping()
	@CrossOrigin
	public List<InternEntity> getAll() {
		return this.internService.findAll();
	}

	@DeleteMapping()
	@CrossOrigin
	public ResponseEntity<InternEntity>delete(@RequestBody InternEntity intern) {
		this.internService.delete(intern);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping()
	public ResponseEntity<?>update(@RequestBody InternEntity intern){
		this.internService.update(intern);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/byname/{name}")
	public List<InternEntity> findByName(@PathVariable String name){
	return this.internService.findByName(name);
	}
	
	@GetMapping("/byfirstname/{firstname}")
	public List<InternEntity> findByFirstname(@PathVariable String firstName){
	return this.internService.findByFirstName(firstName);
	}
	
}
	