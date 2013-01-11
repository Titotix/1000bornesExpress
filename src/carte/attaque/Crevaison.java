package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.Increvable;
/**
 * 
 * Carte de type Attaque Crevaison
 * On y trouve la correspondance a Increvable et 
 * la methode permettant de jouer l'instance de Crevaison.
 * @author Damien
 *
 */
public class Crevaison extends Attaque {

	public Crevaison() {
		
		
	}
	/**
	 * Retourne "crevaison"
	 */
	public String toString() {
		return "Crevaison";
	}
	
	/**
	 * Indique la compatiblité entre cette carte et la botte indiqué.
	 * Retourne vrai si botte est Increvable.
	 * @param botte
	 * @return boolean
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof Increvable) {
			return true;
		} else { return false; }
	}
	
	/**
	 * Permet de poser la carte sur le tas
	 * @param joueur
	 * @param adversaire
	 */
	@Override
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() );

		
	}

}
