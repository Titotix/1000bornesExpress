package strategie;

import java.util.Iterator;

import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import tasDeCartes.Talon;
import tasDeCartes.TasDeCarte;

import jeu.Menu;

import joueurs.Joueur;
import joueurs.Robot;


import carte.bottes.*;
import carte.attaque.Attaque;
import carte.etape.Etape;
import carte.parade.FeuVert;
import carte.parade.*;
public class Vitesse implements Strategy {

	/**
	 * Choisit la carte que le robot va jouer.
	 * Par ordre de priorité le robot choisira :
	 * 	- une feu vert : uniquement si le robot n'a pas démarrer
	 * 	- une etape : la meilleure possible
	 * 	- une attaque : contre n'importe quel joueur
	 * 	- une parade : par rapport a la pile bataille
	 * 	- une parade : par rapport à la pile vitesse.
	 * 	- une botte
	 * 
	 * Le test des bottes à la fin permet de limiter au robot de jouer les bottes simplement, pour qu'ils les jouent plus en coup fourré.
	 * 
	 * @param robot qui est en train de jouer
	 * @param aDefausser : est ce que la carte que la stratégie choisit est à defausser ou non.
	 */
	public Carte choixCarte(Robot robot, boolean aDefausser) {
		
		if(aDefausser == true) {
			//Ici le robot ne peut pas jouer, il doit defausser.
			//il va chercher une carte qui n'est pas de type Etape à defausser.
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				Carte carte = it.next();
				if(  (!(carte instanceof Etape))  &&  (!(carte instanceof Botte))   ) {
					//si une des cartes de la main n'est pas une etape, le robot prefere s'en defausser.
					return carte;
				}
			}
			//si toutes les cartes sont de type Etape, on defausse arbitrairmeent la première carte.
			return robot.getJeuEnMain().getMain().getFirst(); //amelioration : retourner la moins bonne etape.
			
		} else { //le robot peut alors jouer une carte

			
			Etape carteAJouer=null; 
			//Avec cette variable on va chercher a placer l'etape ac la plus forte valeur.
		
			
			/*1. On tente de placer une carte Etape */
			
			if(robot.getJeuSurTable().isDemarrer() && robot.getJeuSurTable().getPileBataille().isEmpty()) {
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
					//On teste toutes les cartes du jeu du robot
					Carte carte = it.next();				
					if(carte instanceof Etape) {
					//Si la carte est de type etape					
						if(carte.isJouable(robot, null)) {
							//Si la carte etape est jouable on cherche alors la plus forte carte etape.
							if(carteAJouer == null) {
								carteAJouer = (Etape) carte;
								
							} else if(((Etape) carte).getNbKm() > carteAJouer.getNbKm() )
							//Si la carte Etape sur laquel on incremente a un nbKm plus grand que celle deja stocker
							//Alors on remplace la carteAJouer précédemment stocké par la meilleur que nous venons de trouver.
								carteAJouer = (Etape) carte;
						}
						
					} else if(carte instanceof FeuVert) {
						//Si le robot n'a pas démarré et que la carte est un feu vert, il decide de la jouer.
						if(robot.getJeuSurTable().isDemarrer() == false) {
							return carte;
						}
					} 
				}
				//A la fin de l'incrementation on retourne carteAJouer si il lui a été attribué une carte.
				if(carteAJouer != null) {
					return carteAJouer;
				}
			}
			
			/* 2. On tente de jouer une carte Attaque */
			
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				Carte carte = it.next();
				if( (carte instanceof Attaque)) {
					//Si la carte est de type Attaque
					if(this.choixCible(robot,(Attaque) carte) != null) {
						//Si la valeur retourne par choixCible n'est pas null alors on peut placer l'attaque sur un joueur.
						return carte;
					}
				}
			}
			
			/* 3. On tente de jouer une carte parade */
				//On tente les parades du tas bataille
			if(robot.getJeuSurTable().getPileBataille().isEmpty() == false) { 
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
					Carte carte = it.next();
					if(carte instanceof Parade) {
						if(carte.isJouable(robot, null)) {
						
							return carte;
						}
					}
				}
			}
				// On tente la fin de limite de vitesse.
			if(robot.getJeuSurTable().getPileVitesse().isEmpty() == false) { 
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
					Carte carte = it.next();
					if(carte instanceof FinLimiteVitesse) {
						if(carte.isJouable(robot, null)) {
						
							return carte;
						}
					}
				}
			}
			
			
			/* 4. On tente de jouer toutes les cartes */
			// Il ne reste a tester que les bottes.
			
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				//Si aucune des boucles précédente n'a mené à la fin de la methode
				//on cherche toute carte jouable et le robot la jouera.
				Carte carte = it.next();
				if(carte.isJouable(robot, null)) { 
					//null comme valeur a adversaire car les carte Attaque sont obligatoirement
					// non jouables à cet instant.
					return carte;
				}
			}
		
		}
		
		return null;
		
	}

	/**
	 * Le robot ne pioche dans la défausse que si la carte visible  est une carte Etape.
	 * 
	 * @return Tas de carte (talon ou defausse) danbs lequel le robot va vouloir piocher
	 */
	public TasDeCarte choixPioche() {
		
		Defausse defausse = Defausse.getInstance();
		if(!defausse.getPileCarte().isEmpty()) {
			if(defausse.getPileCarte().getFirst() instanceof Etape) {
				return defausse;
			}
		}
		Talon talon = Talon.getInstance();
		return talon;
	}

	/**
	 * Teste pour tous le sjoueurs adverses si la carte attaque est jouable
	 * @param Attaque
	 * @param robot (celui qui est en train de jouer)
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
		return "Vitesse";
	}
}
