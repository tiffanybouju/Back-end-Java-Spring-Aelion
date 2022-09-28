/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.entities.POETypeEntity;
import com.aelion.suivi.repositories.POETypeRepository;
import com.aelion.suivi.services.exception.NotFoundException;

/**
 * @author Aelion
 *
 */
@Service
public class POETypeService implements ICrud<POETypeEntity> {

	@Autowired
	private POETypeRepository repository;

	@Override
	public POETypeEntity add(POETypeEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public POETypeEntity[] add(POETypeEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(POETypeEntity t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(POETypeEntity t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<POETypeEntity> findAll() {
		return (List<POETypeEntity>) this.repository.findAll();
	}

	public POETypeEntity getOne(Long id) throws Exception {
		Optional<POETypeEntity> optionalPOETypeEntity = this.repository.findById(id.intValue());
	
		if (optionalPOETypeEntity.isPresent()) {
		return optionalPOETypeEntity.get();
		}
		throw new NotFoundException("the POEType with " + id + "not found");
	}

	@Override
	public Optional<POETypeEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
}
