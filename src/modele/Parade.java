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
		
		if(this instanceof FeuVert && joueur.getJeuSurTable().isDemarrer() == false) {
			//si la carte est un feu vert et que le joueur n'a pas demarré alors la carte est jouable.
			return true;
		}
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
		joueur.getJeuEnMain().retirerCarte(this); // on retire la carte de la main
		
		if(this instanceof FeuVert && joueur.getJeuSurTable().isDemarrer() == false) {
			joueur.getJeuSurTable().getPileFeuVertInitial().add((FeuVert) this);
		} else {
			Defausse.getInstance().ajouter2Carte(joueur.getJeuSurTable().getPileBataille().remove(0),  this);
		}
	}
}
