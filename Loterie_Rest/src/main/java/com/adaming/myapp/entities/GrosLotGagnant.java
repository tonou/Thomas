package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Gros_lot_gagnant")
public class GrosLotGagnant extends Lot {
	
	public GrosLotGagnant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param prix
	 * @param label
	 */
	public GrosLotGagnant(Double prix, String label) {
		super(prix, label);
		// TODO Auto-generated constructor stub
	}
	
	

}
