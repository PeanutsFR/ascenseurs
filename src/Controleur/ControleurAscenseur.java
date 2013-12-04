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
 * La classe ControleurAscenseur initialise le syst�me de l'ascenseur, il construit l'instance du syst�me et lance les m�thodes qui permettent de commander l'ascenseur en fonction des requ�tes.
 * <p>
 * La classe lance les fonctions du syst�me de l'ascenseur comme : 
 * <ul>
 * <li>la v�rification de l'�tage c'est-�-dire que si l'ascenseur est � l'�tage voulu, il s'arr�te, ouvre la porte, la referme peu de temps apr�s et continue son d�roulement.
 * <li>le d�placement de l'ascenseur, selon le signal.
 * <li>la fonction qui d�termine le prochain arr�t de l'ascenseur, selon son sens et les requ�tes effectu�.
 * <li>Et aussi la fonction qui d�termine quand l'ascenseur doit changer de sens
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
	 * Constructeur de la classe ControleurAscenseur, il cr�� les instances de l'ascenseur, du batiment et ensuite cr�� l'objet de la classe systeme.
	 * Une fois le syst�me cr�� il demarre l'interface graphique.
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
	 * La fonction tache regroupe les actions que doit v�rifier le syst�me pour fonctionner.
	 * En effet il permet gr�ce � la fonction deplacement de la classe {@link SystemAscenseur} d'envoyer le bon signal � l'ascenseur.
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
	 * La m�thode v�rification(), permet de d�tecter quand l'ascenseur est � detination et lorsque qu'il s'y trouve, il lance l'animation de l'ouvertre et de la fermeture de la porte.
	 * Une fois cela effectu�, il supprime la requ�te dans le tableau de requ�te selon sa provenance.
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
	 * La methode changeDeSens(), v�rifie si pendant plus de 5 tentatives de calcul d'une destination pour l'ascenseur dans un sens donn�e, n'a rien donn�e alors il change la direction de l'ascenseur.
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
	 * La fonction demarrage, lance une t�che qu'elle doit effectu� toute les 500 millisecondes.
	 * Cette t�che � r�aliser est de lancer la fonction tache().
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
