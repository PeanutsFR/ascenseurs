package Controleur;
 
import java.util.Timer;
import java.util.TimerTask;

import Sens.*;
import Vue.PanneauExterne;
import Vue.PanneauInterne;
import Vue.Test;
import Model.*;
/**
 * <p>
 * La classe ControleurAscenseur initialise le système de l'ascenseur, il construit l'instance du système et lance les méthodes qui permettent de commander l'ascenseur en fonction des requêtes.
 * <p>
 * La classe lance les fonctions du système de l'ascenseur comme : 
 * <ul>
 * <li>la vérification de l'étage c'est-à-dire que si l'ascenseur est à l'étage voulu, il s'arrête, ouvre la porte, la referme peu de temps après et continue son déroulement.
 * <li>le déplacement de l'ascenseur, selon le signal.
 * <li>la fonction qui détermine le prochain arrêt de l'ascenseur, selon son sens et les requêtes effectué.
 * <li>Et aussi la fonction qui détermine quand l'ascenseur doit changer de sens
 * </ul>
 * @see Ascenseur
 * @see SystemAscenseur
 * @see #changeDeSens()
 * @see #verification()
 * 
 */
public class ControleurAscenseur {
	
	private SystemAscenseur systeme;
	private Sens direction;
	
	/**
	 * <p>
	 * Constructeur de la classe ControleurAscenseur, il créé les instances de l'ascenseur, du batiment et ensuite créé l'objet de la classe systeme.
	 * Une fois le système créé il demarre l'interface graphique.
	 * <p>
	 * 
	 */
	public ControleurAscenseur(){
		Ascenseur ascenseur = new Ascenseur();
		Batiment batiment = new Batiment(5);
		
		this.direction = new SensHaut();
		this.systeme = new SystemAscenseur(ascenseur, batiment);
		
		Test test = new Test(this.systeme);
		PanneauInterne panneauinterne = new PanneauInterne(this.systeme);
		PanneauExterne panneauexterne = new PanneauExterne(this.systeme);
	}
	
	/**
	 * <p>
	 * La fonction tache regroupe les actions que doit vérifier le système pour fonctionner.
	 * En effet il permet grâce à la fonction deplacement de la classe {@link SystemAscenseur} d'envoyer le bon signal à l'ascenseur.
	 * Il y a aussi d'autre fonction comme :
	 * <p>
	 * <ul>{@link #verification()}
	 * <li>{@link #changeDeSens()}
	 * <li> prochainArret de la classe {@link SystemAscenseur}
	 * </ul>
	 */
	public void tache(){
		this.systeme.deplacement();
		verification();
		this.direction.prochainArret(this.systeme);
		changeDeSens();
	}
	
	/**
	 * La méthode vérification(), permet de détecter quand l'ascenseur est à detination et lorsque qu'il s'y trouve, il lance l'animation de l'ouvertre et de la fermeture de la porte.
	 * Une fois cela effectué, il supprime la requête dans le tableau de requête selon sa provenance.
	 * {@link SystemAscenseur}
	 */
	public void verification(){
		if(this.systeme.getEtage_courant() == this.systeme.getEtageDestination()){
			try {
				Thread.sleep(1000);
				
				this.systeme.setEtatPorteAscenseurOuvrir();
				System.out.println("il faut changer le bouton "+this.systeme.getEtageDestination());
				
				System.out.println("Porte ouverte !!");
				Thread.sleep(1000);
				
				this.systeme.setEtatPorteAscenseurFermer();
				System.out.println("Porte fermer !!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(SystemAscenseur.source.equals("Monter")){
				this.systeme.removeMonter(this.systeme.getEtage_courant());
			}else if(SystemAscenseur.source.equals("Descente")){
				this.systeme.removeDescendre(this.systeme.getEtage_courant());
			}
			this.systeme.removeEtage(this.systeme.getEtage_courant());
		}
	}
	
	/**
	 * <p>
	 * La methode changeDeSens(), vérifie si pendant plus de 5 tentatives de calcul d'une destination pour l'ascenseur dans un sens donnée, n'a rien donnée alors il change la direction de l'ascenseur.
	 * <p>
	 */
	public void changeDeSens(){
		
		if(SystemAscenseur.changeDesens == 5){
			switch(this.direction.intierSens()){
			case 1 : this.direction = new SensBas();
					 break;
			case 2 : this.direction = new SensHaut();
					 break;
			default : break;
			}
			SystemAscenseur.changeDesens=0;
		}
	}
	
	/**
	 * La fonction demarrage, lance une tâche qu'elle doit effectué toute les 500 millisecondes.
	 * Cette tâche à réaliser est de lancer la fonction tache().
	 */
	public void demarrage(){
		
		TimerTask task = new TimerTask()
		{
			@Override
			public void run() 
			{
				tache();
			}	
		};
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(task, 0, 500);
	}
}
