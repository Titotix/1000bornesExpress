package controleur;
import java.util.*;

import modele.*;

public class Menu {
	
	private int nbRobot, nbHumain;
	private byte variante;
	//constructeur
	public Menu(){
		
	}
	//Cette méthode n'a de raison d'etre que tant qu'on a pas implementer l'interface graphique,
	// c'est la vue qui fera ce travail.
	public void contextuel() {
		int choix;
		System.out.println("Entrer le numero correspondant a ce que vous souhaitez");
		System.out.println("\n 1. Nouvelle partie");
		Scanner a = new Scanner(System.in);
		choix = a.nextInt();
		switch(choix) {
		case 1: this.nouvellePartie();
		break;
		}
	}
	
	
	//Cr�er une nouvelle partie
	public void nouvellePartie (){
	
		this.setNbRobot();
		this.setNbHumain();
		
		
	}
	
	public void creationJoueurs(Menu menu) {
		
		String nomJoueur;
		
		Humain[] humain = new Humain[menu.getNbHumain()];
		
		for(int i = 0; i < this.nbHumain; i++) {

			humain[i] =  new Humain(this.getNomHumain(i+1), i+1);
	
		}

		Robot[] robot = new Robot[menu.getNbRobot()];

		for(int j = 0; j < this.nbRobot; j++) {
			
			robot[j] =  new Robot(this.getNomRobot(j+1), j+1+menu.getNbHumain());
	}
		
		

	}
	
	
	
	public String getNomHumain(int i) {
		String nomJoueur;
		Scanner clavier = new Scanner(System.in);
		System.out.println("Veuillez entrer le nom du joueur numero " + i);
		nomJoueur = clavier.next();
		return nomJoueur;
		
	}
	/**
	 * Génére des noms prédéfini pour les robots
	 * @param i
	 * @return nom de robot
	 */
	public String getNomRobot(int i) {
		String[] nomRobot = new String[6];
		nomRobot[1] = "Gérard";
		nomRobot[2] = "Jeau-Paul";
		nomRobot[3] = "Jeannine";
		nomRobot[4] = "Grégoire";
		nomRobot[5] = "Paulette";
		return nomRobot[i];
		
	}
	
	//D�finir nombre d'IA
	public void setNbRobot (){
		Scanner clavier = new Scanner(System.in);
		System.out.println("Entrez le nombre d'adversaire géré par l'ordinateur que vous voulez créer.");
		this.nbRobot = clavier.nextInt();
		
		
	}
	
	//D�finir nombre d'humains
	public void setNbHumain (){

		Scanner clavier2 = new Scanner(System.in);
		System.out.println("Entrez le nombre d'adversaire humain avec qui vous allez jouer, en vous incluant vous même.");
		this.nbHumain = clavier2.nextInt();
	}
	
	public int getNbJoueurTotal() {
		return this.nbHumain + this.nbRobot ;
	}
	
	public int getNbHumain() {
		return this.nbHumain;
	}
	
	public int getNbRobot() {
		return this.nbRobot;
	}
	


	
}
