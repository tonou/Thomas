package com.adaming.myapp.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double prix;
	
	@JsonIgnore
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="FK_client")
	private Client client;
	
	@JsonIgnore
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="FK_lot")
	private Lot lot;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param prix
	 */
	public Ticket(Double prix) {
		super();
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
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the lot
	 */
	public Lot getLot() {
		return lot;
	}

	/**
	 * @param lot the lot to set
	 */
	public void setLot(Lot lot) {
		this.lot = lot;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", prix=" + prix + "]";
	}


	
	
}
