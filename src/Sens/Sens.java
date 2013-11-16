package sens;

import modele.SystemAscenseur;
/**
 * Interface qui execute les fonctions qui r�agissent diff�rement selon le sens de l'ascenseur.
 * @author emmanuel
 */
public interface Sens {
	/**
	 * 
	 * @return int Un entier qui permet de d�terminer dans quel sens se trouve l'ascenseur. plus pr�cisement sert � identifier les diff�rentes classes qui implement l'interface {@link Sens}.
	 */
	public int intierSens();
	
	/**
	 * 
	 * @param system le systeme d'ascenseur sur lequel il executera la m�thode pour d�terminer le prochain arr�t e l'ascenseur.
	 */
	public void prochainArret(SystemAscenseur system);
}
