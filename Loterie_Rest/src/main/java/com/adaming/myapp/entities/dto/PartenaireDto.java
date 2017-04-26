package com.adaming.myapp.entities.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class PartenaireDto extends PersonneDto{

	@JsonIgnore
	private List<LotDto> lots;
	
	public PartenaireDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nom
	 * @param prenom
	 */
	

	/**
	 * @return the lots
	 */
	public List<LotDto> getLots() {
		return lots;
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 */
	public PartenaireDto(Long id, String nom, String prenom) {
		super(id, nom, prenom);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param lots the lots to set
	 */
	public void setLots(List<LotDto> lots) {
		this.lots = lots;
	}


	
	
}
