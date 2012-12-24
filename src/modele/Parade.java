package modele;

import java.util.*;

import controleur.*;
import modele.*;

public abstract class Parade extends Carte {
	

	
	//constructeur
	public Parade(){
		
	}
	
	public abstract boolean isCompatible(Attaque attaque);
	
	public boolean isJouable(JeuSurTable notreJeu) {
		if (!notreJeu.isDemarrer() && this instanceof FeuVert) {			
			return true;
		}
		if(this.isCompatible(notreJeu.getPileVitesse().get(0))) {
			return true;
		}
		if (this.isCompatible(notreJeu.getPileBataille().get(0))) {
			return true;
		} else {
			return false; 
		}
			
		
	}
	
	public void jouer(Joueur joueur) {
		
		joueur.getJeuEnMain().retirerCarte(this);
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0),  this);
		
	}
}
