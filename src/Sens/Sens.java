package sens;

import modele.SystemAscenseur;
/**
 * Interface qui execute les fonctions qui réagissent différement selon le sens de l'ascenseur.
 * @author emmanuel
 */
public interface Sens {
	/**
	 * 
	 * @return int Un entier qui permet de déterminer dans quel sens se trouve l'ascenseur. plus précisement sert à identifier les différentes classes qui implement l'interface {@link Sens}.
	 */
	public int intierSens();
	
	/**
	 * 
	 * @param system le systeme d'ascenseur sur lequel il executera la méthode pour déterminer le prochain arrêt e l'ascenseur.
	 */
	public void prochainArret(SystemAscenseur system);
}
