package modele;

import java.util.*;

import controleur.*;
import modele.*;

public abstract class Attaque extends Carte {
	
	
	//constructeur
	public Attaque (){
		
		
	}
	
	public boolean isJouable(Joueur adversaire) {
		if(this instanceof Crevaison || this instanceof FeuRouge || this instanceof Accident|| this instanceof PanneEssence ) {
			if(adversaire.getJeuSurTable().getPileBataille().isEmpty() && adversaire.getJeuSurTable().isDemarrer()) {		
				return true;
			} 
		}
		if(this instanceof LimiteVitesse) {
			if(adversaire.getJeuSurTable().getPileVitesse().isEmpty()) {		
				return true;
			}
			
		} 
		return false;
	}
	
	
	public void jouer(Joueur adversaire, JeuEnMain notreJeu, Attaque carte){
		
		adversaire.getJeuSurTable().ajouterCarteBataille(carte);
		notreJeu.retirerCarte(carte);
		
	}
	
	
	//Appelle la m�thode setEtatBataille du jeu sur table adverse
	public void changeEtatBataille (){
		
	}

	
	
	
}
