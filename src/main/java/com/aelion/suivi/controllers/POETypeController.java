/**
 * 
 */
package com.aelion.suivi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aelion.suivi.entities.POETypeEntity;
import com.aelion.suivi.services.POETypeService;
import com.aelion.suivi.services.exception.NotFoundException;

/**
 * @author Aelion
 *
 */
@RestController
@RequestMapping("/poetype")
public class POETypeController {

	@Autowired
	private POETypeService service;

	/**
	 * @param t
	 * @return
	 * @see com.aelion.suivi.services.POETypeService#add(com.aelion.suivi.entities.POETypeEntity)
	 */
	public POETypeEntity add(POETypeEntity t) {
		return service.add(t);
	}

	/**
	 * @param ts
	 * @return
	 * @see com.aelion.suivi.services.POETypeService#add(com.aelion.suivi.entities.POETypeEntity[])
	 */
	public POETypeEntity[] add(POETypeEntity[] ts) {
		return service.add(ts);
	}

	/**
	 * @param t
	 * @see com.aelion.suivi.services.POETypeService#delete(com.aelion.suivi.entities.POETypeEntity)
	 */
	public void delete(POETypeEntity t) {
		service.delete(t);
	}

	/**
	 * @param id
	 * @throws Exception
	 * @see com.aelion.suivi.services.POETypeService#delete(java.lang.Long)
	 */
	public void delete(Long id) throws Exception {
		service.delete(id);
	}

	/**
	 * @return
	 * @see com.aelion.suivi.services.POETypeService#findAll()
	 */
	@GetMapping()
	public List<POETypeEntity> findAll() {
		return this.service.findAll();
	}

	/**
	 * @param id
	 * @return
	 * @throws Exception 
	 * @see com.aelion.suivi.services.POETypeService#findOne(java.lang.Long)
	 */
	@GetMapping("/{id}")
	@CrossOrigin
	public ResponseEntity<?> findOne(@PathVariable Long id) throws Exception {
		try {
			return ResponseEntity.ok(service.getOne(id));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			return e.send();
		}
	}

}
