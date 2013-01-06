package vue;

import java.util.LinkedList;

import jeu.Menu;

import joueurs.Joueur;
import tasDeCartes.Carte;
import carte.attaque.*;
import carte.bottes.*;
import carte.etape.*;
import carte.parade.*;

public class Controleur {
	
	public Controleur(){
		
	}
	
	/**
	 * 
	 * 
	 */
	public boolean isPosableSurAttaque(Joueur joueurActuel, Joueur adversaire,  Carte carte) {
		if(carte instanceof Attaque && joueurActuel != adversaire) {
			if(carte.isJouable(joueurActuel, adversaire )) {
				return true;
			}
		} else if (carte instanceof Parade && joueurActuel == adversaire && !(carte instanceof FinLimiteVitesse) ) {
			//Si la carte est une parade et que l'humain s'est choisi lui même.
			if (carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		
		return false;
	}
	

	
	public boolean isPosableSurEtape(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		if (carte instanceof Etape && joueurChoisi == joueurActuel) {
			if(carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isPosableSurLimiteVitesse(Joueur joueurActuel,Joueur joueurChoisi,  Carte carte) {
		if(carte instanceof LimiteVitesse && joueurActuel != joueurChoisi) {
			if(carte.isJouable(joueurActuel, joueurChoisi )) {
				return true;
			}
		} else if (carte instanceof FinLimiteVitesse && joueurActuel == joueurChoisi) {
			//Si la carte est une parade et que l'humain s'est choisi lui même.
			if (carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		
		return false;
	}
	


	public boolean isPosableSurBotte(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		if(carte instanceof Botte && joueurActuel == joueurChoisi) {
			if(carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		return false;
	}
	
	public void jouer(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		carte.jouer(joueurActuel, joueurChoisi);
	}
	
	public LinkedList<Carte> getMain(Joueur joueur) {
		return joueur.getJeuEnMain().getMain();
	}
	
	public LinkedList<Joueur> getJoueurs() {
		return Menu.getInstance().getJoueurs();
	}
	
	public String getNom(Joueur joueur) {
		return joueur.getNom();
	}
	

	

}
