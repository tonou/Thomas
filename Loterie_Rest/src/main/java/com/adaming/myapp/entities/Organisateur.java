package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@DiscriminatorValue("Organisateur")
public class Organisateur extends Personne{

	@JsonIgnore
	@OneToMany
	@JoinTable(name="organisateur_ticket")
	private List<Ticket> tickets;
	
	public Organisateur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	

	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}



	/**
	 * @param nom
	 * @param prenom
	 */
	public Organisateur(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
}
