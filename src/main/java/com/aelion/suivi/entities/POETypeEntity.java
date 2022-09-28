/**
 * 
 */
package com.aelion.suivi.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Aelion
 *
 */

@Entity()
@Table(name="poe_type")
public class POETypeEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=50)
	private String name;
	
	/**
	 * @return the title
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param title the title to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
	
	

