package Model;
/**
 * La classe Ascenseur, repr�sente l'ascenseur, elle contient l'�tat de celui-ci, ainsi que l'�tat de sa porte.
 * 
 * @author emmanuel
 *
 */
public class Ascenseur {

	/*
	 * Variables qui d�termine l'�tat de l'ascenseur, par exemple la vairable 
	 * etat_ascenseur = 0 signifie que l'ascenseur est stationnaire.
	 * etat_porte = 0 signifie porte ferme
	 */
	private int etat_ascenseur = 0;
	private int etat_porte = 0;
	
	
	public Ascenseur(){
		
	}
	
	/**
	 * Fonctions qui permettent d'acc�der � l'�tat de l'ascenseur.
	 */
	public int getEtat_ascenseur() {
		return etat_ascenseur;
	}

	/**
	 * Fonctions qui permettent de modifier l'�tat de l'ascenseur.
	 */
	public void setEtat_ascenseur(int etat_ascenseur) {
		this.etat_ascenseur = etat_ascenseur;
	}

	/**
	 * Fonctions qui permettent d'acc�der � l'�tat de la porte de l'ascenseur.
	 */
	public int getEtat_porte() {
		return etat_porte;
	}

	/**
	 * Fonctions qui permettent de modifier l'�tat de la porte de l'ascenseur.
	 */
	public void setEtat_porte(int etat_porte) {
		this.etat_porte = etat_porte;
	}
	
}
