package com.adaming.myapp.entities;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Personne")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name="Type_de_personne")
public abstract class Personne {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		protected Long id;
		protected String nom;
		protected String prenom;	
	
		
		public Personne() {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param nom
		 * @param prenom
		 */
		

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

	

		/**
		 * @param nom
		 * @param prenom
		 */
		public Personne(String nom, String prenom) {
			super();
			this.nom = nom;
			this.prenom = prenom;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the nom
		 */
		public String getNom() {
			return nom;
		}

		/**
		 * @param nom the nom to set
		 */
		public void setNom(String nom) {
			this.nom = nom;
		}

		/**
		 * @return the prenom
		 */
		public String getPrenom() {
			return prenom;
		}

		/**
		 * @param prenom the prenom to set
		 */
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom
					+ "]";
		}
		
		
	
}
