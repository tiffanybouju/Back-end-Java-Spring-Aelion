/**
 * 
 */
package com.aelion.suivi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.aelion.suivi.entities.InternEntity;

/**
 * @author Aelion
 *
 */
public interface InternRepository extends CrudRepository<InternEntity, Long> {
	/** 
	 * DELETE FROM internEntity.tablename WHERE id = 1; // delete(1)
	 * SLECT + FROM internEntity; // findAll() 
	 * SELECT * FROM internEntity WHERE internEntity.id = 1 // findOne(1)
	 * 
	 * INSERT INTO intern
	 * (name, first_name, birth_date, email, phone_number, address)
	 *VALUES
	 * ('Tartemption', 'Jean', '1989-10-22', 'j.tartemption@gmail;com', '05', '10');
	 * 
	 * UPDATE intern SET name='Van DAme', first_name='Jean-Claude', 
	 * birth_Date='1963-04-15', email='jevs@aware.com', phone_number='06', 
	 * address='AAnvers' WHERE id = 4;
	 * 
	 */
public List<InternEntity>findByName(String name);
public List<InternEntity>findByFirstName (String firstName);
//retourne une list quoi qu'il arrive

@Query("SELECT i FROM InternEntity i WHERE i.email = :email")
public InternEntity internByMail(@Param("email")String email);
	

}
