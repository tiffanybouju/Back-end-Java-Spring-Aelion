/**
 * 
 */
package com.aelion.suivi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aelion.suivi.dto.InternInputDto;
import com.aelion.suivi.dto.InternShortListDto;
import com.aelion.suivi.entities.InternEntity;
import com.aelion.suivi.entities.POEEntity;
import com.aelion.suivi.repositories.InternRepository;
import com.aelion.suivi.repositories.POERepository;

/**
 * @author Aelion
 *
 */
@Service
public class InternService implements ICrud<InternEntity> {
	
	@Autowired
	private InternRepository repository;
	
	@Autowired
	public POERepository poeRepository;
	

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
	
	public List<InternEntity> findByFirstName(String firstName) {
		return this.repository.findByFirstName(firstName);
	
	}
	
	public ResponseEntity<?> byEmail(String email) {
		
		ResponseEntity response = null;
		InternEntity entity = this.repository.internByMail(email);
		if (entity == null) {
		return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.FORBIDDEN);
		}

	
	public InternEntity addInternAndPoes(InternInputDto input) {
		InternEntity intern = new InternEntity();
		
		//Deserialization
		intern.setAddress(input.address);
		intern.setBirthDate(input.birthDate);
		intern.setEmail(input.email);
		intern.setFirstName(input.firstName);
		intern.setName(input.name);
		intern.setPhoneNumber(input.phoneNumber);
		
		// Persists intern
		this.repository.save(intern); // Persistence
		
		// Persists POEs with the new Intern
		input.poes.forEach(inputPoe -> {
			Optional<POEEntity> oPoe = this.poeRepository.findById(inputPoe.getId());
				if (oPoe.isPresent()) {
					POEEntity poe = oPoe.get();
					poe.addIntern(intern);
					this.poeRepository.save(poe);
		}
		});
		return intern;
	}
}
