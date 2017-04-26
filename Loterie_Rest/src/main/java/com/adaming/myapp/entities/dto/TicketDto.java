package com.adaming.myapp.entities.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class TicketDto {

	
	private Long id;
	private Double prix;
	
	@JsonIgnore
	private ClientDto client;
	
	@JsonIgnore
	private LotDto lot;
	
	public TicketDto() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param id
	 * @param prix
	 */
	public TicketDto(Long id, Double prix) {
		super();
		this.id = id;
		this.prix = prix;
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
	 * @return the client
	 */
	public ClientDto getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(ClientDto client) {
		this.client = client;
	}

	/**
	 * @return the lot
	 */
	public LotDto getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(LotDto lot) {
		this.lot = lot;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketDto [id=" + id + ", prix=" + prix + "]";
	}
	
	
}
