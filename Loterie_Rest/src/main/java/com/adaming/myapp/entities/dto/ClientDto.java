package com.adaming.myapp.entities.dto;

import java.util.List;

import com.adaming.myapp.entities.Personne;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class ClientDto extends PersonneDto{

	public ClientDto() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public ClientDto(Long id, String nom, String prenom) {
		super(id, nom, prenom);
		// TODO Auto-generated constructor stub
	}


	@JsonIgnore
	private List<TicketDto> tickets;

	/**
	 * @return the tickets
	 */
	public List<TicketDto> getTickets() {
		return tickets;
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<TicketDto> tickets) {
		this.tickets = tickets;
	}

	
	
	
}

