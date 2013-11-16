package Model;

/**
 * La classe Batiment, repr�sente le batiment sur lequel �volue l'application, elle contient le nombre d'�tage ainsi que les m�thodes pour y acc�der.
 * 
 * @author emmanuel
 *
 */
public class Batiment {

	private int nombre_etage;
	
	/**
	 * 
	 * @param nombre_etage lors de sa cr�ation on d�termine le nombre d'�tage que contient le batiment.
	 */
	public Batiment(int nombre_etage){
		this.nombre_etage = nombre_etage;
	}

	/**
	 * 
	 * @return nombre_etage un entier qui est une variable de la classe et qui contient le nombre d'�tage du batiment.
	 */
	public int getNombre_etage() {
		return nombre_etage;
	}

	/**
	 * 
	 * @param nombre_etage un entier qui remplace le nombre d'�tage du batiment.
	 */
	public void setNombre_etage(int nombre_etage) {
		this.nombre_etage = nombre_etage;
	}
	
}
