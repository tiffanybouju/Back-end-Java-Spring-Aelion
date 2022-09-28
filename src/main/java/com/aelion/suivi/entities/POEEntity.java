package com.aelion.suivi.entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 */

/**
 * @author Aelion
 *
 */
@Entity
@Table(name="poe")
public class POEEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date  beginDate;
	private Date endDate;
	
	@ManyToOne()
	private POETypeEntity poeType;
	
	@ManyToMany()
    @JoinTable( //création de table
    		name = "interns_to_poes", 
    		joinColumns = @JoinColumn(name = "poe_id"), //clef étrangère qui référence les poe que l'on nomme poe_id
    		inverseJoinColumns = @JoinColumn(name = "intern_id")//clef étrangère qui référence les interns que l'on nomme intern_id
    )
    private List<InternEntity> interns = new ArrayList<>();
	//quand on va dans POE on veut pouvoir récupérer tout les interns qui ont particpés à chaque POE
	//on ne le met pas dans POE car on n'a pas d'intérêt à aller chercher un tableau avec toutes les POE de l'intern
	// intervient directement dans la base de donnée
	//le nom des colonnes sert à facilité la lisibilité
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the beginDate
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	/**
	 * @param beginDate the beginDate to set
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the poeType
	 */
	public POETypeEntity getPoeType() {
		return poeType;
	}
	/**
	 * @param poeType the poeType to set
	 */
	public void setPoeType(POETypeEntity poeType) {
		this.poeType = poeType;
	}
	/**
	 * @return the interns
	 */
	public List<InternEntity> getInterns() {
		return interns;
	}
	/**
	 * @param interns the interns to set
	 */
	public void setInterns(List<InternEntity> interns) {
		this.interns = interns;
	}
	
	public void addIntern(InternEntity intern) {
		this.interns.add(intern);
	}
	
}
