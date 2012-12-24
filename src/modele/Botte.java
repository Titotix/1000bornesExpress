package modele;
import java.util.*;

import controleur.*;


public class Botte extends Carte  {
	
	protected int Kilometres;
	

	//constructeur
	public Botte() {
	
	}
	
	public void jouer(JeuSurTable jeu) { //TODO
		jeu.ajouterCarteBotte(this);
		jeu.setNbKmParcouru(jeu.getNbKmParcouru() + 100); //jouer une botte augmente de 100 le nb de Km parcouru
		if(jeu.getPileBataille().contains(o) ==)
	}
	
	//Augmenter les km lors de la pose d'une botte
	public void augmenterKmParcourus(JeuSurTable jeu){
		Kilometres = jeu.getNbKmParcouru();
		jeu.setNbKmParcouru(Kilometres + 100);
		//TODO
	}
	
	
	
	public void coupFourre(){
		
		
		
	}


	public boolean isJouable() {
		return true;
	}


	
}
