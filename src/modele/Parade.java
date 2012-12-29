package modele;

import java.util.*;

import controleur.*;
import modele.*;

public abstract class Parade extends Carte {
	
	//constructeur
	public Parade(){
		
	}
	
	public abstract boolean isCompatible(Attaque attaque);
	
	public boolean isJouable(Joueur joueur, Joueur inutile) {
		if(joueur.getJeuSurTable().getPileVitesse().isEmpty() && joueur.getJeuSurTable().getPileBataille().isEmpty()) {
			return false;
		}
		if (!joueur.getJeuSurTable().isDemarrer() && this instanceof FeuVert) {			
			return true;
		}
		if(joueur.getJeuSurTable().getPileVitesse().isEmpty() == false) {
			
			if(this.isCompatible( joueur.getJeuSurTable().getPileVitesse().get(0) ) ) {
				return true;
			}
		}
		if(joueur.getJeuSurTable().getPileBataille().isEmpty() == false) {
			if (this.isCompatible(joueur.getJeuSurTable().getPileBataille().get(0))) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public void jouer(Joueur joueur, Joueur inutile) {
		
		joueur.getJeuEnMain().retirerCarte(this);
		Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0),  this);
		
	}
}
