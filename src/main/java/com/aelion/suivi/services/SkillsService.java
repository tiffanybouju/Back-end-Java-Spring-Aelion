/**
 * 
 */
package com.aelion.suivi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aelion.suivi.entities.SkillsEntity;
import com.aelion.suivi.repositories.SkillsRepository;

/**
 * @author Aelion
 *
 */

@Service
public class SkillsService implements ICrud<SkillsEntity> {

	@Autowired
	private SkillsRepository repository;
	
	@Override
	public SkillsEntity add(SkillsEntity t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SkillsEntity[] add(SkillsEntity[] ts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SkillsEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SkillsEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SkillsEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<SkillsEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	public SkillsRepository getRepository() {
		return repository;
	}

	public void setRepository(SkillsRepository repository) {
		this.repository = repository;
	}

}
