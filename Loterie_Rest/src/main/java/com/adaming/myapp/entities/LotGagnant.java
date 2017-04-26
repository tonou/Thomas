package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Lot_gagnant")
public class LotGagnant  extends Lot{

	public LotGagnant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param prix
	 * @param label
	 */
	public LotGagnant(Double prix, String label) {
		super(prix, label);
		// TODO Auto-generated constructor stub
	}
	
	
}
