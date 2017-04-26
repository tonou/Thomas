package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Lot_perdant")
public class LotPerdant  extends Lot{

	public LotPerdant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param prix
	 * @param label
	 */
	public LotPerdant(Double prix, String label) {
		super(prix, label);
		// TODO Auto-generated constructor stub
	}
	
	
}
