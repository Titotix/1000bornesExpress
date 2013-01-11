package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.Botte;
import carte.bottes.Prioritaire;
/**
 * 
 * Carte de type Attaque Limite de vitesse
 * On y trouve la correspondance avec sa botte et 
 * la methode permettant de la jouer.
 * 
 * 
 * 
 *
 */
public class LimiteVitesse extends Attaque {
	
	
	private static int borneMaxJouable=50;

	
	public LimiteVitesse() {
	
		
	}
	
	/**
	 * Retourne "Limite de Vitesse"
	 */
	public String toString() {
		return "Limite de Vitesse";
	}

	/**
	 * Indique la compatibilité entre cette carte et la botte indiqué.
	 * @param botte
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof Prioritaire) {
			return true;
		} else { return false; }
	}
	/**
	 * Permet de poser la carte sur le jeu adverse, de retirer la carte de la main du joueur et indique à l'instance de PartieDeJeu le joueur suivant.
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
	 * Valeur max des bornes jouables lorsque l'on es tlimité par Limite de vitesse.
	 * @return borneMaxJouable
	 */
	public static int getBorneMaxJouable() {
		return borneMaxJouable;
	}

	/**
	 * Permet de definir la valeur de bornes max jouable lorsque l'on est limité par la limite de vitesse.
	 * @param borneMaxJouable
	 */
	public static void setBorneMaxJouable(int borneMaxJouable) {
		LimiteVitesse.borneMaxJouable = borneMaxJouable;
	}

}
