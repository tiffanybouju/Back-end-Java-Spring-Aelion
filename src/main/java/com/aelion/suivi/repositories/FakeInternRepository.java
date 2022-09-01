/**
 * 
 */
package com.aelion.suivi.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.aelion.suivi.entities.InternEntity;

/**
 * @author Aelion
 *
 */
public final class FakeInternRepository {
	private List<InternEntity> interns = new ArrayList<>();
	//interns attribut de type List qui ne pourra contenir que des objets de type InternEntity
	
	public FakeInternRepository() {
		this.populate();
	}
	
	public List<InternEntity> getInterns() {
		return this.interns;
	}
	
	public InternEntity add(InternEntity intern) {
	//type de retour avant le nom de la méthode. InternEntity est le retour d'une méthode add dont les paramètres sont un intern de type InternEntity
		this.interns.add(intern);
		return intern;
	}
	
    /**
     * public add(intern: InternEntity): InternEntity {
     *     this.interns.push(intern);
     *     return intern;
     * }
     */
	
	public void delete(InternEntity intern) {
		this.interns.remove(intern);
	}
	
	public Optional<InternEntity> findOne(Long id) {
		for (InternEntity intern : this.interns) {
			if (intern.getId() == id) {
				return Optional.of(intern);
			}
		}
		return Optional.empty();
	}
	
	public InternEntity getOne(Long id) {
		for (InternEntity intern : interns) {
			if (intern.getId() == id) {
				return intern;
			}
		}
		return null;
	}

	private void populate() { 
		//populate est un setter car il ajoute la list interns 
		InternEntity intern = new InternEntity();
		// const intern: InternEntity = new InternEntity
		intern.setId(1L);
		//1L est 1 en longue
		intern.setName("Aubert");
		intern.setFirstname("Jean");
		intern.setEmail("qjhrgqhg@gmail.com");
		intern.setPhonenumber("+(33)6 58 23 69 41");
		
		this.interns.add(intern);
		
		intern = new InternEntity();
		intern.setId(2L);
		intern.setName("Philippe");
		intern.setFirstname("Didier");
		intern.setEmail("gqrghqzr@gmail.com");
		intern.setPhonenumber("+(33)6 58 31 69 14"); 
		this.interns.add(intern);
	}
}
