/**
 * 
 */
package com.aelion.suivi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Aelion
 *
 */
@Entity
@Table(name="evaluation_intern")
public class InternEvaluationEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private int note;
	
	private String comment;
	
	@ManyToOne() // many evaluation pour un intern
	@JoinColumn(name="intern_id")
	private InternEntity intern; 
	
	@ManyToOne() //many evaluation pour un skill car plusieurs intern
	@JoinColumn(name="skill_id")
	private SkillsEntity skill;
	
	//pour une evaluation on a un skill et un intern
	//many to one il se passe quelque chose dans la base de données
	//quand il y a des attribut dans la relation le many to many n'existe pas	

}
