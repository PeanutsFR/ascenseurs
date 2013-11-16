package Model;
/**
 * La classe Ascenseur, représente l'ascenseur, elle contient l'état de celui-ci, ainsi que l'état de sa porte.
 * 
 * @author emmanuel
 *
 */
public class Ascenseur {

	/*
	 * Variables qui détermine l'état de l'ascenseur, par exemple la vairable 
	 * etat_ascenseur = 0 signifie que l'ascenseur est stationnaire.
	 * etat_porte = 0 signifie porte ferme
	 */
	private int etat_ascenseur = 0;
	private int etat_porte = 0;
	
	
	public Ascenseur(){
		
	}
	
	/**
	 * Fonctions qui permettent d'accéder à l'état de l'ascenseur.
	 */
	public int getEtat_ascenseur() {
		return etat_ascenseur;
	}

	/**
	 * Fonctions qui permettent de modifier l'état de l'ascenseur.
	 */
	public void setEtat_ascenseur(int etat_ascenseur) {
		this.etat_ascenseur = etat_ascenseur;
	}

	/**
	 * Fonctions qui permettent d'accéder à l'état de la porte de l'ascenseur.
	 */
	public int getEtat_porte() {
		return etat_porte;
	}

	/**
	 * Fonctions qui permettent de modifier l'état de la porte de l'ascenseur.
	 */
	public void setEtat_porte(int etat_porte) {
		this.etat_porte = etat_porte;
	}
	
}
