package controleur;
import java.util.*;
import controleur.*;
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
	
	public void creationJoueurs() {
		String nomJoueur;
		Scanner clavier = new Scanner(System.in);
		for(int i = 0; i <= this.nbHumain; i++) {
			System.out.println("Veuillez entrer le nom du joueur numero " + (i+1));
			nomJoueur = clavier.nextLine();
			Humain nomJoueur = new Humain();
		}
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
		this.nbRobot = clavier2.nextInt();
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
