package Model;

import java.util.ArrayList;

/**
 * La classe SystemAscenseur, contient les méthodes afin de pouvoir contrôler l'ascenseur par l'envoie de signaux, ainsi que les méthodes pour définir la prioritée des requêtes. 
 * @author emmanuel
 * @see Batiment
 * @see Ascenseur
 */
public class SystemAscenseur {

	/*
	 * Ces variables sont les différents signaux qui définissent l'état de
	 * l'ascenseur.
	 */
	private final int signal_stationnaire = 0;
	private final int signal_monter = 1;
	private final int signal_descendre = 2;
	private final int signal_arret_prochain_niveau = 3;
	private final int signal_arret_urgence = 4;
	private final int signal_ouvrir_porte = 1;
	private final int signal_fermer_porte = 0;
	private final float lePas = (float)0.2;
	private final float prochain_niveau = (float)0.1;
	private boolean arret = false;

	public static String source ="";
	private Ascenseur ascenseur = null;

	/*
	 * variable qui servent au positionnement dans le batiment.
	 */
	private Batiment batiment;
	private float etage_destination;
	private float etage_courant;
	
	
	public static int changeDesens = 0;

	/*
	 * tableau qui enregistre les requêtes des utilisateurs.
	 */

	private ArrayList demandeDeMonter;
	private ArrayList demandeDeDescendre;
	private ArrayList demandeEtage;
	
	/**
	 * Elle permet de recevoir l'ascenseur sur lequel la classe agira, ainsi que le batiment dans lequel l'ascenseur évolue.
	 * 
	 * @param ascenseur {@link Ascenseur}
	 * @param batiment {@link Batiment}
	 */
	public SystemAscenseur(Ascenseur ascenseur, Batiment batiment) {
		this.ascenseur = ascenseur;
		this.batiment = batiment;
		etage_destination = -1;
		etage_courant = 0;
		demandeDeMonter = new ArrayList();
		demandeDeDescendre = new ArrayList();
		demandeEtage = new ArrayList();
	}
	
	/**
	 * @return demandeEtage {@link ArrayList}, retourne le tableau contenant les requêtes pour se rendre à un étage particulier.
	 */
	public ArrayList getetage() {
		return this.demandeEtage;
	}

	/**
	 * 
	 * @return etage_courant retourne un float qui se trouve être la variable qui détermine le positionnement de l'ascenseur.
	 */
	public float getEtage_courant() {
		return etage_courant;
	}

	/**
	 * Accesseur de la variable etage_courant.
	 * @param etage_courant un float qui permet de modifier le positionnement de l'ascenseur dans le batiment.
	 */
	public void setEtage_courant(float etage_courant) {
		this.etage_courant = etage_courant;
	}

	/**
	 * La methode monter permet de changer la position de l'ascenseur en incrementant sa position avec un certain "Pas"
	 */
	public void monter() {
		this.ascenseur.setEtat_ascenseur(signal_monter);
		this.etage_courant = Math.round((this.etage_courant*100) + (this.lePas*100));
		this.etage_courant = this.etage_courant/100;
		System.out.println("Monter test float:"+ this.etage_courant);
	}
	
	/**
	 * La methode stationnaire permet de ne pas changer la position de l'ascenseur. 
	 */
	public void stationnaire() {
		this.ascenseur.setEtat_ascenseur(signal_stationnaire);
	}

	/**
	 * La methode descendre permet de changer la position de l'ascenseur en decrementant sa position avec un certain "Pas"
	 */
	public void descendre() {
		if (!arret) {
			this.ascenseur.setEtat_ascenseur(signal_descendre);
			this.etage_courant = Math.round((this.etage_courant*100) - (this.lePas*100));
			this.etage_courant = this.etage_courant/100;
			System.out.println("Descendre test float : "+this.etage_courant);
		}
	}

	/**
	 * La methode arret_urgence, envoie un signal d'arrêt d'urgence et change la variable qui permet à l'ascenseur de ne plus répondre au autre signaux.
	 */
	public void arret_urgence() {
		this.ascenseur.setEtat_ascenseur(signal_arret_urgence);
		this.arret = true;
	}

	/**
	 * Permet d'annuler l'arrêt d'urgence.
	 */
	public void stop_arret_urgence() {
		this.ascenseur.setEtat_ascenseur(signal_arret_urgence);
		this.arret = false;
	}

	/**
	 * La fonction arret_prochain_niveau réalise la même fonction que monter ou descendre, sauf qu'elle incrémente la position moins vite.
	 */
	public void arret_prochain_niveau() {
		if (!arret) {
			this.ascenseur.setEtat_ascenseur(signal_arret_prochain_niveau);
			if (this.etage_courant > this.etage_destination){
				this.etage_courant = (Math.round((this.etage_courant*100) - (this.prochain_niveau*100)));
				this.etage_courant = this.etage_courant/100;
			}else if (this.etage_courant < this.etage_destination){
				this.etage_courant = (Math.round((this.etage_courant*100) + (this.prochain_niveau*100)));
				this.etage_courant = this.etage_courant/100;
			}
		}
		System.out.println("Prochain Arret : "+this.etage_courant);
	}
	
	/**
	 * 
	 * @return etatAscenseur Renvoie l'état de l'ascenseur.
	 * @see Ascenseur
	 */
	public int getEtatAscenseur() {
		return this.ascenseur.getEtat_ascenseur();
	}

	/**
	 * @return etatPorteAscenseur Renvoie l'état de la porte de l'ascenseur.
	 * @see Ascenseur
	 */
	public int getEtatPorteAscenseur() {
		return this.ascenseur.getEtat_porte();
	}

	/**
	 * fonction qui permet d'ouvrir la porte de l'ascenseur en changeant son etat.
	 */
	public void setEtatPorteAscenseurOuvrir() {
		this.ascenseur.setEtat_porte(this.signal_ouvrir_porte);
	}

	/**
	 * fonction qui permet de fermer la porte de l'ascenseur en changeant son etat.
	 */
	public void setEtatPorteAscenseurFermer() {
		this.ascenseur.setEtat_porte(this.signal_fermer_porte);
	}

	/**
	 * fonction qui permet de modifier l'étage ou l'ascenseur doit se rendre.
	 * @param etage_destination un float qui est la nouvelle valeur de destination de l'ascenseur.
	 */
	public void setEtageDestination(float etage_destination) {
		this.etage_destination = etage_destination;
	}

	/**
	 * 
	 * @return etage_destination float désignant l'étage, ou l'ascenseur doit se rendre.
	 */
	public float getEtageDestination() {
		return this.etage_destination;
	}

	/**
	 * fonction retournant le nombre d'étage du batiment.
	 * @return nombreEtage Un entier qui désigne le nombre d'étage de l'ascenseur.
	 */
	public int getNombreEtage() {
		return this.batiment.getNombre_etage();
	}

	/**
	 * Fonction qui rajoute dans la liste des appels de l'ascenseur pour monter l'étage passer en paramètre.
	 * Elle vérifie avant que l'étage qu'on souhaite rajouter ne se trouve pas déjà dans le tableau.
	 * @param etage float qui est la location de l'appel de l'ascenseur pour monter.
	 */
	public void addMonter(float etage) {
		boolean verification = true;
		for (int i = 0; i < this.demandeDeMonter.size(); i++) {
			if (etage == (float) this.demandeDeMonter.get(i)) {
				verification = false;
			}
		}
		if (verification) {
			this.demandeDeMonter.add(etage);
		}

	}

	/**
	 * Fonction qui rajoute dans la liste des appels de l'ascenseur pour descendre l'étage passer en paramètre.
	 * Elle vérifie avant que l'étage qu'on souhaite rajouter ne se trouve pas déjà dans le tableau.
	 * @param etage float qui est la location de l'appel de l'ascenseur pour descendre.
	 */
	public void addDescendre(float etage) {
		boolean verification = true;
		for (int i = 0; i < this.demandeDeDescendre.size(); i++) {
			if (etage == (float) this.demandeDeDescendre.get(i)) {
				verification = false;
			}
		}
		if (verification) {
			this.demandeDeDescendre.add(etage);
		}
	}

	/**
	 * Fonction qui rajoute dans la liste des appels de l'ascenseur pour un étage passer en paramètre.
	 * Elle vérifie avant que l'étage qu'on souhaite rajouter ne se trouve pas déjà dans le tableau.
	 * @param etage float qui est la location ou l'ascenseur doit s'arrêter .
	 */
	public void addEtage(float etage) {
		boolean verification = true;
		for (int i = 0; i < this.demandeEtage.size(); i++) {
			if (etage == (float) this.demandeEtage.get(i)) {
				verification = false;
			}
		}
		if (verification) {
			this.demandeEtage.add(etage);
		}
	}


	/**
	 * fonction qui retourne le prochain étage ou l'ascenseur devra s'arrêter.
	 * @param etage l'étage de référence ou le calcul du prochain étage devra se baser.
	 * @param sens un entier qui détermine le sens dans lequel l'ascenseur se dirige.
	 * 
	 * @return float  un float soit -1 si il n'a rien trouvé, soit l'étage trouver.
	 */
	public float nextEtage(float etage, int sens) {

		float verification = -1;
		for (int i = 0; i < this.demandeEtage.size(); i++) {
			if (sens == 1) {
				if (etage <= (float) this.demandeEtage.get(i)) {
					if (verification == -1)
						verification = (float) this.demandeEtage.get(i);
					verification = Math.min(verification,
							(float) this.demandeEtage.get(i));
				}
			} else if (sens == 2) {
				if (etage >= (float) this.demandeEtage.get(i)) {
					if (verification == -1)
						verification = (float) this.demandeEtage.get(i);
					verification = Math.max(verification,
							(float) this.demandeEtage.get(i));
				}
			}
		}
		return verification;
	}

	/**
	 * fonction qui retourne le prochain étage ou l'ascenseur devra s'arrêter en montant et met à jour la variable,
	 * etage de destination du système.Pour savoir qu'elle étage sera traité, cette fonction évalue toute les possiblitées en montant :
	 * <ul>
	 * <li>Tout d'abord dans la liste des étages demandés à l'intérieur de la cabine, on vérifie celle la plus proche en montant.
	 * <li>Ensuite, on compare l'étage trouvé ou non, par les demandes pour monter qui sont plus haut que l'étage courant, et on garde le plus proche.
	 * <li>Et pour finir si aucune des deux méthodes précédentes n'ont de destination, on vérifie la requête pour descendre qui est supérieur à l'étage courant et qui se trouve au plus haut. 
	 * </ul>
	 * 
	 */
	public void prochainNiveauMonte() {

		float destination_tampon = -1;
		float etage = getEtage_courant();
		destination_tampon = nextEtage(etage, 1);
		source = "Etage";
		for (int i = 0; i < this.demandeDeMonter.size(); i++) {
			if (etage <= (float) this.demandeDeMonter.get(i)) {
				if(destination_tampon == -1)
					destination_tampon = (float) this.demandeDeMonter.get(i);
				destination_tampon = Math.min(destination_tampon,(float) this.demandeDeMonter.get(i));
				source="Monter";
			}
		}
		
		if(destination_tampon == -1){
			for (int i = 0; i < this.demandeDeDescendre.size(); i++) {
				if (etage <= (float) this.demandeDeDescendre.get(i)) {
					if(destination_tampon == -1)
						destination_tampon = (float) this.demandeDeDescendre.get(i);
					destination_tampon = Math.max(destination_tampon,(float) this.demandeDeDescendre.get(i));
					source="Descente";
				}
			}
		}
		
		if(destination_tampon == -1){
			changeDesens++;
		}else{
			changeDesens = 0;
		}
		System.out.println("Monter : "+destination_tampon);
		this.setEtageDestination(destination_tampon);
	}

	/**
	 * fonction qui retourne le prochain étage ou l'ascenseur devra s'arrêter en descendant et met à jour la variable,
	 * etage de destination du système.Pour savoir qu'elle étage sera traité, cette fonction évalue toute les possiblitées en descendant :
	 * <ul>
	 * <li>Tout d'abord dans la liste des étages demandés à l'intérieur de la cabine, on vérifie celle la plus proche en descendant.
	 * <li>Ensuite, on compare l'étage trouvé ou non, par les demandes pour descendre qui sont plus basse que l'étage courant, et on garde le plus proche.
	 * <li>Et pour finir si aucune des deux méthodes précédentes n'ont de destination, on vérifie la requête pour monter qui est inférieur à l'étage courant et qui se trouve au plus bas. 
	 * </ul>
	 * 
	 */
	public void prochainNiveauDescente() {
		float destination_tampon = -1;
		float etage = getEtage_courant();
		destination_tampon = nextEtage(etage, 2);
		source="Etage";
		for (int i = 0; i < this.demandeDeDescendre.size(); i++) {
			if (etage >= (float) this.demandeDeDescendre.get(i)) {
				if(destination_tampon == -1)
					destination_tampon = (float) this.demandeDeDescendre.get(i);
				destination_tampon = Math.max(destination_tampon,(float) this.demandeDeDescendre.get(i));
				source="Descente";
			}
		}
		
		if(destination_tampon == -1){
			for (int i = 0; i < this.demandeDeMonter.size(); i++) {
				if (etage >= (float)this.demandeDeMonter.get(i)) {
					if(destination_tampon == -1)
						destination_tampon = (float) this.demandeDeMonter.get(i);
					destination_tampon = Math.min(destination_tampon,(float) this.demandeDeMonter.get(i));
					source = "Monter";
				}
			}
		}
		
		if(destination_tampon == -1){
			changeDesens++;
		}else{
			changeDesens = 0;
		}
		System.out.println("Descente : "+destination_tampon);
		this.setEtageDestination(destination_tampon);
	}

	/**
	 * Fonction qui supprime dans le tableau des requêtes pour monter, la valeur passé en paramètre.
	 * @param courant Un float qui represente la valeur de l'étage qu'on doit supprimer dans la liste des demandes pour monter.
	 */
	public void removeMonter(float courant) {
		Float obj1 = new Float(courant);
		for (int i = 0; i < this.demandeDeMonter.size(); i++) {
			Float obj2 = new Float((float)this.demandeDeMonter.get(i));
			if (obj1.compareTo(obj2) == 0 ) {
				this.demandeDeMonter.remove(i);
			}
		}
	}

	/**
	 * Fonction qui supprime dans le tableau des requêtes pour descendre, la valeur passé en paramètre.
	 * @param courant Un float qui represente la valeur de l'étage qu'on doit supprimer dans la liste des demandes pour descendre.
	 */
	public void removeDescendre(float courant) {
		Float obj1 = new Float(courant);
		for (int i = 0; i < this.demandeDeDescendre.size(); i++) {
			Float obj2 = new Float((float)this.demandeDeDescendre.get(i));
			if (obj1.compareTo(obj2) == 0 ) {
				this.demandeDeDescendre.remove(i);
			}
		}
	}

	/**
	 * Fonction qui supprime dans le tableau des requêtes pour l'étage choisie dans la cabine, la valeur passé en paramètre.
	 * @param courant Un float qui represente la valeur de l'étage qu'on doit supprimer dans la liste des demandes d'étages.
	 */
	public void removeEtage(float courant) {
		Float obj1 = new Float(courant);
		for (int i = 0; i < this.demandeEtage.size(); i++) {
			Float obj2 = new Float((float)this.demandeEtage.get(i));
			if (obj1.compareTo(obj2) == 0 ) {
				this.demandeEtage.remove(i);
			}
		}
	}

	/**
	 * La fonction deplacement, vérifie l'étage ou l'ascenseur se trouve et l'étage ou il doit aller et en déduit le déplacement qu'il doit effectuer.
	 */
	public void deplacement() {
		if (getEtage_courant() == getEtageDestination() && getEtageDestination() == -1) {
			stationnaire();
		} else if (getEtage_courant() > getEtageDestination() && getEtageDestination() != -1) {
			if ((getEtage_courant() - 1) < getEtageDestination() && getEtageDestination() != -1)
				arret_prochain_niveau();
			else
				descendre();
		} else if (getEtage_courant() < getEtageDestination()&& getEtageDestination() != -1) {
			if ((getEtage_courant() + 1) > getEtageDestination()&& getEtageDestination() != -1)
				arret_prochain_niveau();
			else
				monter();
		}
	}
}
