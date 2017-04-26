package com.adaming.myapp.entities.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class LotDto {

	
	private Long id;
	private Double prix;
	private String label;

	@JsonIgnore
	private List<TicketDto> tickets;
	
	public LotDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param prix
	 * @param label
	 */
	public LotDto(Double prix, String label) {
		super();
		this.prix = prix;
		this.label = label;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the prix
	 */
	public Double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(Double prix) {
		this.prix = prix;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LotDto [id=" + id + ", prix=" + prix + ", label=" + label + "]";
	}
	
	
}
