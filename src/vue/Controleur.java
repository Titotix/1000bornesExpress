package vue;

import java.util.Iterator;
import java.util.LinkedList;

import jeu.Menu;
import jeu.PartieDeJeu;

import joueurs.JeuSurTable;
import joueurs.Joueur;
import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import carte.attaque.*;
import carte.bottes.*;
import carte.etape.*;
import carte.parade.*;

public class Controleur {
	
	private static Controleur controleur = null;
	
	private Controleur(){
		
	}
	
	public static Controleur getInstance() {
		if(controleur == null) {
			controleur = new Controleur();
		}
		return controleur;
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
		
		return false;//TODO et afficher cette carte ne peut pas etre pos�e ici
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
	

	public boolean isDefausseEmpty() {
		return Defausse.getInstance().isEmpty();
	}

	public boolean isPosableSurBotte(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		if(carte instanceof Botte && joueurActuel == joueurChoisi) {
			if(carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPioche(Joueur joueur) {
		if(joueur.getJeuEnMain().getMain().size() == 5) {
			return true;
		}
		return false;
	}
	
	public void jouer(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		carte.jouer(joueurActuel, joueurChoisi);
	}
	
	public Botte canCoupFourre(Joueur joueurActuel, Joueur joueurChoisi) {
		return joueurChoisi.canCoupFourre();
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
	
	public String getCarteVisibleDefausse() {
		if(Defausse.getInstance().getPileCarte().isEmpty() == false) {
			return Defausse.getInstance().getPileCarte().getFirst().toString();
		} else {
			return "Aucune carte dans la défausse.";
		}
	}

	public int getNumeroJoueurActuel() {
		return PartieDeJeu.getInstance().getNumeroJoueurActuel();
	}
	
	public Joueur getJoueurActuel() {
		
		Joueur joueurActuel = null;
		for(Iterator<Joueur> it = this.getJoueurs().iterator() ; it.hasNext() ;) {
			Joueur i = it.next();
			if(i.getNumPassage() -1 == this.getNumeroJoueurActuel()) {
				joueurActuel = i;
			}
		}
		
		return joueurActuel;

	}

	public boolean isPartieFinie() {
		
		return PartieDeJeu.getInstance().isTerminee();
	}

	public String getCarteBataille(JeuSurTable jeu) {
		if(jeu.getPileBataille().isEmpty() == false) {
			return jeu.getPileBataille().get(0).toString();
		} else {
			return "vide";
		}
	}
	
	public String getCarteLimiteVitesse(JeuSurTable jeu) {
		if(jeu.getPileVitesse().isEmpty() == false) {
			return jeu.getPileVitesse().get(0).toString();
		} else {
			return "vide";
		}
	}

	public int getKm(JeuSurTable arg0) {
		
		return arg0.getNbKmParcouruTotal();
	}
	

}
