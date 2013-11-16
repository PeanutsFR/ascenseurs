package Model;

/**
 * La classe Batiment, représente le batiment sur lequel évolue l'application, elle contient le nombre d'étage ainsi que les méthodes pour y accéder.
 * 
 * @author emmanuel
 *
 */
public class Batiment {

	private int nombre_etage;
	
	/**
	 * 
	 * @param nombre_etage lors de sa création on détermine le nombre d'étage que contient le batiment.
	 */
	public Batiment(int nombre_etage){
		this.nombre_etage = nombre_etage;
	}

	/**
	 * 
	 * @return nombre_etage un entier qui est une variable de la classe et qui contient le nombre d'étage du batiment.
	 */
	public int getNombre_etage() {
		return nombre_etage;
	}

	/**
	 * 
	 * @param nombre_etage un entier qui remplace le nombre d'étage du batiment.
	 */
	public void setNombre_etage(int nombre_etage) {
		this.nombre_etage = nombre_etage;
	}
	
}
