package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@DiscriminatorValue("Partenaire")
public class Partenaire extends Personne{

	@JsonIgnore
	@OneToMany
	@JoinTable(name="partenaire_lot")
	private List<Lot> lots;
	
	
	public Partenaire() {
		// TODO Auto-generated constructor stub
	}


	

	/**
	 * @param nom
	 * @param prenom
	 */
	public Partenaire(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the lots
	 */
	public List<Lot> getLots() {
		return lots;
	}

	/**
	 * @param lots the lots to set
	 */
	public void setLots(List<Lot> lots) {
		this.lots = lots;
	}


	
	
}
