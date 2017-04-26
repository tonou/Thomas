package com.adaming.myapp.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne{

	public Client() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param nom
	 * @param prenom
	 */
	public Client(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}

	@JsonIgnore
	@OneToMany(mappedBy="client")
	private List<Ticket> tickets;

	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	} 
	
	
}
