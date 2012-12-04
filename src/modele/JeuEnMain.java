package modele;

import java.util.*;

import controleur.*;

public class JeuEnMain extends Observable{

	private int nombreCarte;
	private boolean carteJouee;
	private LinkedList<Carte> main;
	
	public JeuEnMain(){
		
		
	}
	
	//Permet d'ajouter une carte apres la pioche
	public void ajouterCarte(Carte carte) {
		this.main.add(carte);
		
	}
	
	//Permet de retirer une carte de la main apres l'avoir pos�e
	public void retirerCarte (){
		
	}
	
}
