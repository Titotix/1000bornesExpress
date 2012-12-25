package controleur;

public class PartieDeJeu {

	private Joueur[] joueur;
	
	private boolean termine;
	private int nbRobot;
	private int nbHumain;
	
	public PartieDeJeu() {
		this.termine=false;
		Menu menu = Menu.getInstance();
		this.nbRobot = menu.getNbRobot();
		this.nbHumain = menu.getNbHumain();
		int i;
		joueur = new Joueur[menu.getNbRobot() + menu.getNbHumain()];
		
		//on va associer ici au tableau joueur[] les robots et les humains dans leur ordre de passage.
		// joueur[0] sera le premier du tour, le joueur[2] sera le 3eme à jouer...
		//On suppose ici que l'ordre de passage est tout d'abord les humains puis les robots. (ainsi défini dans les attribut 
		// numPassage de Robot et Humain)
		for(i=0; i < this.nbHumain; i++) {			
			joueur[i] = menu.getHumain()[i];
		}		
		for(int j=0 ;j < this.nbRobot; j++) {			
			joueur[i] = menu.getRobot()[j];
			i++;
		}
	}
	
	
	public void jouerPartie() {
		Menu menu = Menu.getInstance();
		int i=0;
		
		//Tant que la partie n'est pas terminée, le joueur[i] joue.
		//On incremente i jusqu'au nombre total de joueur, on le reinitialise alors a 0.		
		//systeme pas viable ac le coup fourre //TODO
		while(this.termine==false) {
			joueur[i].jouer();
			i++;
			if(i == menu.getNbRobot() + menu.getNbHumain()) {
				i=0;
			
			}
		}
	}
}
