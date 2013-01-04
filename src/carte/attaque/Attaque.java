package carte.attaque;

import tasDeCartes.Carte;
import joueurs.Joueur;


public abstract class Attaque extends Carte {
	
	
	//constructeur
	public Attaque (){
		
		
	}
	
	public boolean isJouable(Joueur joueurActuel, Joueur adversaire) { 
		if(adversaire == null) {
			return false;
		}
		return this.isJouableContre(adversaire);
	}
	
	public boolean isJouableContre(Joueur adversaire) {
		if(this instanceof Crevaison || this instanceof FeuRouge || this instanceof Accident|| this instanceof PanneEssence ) {
			//Si l'instance est de type Crevaison, FeuROuge, Accident ou PanneEssence
			
			if(adversaire.getJeuSurTable().getPileBataille().isEmpty() && adversaire.getJeuSurTable().isDemarrer()) {		
			//Si la pile de bataille de l'adversaire visé est vide et que cet adversaire a déjà démarrer
			// alors l'attaque est jouable et on retourne true.
				return true;
			} 
		} else if(this instanceof LimiteVitesse) {
			//Si c'est une limite de vitesse il suffit que la pile de bataille soit vide pour que la limite de vitesse soit jouable.
			if(adversaire.getJeuSurTable().getPileVitesse().isEmpty()) {		
				return true;
			}
			
		}
		return false;
	}
	
	
	public void jouer(Joueur joueur, Joueur adversaire){
		
		adversaire.getJeuSurTable().ajouterCarteBataille(this);
		joueur.getJeuEnMain().retirerCarte(this);
		
	}
	
	
}
