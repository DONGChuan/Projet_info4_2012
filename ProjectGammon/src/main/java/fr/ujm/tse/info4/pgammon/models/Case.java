// 
//
//  @ Projet : Project Gammon
//  @ Fichier : Case.java
//  @ Date : 12/12/2012
//  @ Auteurs : DONG Chuan, BONNETTO Benjamin, FRANCON Adrien, POTHELUNE Jean-Michel
//
//

package fr.ujm.tse.info4.pgammon.models;

public class Case {
	private CouleurCase couleurDame;
	private int nbDame;
	
	private int position;

	public Case(CouleurCase couleur, int nbDame, int position) {
		this.couleurDame = couleur;
		this.nbDame = nbDame;
		this.position = position;
	}

	public boolean isCaseVictoire() {
		if (position == 25 && couleurDame == CouleurCase.BLANC
				|| position == 0 && couleurDame == CouleurCase.NOIR)
			return true;
		else
			return false;
	}

	public boolean ajoutDame(CouleurCase couleur) {
		
		//Si la case et de la même couleur on ajout une dame
		if (this.couleurDame == couleur) {
			nbDame += 1;
			return true;
		} 
		//sinon si la case est vide on change de couleur et on increment
		else if(this.couleurDame == CouleurCase.VIDE)
		{
			nbDame += 1;
			this.couleurDame = couleur;
			return true;
		}
		//sinon si la case et de la couleur inverse et que il y a moins d'un jeton
		//on change juste de couleur
		else if (nbDame <= 1) {
			this.couleurDame = couleur;
			return true;
		} 
		//sinon probléme
		else
			return false;

	}

	public boolean moinDame() {
		if (nbDame >= 1) {
			nbDame -= 1;
			if (nbDame == 0)
				couleurDame = CouleurCase.VIDE;
			return true;
		} else
			return false;

	}

	/**
	 * 
	 * Getters
	 * 
	 */

	public CouleurCase getCouleurDame() {
		return couleurDame;
	}

	public int getNbDame() {
		return nbDame;
	}

	public int getPosition() {
		return position;
	}

}
