/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.dto.POEShortListDto;
import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.repositories.POERepository;
import com.aelion.suivi.services.exception.NotFoundException;

/**
 * @author Aelion
 *
 */
@Service
public class POEService implements ICrud<POEEntity> {

	@Autowired
	private POERepository repository;
	
	@Override
	public List<POEEntity> findAll() {
		return (List<POEEntity>) this.repository.findAll();
	}
	
	public POEEntity getOne(Long id) throws Exception {
		Optional<POEEntity> optionalPOEEntity = this.repository.findById(id);
	
		if (optionalPOEEntity.isPresent()) {
		return optionalPOEEntity.get();
		}
		throw new NotFoundException("the POE with " + id + "not found");
	}
	
    @Override
    public Optional<POEEntity> findOne(Long id) {
        // TODO Auto-generated method stub
        return this.repository.findById(id);
        
    }
    
	@Override
	public POEEntity add(POEEntity poe) {
		// TODO Auto-generated method stub
		return this.repository.save(poe);
	}
	
	@Override
	public POEEntity[] add(POEEntity[] poes) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return A List of InternShortList object
	 */
	public List<POEShortListDto> shortlist() {
		ArrayList<POEEntity> iterableEntity = (ArrayList<POEEntity>) this.repository.findAll();
		ArrayList<POEShortListDto> dto = new ArrayList<>();
		for(POEEntity entity : iterableEntity) {
			POEShortListDto transformed = new POEShortListDto();
			dto.add(transformed.transform(entity));
		}
		return dto;
	}
	
	@Override
	public void update(POEEntity poe) {
		// TODO Auto-generated method stub
		this.repository.save(poe);

	}
	
	@Override
	public void delete(Long id) throws Exception {
		Optional<POEEntity> optionalEntity = this.findOne(id);
		
		if (optionalEntity.isPresent()) {
			try {
				this.repository.deleteById((long) id.intValue());
			} catch(IllegalArgumentException e) {
				throw new IllegalArgumentException();
			}
		} else {
		throw new Exception("POE with id : " + id + " was not found!");
	}
	}

	@Override
	public void delete(POEEntity t) {
		// TODO Auto-generated method stub
	}
}
