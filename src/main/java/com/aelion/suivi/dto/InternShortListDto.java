/**
 * 
 */
package com.aelion.suivi.dto;

import java.util.Date;

import com.aelion.suivi.entities.InternEntity;

/**
 * @author Aelion
 *
 */
public class InternShortListDto {
	public Long id;
	public String name;
	public String firstName;
	public Date birthDate;
	
	public InternShortListDto transform(InternEntity intern) {
		this.id = intern.getId();
		this.name = intern.getName();
		this.firstName = intern.getFirstName();
		this.birthDate = intern.getBirthDate();
		
		return this;
		//on le transforme et on le retourne
	}

}
