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
/**
 * Controleur faisant le lien entre la vue et le modele
 * @author Damien
 *
 */
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
	 * Permet de savoir si une carte est posable sur la pileBataille
	 * @param joueurActuel
	 * @param adversaire
	 * @param carte
	 * 
	 */
	public boolean isPosableSurAttaque(Joueur joueurActuel, Joueur adversaire,  Carte carte) {
		if(carte instanceof Attaque && joueurActuel != adversaire) {
			if(carte.isJouable(joueurActuel, adversaire )) {
				return true;
			}
			/**
			 * Si la carte est une parade et que l'humain s'est choisi lui même.
			 */
		} else if (carte instanceof Parade && joueurActuel == adversaire && !(carte instanceof FinLimiteVitesse) ) {
			
			if (carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Permet de savoir si une carte est posable sur la pile Vitesse
	 * @param joueurActuel
	 * @param joueurChoisi
	 * @param carte
	 * 
	 */
	
	public boolean isPosableSurEtape(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		if (carte instanceof Etape && joueurChoisi == joueurActuel) {
			if(carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Permet de savoir si une carte est posable sur la pile Limite Vitesse
	 * @param joueurActuel
	 * @param joueurChoisi
	 * @param carte
	 * 
	 */
	public boolean isPosableSurLimiteVitesse(Joueur joueurActuel,Joueur joueurChoisi,  Carte carte) {
		if(carte instanceof LimiteVitesse && joueurActuel != joueurChoisi) {
			if(carte.isJouable(joueurActuel, joueurChoisi )) {
				return true;
			}
			/**
			 * Si la carte est une parade et que l'humain s'est choisi lui même.
			 */
		} else if (carte instanceof FinLimiteVitesse && joueurActuel == joueurChoisi) {
			
			if (carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Determine si la defausse est vide
	 * @return boolean
	 */
	public boolean isDefausseEmpty() {
		return Defausse.getInstance().isEmpty();
	}
	
	/**
	 * Determine si la carte est posable sur la pile Botte
	 * @param joueurActuel
	 * @param joueurChoisi
	 * @param carte
	 * 
	 */
	public boolean isPosableSurBotte(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		if(carte instanceof Botte && joueurActuel == joueurChoisi) {
			if(carte.isJouable(joueurActuel, null)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Determine si le joueur a pioché
	 * @param joueur
	 * 
	 */
	public boolean hasPioche(Joueur joueur) {
		if(joueur.getJeuEnMain().getMain().size() == 5) {
			return true;
		}
		return false;
	}
	/**
	 * Appelle les methodes jouer du modele
	 * @param joueurActuel
	 * @param joueurChoisi
	 * @param carte
	 */
	public void jouer(Joueur joueurActuel, Joueur joueurChoisi, Carte carte) {
		carte.jouer(joueurActuel, joueurChoisi);
	}
	
	/**
	 * Appelle les methodes canCoupFourre du modele
	 * @param joueurActuel
	 * @param joueurChoisi
	 * 
	 */
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
	
	/**
	 * Donne le nom de la carte visible de la defausse
	 * @return String
	 */
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
	
	/**
	 * Donne le nom de la carte de la pile bataille
	 * @return String
	 */
	public String getCarteBataille(JeuSurTable jeu) {
		if(jeu.getPileBataille().isEmpty() == false) {
			return jeu.getPileBataille().get(0).toString();
		} else {
			
			return "vide";
		}
	}
	
	/**
	 * Donne le nom de la carte de la pile Limite vitesse
	 * @return String
	 */
	public String getCarteLimiteVitesse(JeuSurTable jeu) {
		if(jeu.getPileVitesse().isEmpty() == false) {
			return jeu.getPileVitesse().get(0).toString();
		} else {

			return "vide";
		}
	}
	
	/**
	 * Donne le nom de la carte de la pile botte
	 * @return String
	 */
	public String getCarteBotte(JeuSurTable jeu) {
		if(jeu.getPileBotte().isEmpty() == false) {
			return jeu.getPileBotte().toString();
		} else {

			return "vide";
		}
	}
	
	/**
	 * Donne le nom de la carte de la pile feu vert initial
	 * @return String
	 */
	public String getEtatFeuVertInitial(JeuSurTable jeu){
		if(jeu.getPileFeuVertInitial().isEmpty()==false){
			return "Feu vert";
		} else{

			return "vide";
		}
	}

	public int getKm(JeuSurTable arg0) {
		
		return arg0.getNbKmParcouruTotal();
	}
	
	/**
	 * Enclenche le coup fourre
	 * @param joueur
	 * @param botte
	 */
	public void jouerCoupFourre(Joueur joueur, Botte botte) {
		botte.coupFourre(joueur);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() - 1);
		
	}
	/**
	 * Permet au joueur suivant de jouer
	 */
	public void nextJoueur() {
		PartieDeJeu.getInstance().setNumeroJoueurActuel(this.getJoueurActuel().getNumPassage() - 1);
		
	}
	

}
