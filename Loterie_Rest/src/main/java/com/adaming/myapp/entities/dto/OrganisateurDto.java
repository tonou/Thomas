package com.adaming.myapp.entities.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class OrganisateurDto extends PersonneDto{

	@JsonIgnore
	private List<TicketDto> tickets;
	
	public OrganisateurDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	
	/**
	 * @return the tickets
	 */
	public List<TicketDto> getTickets() {
		return tickets;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public OrganisateurDto(Long id, String nom, String prenom) {
		super(id, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<TicketDto> tickets) {
		this.tickets = tickets;
	}
	
	
	
}
