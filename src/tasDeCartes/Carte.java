package tasDeCartes;

import joueurs.Joueur;

public abstract class Carte {
	/**
	 * Réalise l'effet de la carte.
	 * On ne tiendra pas compte du deuxième paramètre si l'effet s'applique à son propre jeu.
	 * @param joueurActuel
	 * @param adversaire
	 */
	public abstract void jouer(Joueur joueurActuel, Joueur adversaire);
	/**
	 * Fonctionne pour toutes les cartes.
	 * Pour les carte de type Attaque, cette méthode va tester la carte contre tous les joueurs adverses. (Ceci n'est utile que dans le cas des robots)
	 * 
	 * @param joueurDontCestLeTour
	 * @return boolean
	 */
	public abstract boolean isJouable(Joueur joueurDontCestLeTour, Joueur adversaire);
	//Fonctionne pour tous type de carte

}
