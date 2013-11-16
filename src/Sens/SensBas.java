package Sens;

import Model.SystemAscenseur;
/**
 * La classe SensBas impl�mente l'interface Sens, et donc �crits ses m�thodes, dans cette classe la methode initierSens de {@link Sens} retourne 2.
 * et la methode prochainArret lance la m�thode prochainNiveauDescente() de l'objet system de la classe {@link SystemAscenseur}.
 *
 */
public class SensBas implements Sens{

	@Override
	public void prochainArret(SystemAscenseur system) {
		// TODO Auto-generated method stub
		system.prochainNiveauDescente(); 
	}

	@Override
	public int intierSens() {
		// TODO Auto-generated method stub
		return 2;
	}

}
