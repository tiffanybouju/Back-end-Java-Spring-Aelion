/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.dto.InternShortListDto;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.repositories.InternRepository;

/**
 * @author Aelion
 *
 */
@Service
public class InternService implements ICrud<InternEntity> {
	
	@Autowired
	private InternRepository repository;
	/**
	 * INSERT INFO intern (name, firtName, ..., address) VALUES (...);
	 */
	@Override
	public InternEntity add(InternEntity intern) {
		// TODO Auto-generated method stub
		return this.repository.save(intern);
	}

	@Override
	public InternEntity[] add(InternEntity[] interns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(InternEntity intern) {
		// TODO Auto-generated method stub
		this.repository.save(intern);
	}

	@Override
	public void delete(InternEntity intern) {
		// TODO Auto-generated method stub
		this.repository.delete(intern);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<InternEntity> findAll() {
		return (List<InternEntity>) this.repository.findAll();
	}
	
	/**
	 * 
	 * @return A List of InternShortList object
	 */
	public List<InternShortListDto> shortlist() {
		ArrayList<InternEntity> iterableEntity = (ArrayList<InternEntity>) this.repository.findAll();
		ArrayList<InternShortListDto> dto = new ArrayList<>();
		for(InternEntity entity : iterableEntity) {
			//for const entity: InternEntity of iterableEntity   en ts
			// entity = InternEntity de ArrayList<InternEntity>
			InternShortListDto transformed = new InternShortListDto();
			// instanciation de la class shortlistdto dans transformed
			dto.add(transformed.transform(entity));
		}
		return dto;
	}

	@Override
	public Optional<InternEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return this.repository.findById(id);
	}
	
	public List<InternEntity> findByName(String name) {
		return this.repository.findByName(name);
	}
	
	public List<InternEntity> findByFirstname(String firstname) {
		return this.repository.findByFirstname(firstname);
	
	}
}
