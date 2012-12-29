package controleur;

import java.util.Iterator;

import modele.*;


public class Vitesse implements Strategy {

	@Override
	public Carte choixCarte(Joueur robot, boolean aDefausser) {
		
		if(aDefausser == true) {
			//Ici le robot ne peut pas jouer, il doit defausser.
			//il va chercher une carte qui n'est pas de type Etape à defausser.
			for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
				Carte carte = it.next();
				if( !(carte instanceof Etape)) {
					//si une des cartes de la main n'est pas une etape, le robot prefere s'en defausser.
					return carte;
				}
			}
			//si toutes les cartes sont de type Etape, on defausse arbitrairmeent la première carte.
			return robot.getJeuEnMain().getMain().getFirst(); //amelioration : retourner la moins bonne etape.
			
		} else { //le robot peut alors jouer une carte
			
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
					//On teste toutes les cartes du jeu du robot
					Carte carte = it.next();
					
					if( (carte instanceof Etape)) {
						//Si la carte est de type etape
						
						if(carte.isJouable(robot, null)) {
							return carte;
						}
					} else if(carte instanceof FeuVert) {
						//Si le robot n'a pas démarré et que la carte est un feu vert, il decide de la jouer.
						if(robot.getJeuSurTable().isDemarrer() == false) {
							return carte;
						}
					} 
				}
				
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
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
					}
				}
				
				for(Iterator<Carte> it = robot.getJeuEnMain().getMain().iterator() ; it.hasNext(); ) {
					//Si aucune des boucles précédente n'a mené à la fin de la methode
					//on cherche toute carte jouable et le robot la jouera.
					Carte carte = it.next();
					if(carte.isJouable(robot, null)) { //null comme valeur a adversaire car les carte Attaque sont obligatoirement
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

	@Override
	public Joueur choixCible(Attaque carte) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
