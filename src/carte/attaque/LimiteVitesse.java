package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.Botte;
import carte.bottes.Prioritaire;
/**
 * 
 * Carte de type Attaque Limite de vitesse
 * On y trouve la correspondance avec Prioritaire et 
 * la methode permettant de la poser sur le bon tas,
 * ainsi que la variante permettant de definir la borne max jouable en etant limité
 * 
 * @author Damien
 *
 */
public class LimiteVitesse extends Attaque {
	
	
	private static int borneMaxJouable=50;

	
	public LimiteVitesse() {
	
		
	}
	
	/**
	 * affiche "LimiteVitesse"
	 */
	public String toString() {
		return "LimiteVitesse";
	}

	/**
	 * Indique la compatibilité entre cette carte et la botte Prioritaire
	 * @param botte
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof Prioritaire) {
			return true;
		} else { return false; }
	}
	/**
	 * Permet de poser la carte sur le bon tas 
	 * @param joueur
	 * @param adversaire
	 */
	@Override
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteVitesse(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() );

		
	}
	/**
	 * Valeur max des bornes jouables sous limite
	 * @return borneMaxJouable
	 */
	public static int getBorneMaxJouable() {
		return borneMaxJouable;
	}

	/**
	 * Permet de definir la valeur max des bornes jouables sous limite
	 * @param borneMaxJouable
	 */
	public static void setBorneMaxJouable(int borneMaxJouable) {
		LimiteVitesse.borneMaxJouable = borneMaxJouable;
	}

}
