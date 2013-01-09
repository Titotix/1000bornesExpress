package carte.attaque;

import jeu.PartieDeJeu;
import joueurs.Joueur;
import carte.bottes.AsDuVolant;
import carte.bottes.Botte;
import carte.bottes.CiterneEssence;
/**
 * 
 * Carte de type Attaque Panne d'essence
 * On y trouve la correspondance avec Citerne d'essence et 
 * la methode permettant de la poser sur le bon tas
 * @author Damien
 *
 */
public class PanneEssence extends Attaque {

	public PanneEssence() {
		
		
	}
	/**
	 * affiche "panne essence"
	 */
	public String toString() {
		return "Panne Essence";
	}
	
	/**
	 * Indique la compatibilité entre cette carte et la botte Citerne d'Essence
	 * @param botte
	 */
	public boolean isCompatible(Botte botte) {
		if(botte instanceof CiterneEssence) {
			return true;
		} else { return false; }
	}
	
	@Override
	/**
	 * Permet de poser la carte au bon endroit
	 * @param joueur
	 * @param adversaire
	 */
	public void jouer(Joueur joueur, Joueur adversaire) {
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);		
		joueur.getJeuEnMain().retirerCarte(this);
		PartieDeJeu.getInstance().setNumeroJoueurActuel(joueur.getNumPassage() ); 

		
	}

}
