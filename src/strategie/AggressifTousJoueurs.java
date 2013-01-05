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

public class AggressifTousJoueurs implements Strategy {


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
						//Si la carte est de tyoe Attaque
						Menu menu = Menu.getInstance();
						for(Iterator<Joueur> it2 = menu.getJoueurs().iterator() ; it2.hasNext(); ) {
							//Alors on teste si cette carte est jouable contre un des joueurs adverses.
							Joueur adversaire = it2.next();
							if(adversaire != robot) {
								if(carte.isJouable(robot, adversaire)) {
									//Si la carte est jouable on retourne cette carte, c'est la carte choisie par la strategie.
									return carte;
								}
							}					
						}		
					} else if(carte instanceof FeuVert) {
						//Si la carte est un feu vert et que le robot n'a pas démarré, alors il joue le feu vert
						if(!robot.getJeuSurTable().isDemarrer()) {
							return carte;
						}
					}
				}
				
				//Si on arrive ici, c'est qu'aucune carte du jeu du robot n'est une attaque ou qu'aucune de ces cartes Attaque n'est jouable
				if(robot.getJeuSurTable().isDemarrer() && robot.getJeuSurTable().getPileBataille().isEmpty()) {
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
				
			
			
		}
		
			
		return null;
	}
	
	/**
	 * Le robot ne pioche dans la defausse que si la carte visible est une attaque.
	 * 
	 * @return TasDeCarte dans lequel le robot veut piocher.
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
	 * Teste pour tous les joueurs adverses si la carte attaque est jouable
	 * @param Attaque
	 * @return Joueur (null si aucun joueur ne peut recevoir l'attaque)
	 */
	public Joueur choixCible(Robot robot, Attaque carte) {
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
	
	public String toString() {
		return "AggressifTousJoueur";
	}

}
