package Main;
 
import Controleur.ControleurAscenseur;
/**
 * 
 * La classe Main est le point d'entré  de l'application.
 *  En effet, c'est elle qui demarre tous.
 *
 */
public class Main {

	public static void main(String[] args){
		ControleurAscenseur controleur = new ControleurAscenseur();
		controleur.demarrage();
	}
}
