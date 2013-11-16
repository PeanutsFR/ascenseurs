package Sens;

import Model.SystemAscenseur;
/**
 * La classe SensHaut impl�mente l'interface Sens, et donc �crits ses m�thodes, dans cette classe la methode initierSens de {@link Sens} retourne 1.
 * et la methode prochainArret lance la m�thode prochainNiveauMonte() de l'objet system de la classe {@link SystemAscenseur}.
 *
 */
public class SensHaut implements Sens{
	
	@Override
	public void prochainArret(SystemAscenseur system) {
		// TODO Auto-generated method stub
		system.prochainNiveauMonte();
	}
	
	@Override
	public int intierSens() {
		// TODO Auto-generated method stub
		return 1;
	}

}
