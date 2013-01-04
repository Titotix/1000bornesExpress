package strategie;

import java.util.Iterator;

import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import tasDeCartes.Talon;
import tasDeCartes.TasDeCarte;

import jeu.Menu;

import joueurs.Joueur;
import joueurs.Robot;



import carte.attaque.Attaque;
import carte.etape.Etape;
import carte.parade.FeuVert;

public class AggressifMeilleurJoueur implements Strategy {

	public Carte choixCarte(Robot robot, boolean aDefausser) {
		
		if(aDefausser == true) {
			//Ici le robot ne peut pas jouer, il doit defausser.
			//il va cherche rune carte qui n'est pas de type Attraque à defausser.
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				Carte carte = it.next();
				if( !(carte instanceof Attaque)) {
					//si une des cartes de la main n'est pas une attaque, elle prefere s'en defausser.
					return carte;
				}
			}
			//si toutes les cartes sont de type Attaque, on defausse arbitrairmeent la première carte.
			return robot.getJeuEnMain().getMain().getFirst();
			
		} else {
			//Si le robot peut jouer
			
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				//On teste toutes les cartes du jeu du robot
				Carte carte = it.next();
				if( (carte instanceof Attaque)) {
					//Si la carte est de type Attaque
					
					if(((Attaque) carte).isJouableContre(this.meilleurJoueur(robot))) {
						//Si la carte Attaque est jouable contre le meilleur joueur, on retourne cette carte.
						return carte;
					}
				}
			}
			//Si aucune carte Attaque n'est jouable contre le meilleur joueur, on tente d'attaquer les autres joueurs.
			
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				//On teste toutes les cartes du jeu du robot
				Carte carte = it.next();
				if( (carte instanceof Attaque)) {
					//Si la carte est de type Attaque
					
					
					if(this.choixCibleSecondaire(robot,(Attaque) carte) != null) {
						//Si la carte est jouable contre un joueur alors on la retourne
						return carte;
					}
					
				} else if(carte instanceof FeuVert) {
					//Si la carte est un feu vert et que le robot n'a pas démarré, alors il joue le feu vert
					if(!robot.getJeuSurTable().isDemarrer()) {
						return carte;
					}
				}
			}
			
			//Si on arrive ici, c'est qu'aucune carte du jeu du robot n'est une attaque ou qu'aucune de ces cartes Attaque n'est jouable
			if(robot.getJeuSurTable().isDemarrer() && robot.getJeuSurTable().getPileBataille() == null) {
				//Si le robot a démarré et que la pile bataille est vide
				//Le robot va tenter de chercher une Etape a jouer.
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
					//On teste toutes les cartes du jeu du robot
					Carte carte = it.next();
					if( (carte instanceof Etape)) {
						if(carte.isJouable(robot, null)) {
							//Si la carte est jouable on retourne cette carte, c'est la carte choisie par la strategie.
							return carte;
						}
					}
				} //end iteration Carte
			}
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				//Si aucune des boucles précédente n'a mené à la fin de la methode
				//on cherche toute carte jouable et le robot la jouera.
				Carte carte = it.next();
				if(carte.isJouable(robot, null)) { //null comme valeur a adversaire car les carte Attaque sont obligatoirement
					// non jouables.
					return carte;
				}
			}
			
		} //Fin else
		return null;
	}

	/**
	 * Le robot ne pioche dans la defausse que si la carte visible est une attaque.
	 * 
	 * @return TasDeCarte dans lequel le robot veut piocher.
	 */
	
	public Joueur meilleurJoueur(Robot robot) {
		Menu menu = Menu.getInstance();
		Joueur meilleurJoueur = null;
		
		for(Iterator<Joueur> it = menu.getJoueurs().iterator() ; it.hasNext() ;) {
			Joueur joueur = it.next();
			if (robot != joueur) {
				if(meilleurJoueur == null) {
					meilleurJoueur = joueur;
				} else {
					if(joueur.getJeuSurTable().getNbKmParcouru() > meilleurJoueur.getJeuSurTable().getNbKmParcouru() ) {
						meilleurJoueur = joueur;
					}
				}
			}
		}
		return meilleurJoueur;
	}
	/**
	 * 
	 * 
	 * @return TasDeCarte dans lequel le robot a decider de piocher
	 */
	public TasDeCarte choixPioche() {
		
		Defausse defausse = Defausse.getInstance();
		if(!defausse.getPileCarte().isEmpty()) {
			if(defausse.getPileCarte().getFirst() instanceof Attaque) {
				return defausse;
			}
		}
		Talon talon = Talon.getInstance();
		return talon;
	}

	/**
	 * Retournera la cible que le robot choisira.
	 * Cette cible sera de préférence le meilleur joueur (celui ayant parcouru le plus de bornes)
	 * Si un des joueur de la partie est attaquable avec la carte Attaque mise en parametre, alors cette methode
	 * renverra forcement un joueur.
	 *
	 * @param Attaque
	 * @return Joueur (null si aucun joueur ne peut recevoir l'attaque)
	 */
	public Joueur choixCible(Robot robot, Attaque carte) {
		Joueur ciblePrincipale = this.choixCiblePrincipale(robot, carte);
		if(ciblePrincipale != null) {
			return ciblePrincipale;
		} else {
			return this.choixCibleSecondaire(robot, carte);
		}
	}
	
	/**
	 * Teste si l'attaque est jouable contre le meilleur joueur, retourne null si ce n'est pas le cas.
	 * @param robot (celui qui est en train de jouer)
	 * @param carte
	 * @return Joueur (null si carte n'est pas jouable sur le meilleur joueur)
	 */
	public Joueur choixCiblePrincipale(Robot robot, Attaque carte) {
		Joueur meilleurJoueur = this.meilleurJoueur(robot);
		if(carte.isJouable(robot, meilleurJoueur)) {
			return meilleurJoueur;
		} else {
			return null;
		}
	}
	/**
	 * Teste la carte attaque sur tous les joueurs. Si aucun n'est attaquable, retourne null.
	 * @param robot dont c'est le tour
	 * @param carte attaque
	 * @return Joueur (null si carte n'est jouable contre personne)
	 */
	public Joueur choixCibleSecondaire(Joueur robot, Attaque carte) {
		Menu menu = Menu.getInstance();
		
		for(Iterator<Joueur> it2 = menu.getJoueurs().iterator() ; it2.hasNext(); ) {
		
			Joueur adversaire = it2.next();
			if(adversaire != robot) {
				if(carte.isJouable(robot, adversaire)) {
					//Si la carte est jouable on retourne l'adversaire sur lequel elle est jouable.
					return adversaire;
				}
			}					
		}
		return null;
	}

}
