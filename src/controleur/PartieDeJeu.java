package controleur;

import java.util.*;
import vue.*;
public class PartieDeJeu {

	private LinkedList<Joueur> joueur;
	
	private boolean termine;
	private int nbRobot;
	private int nbHumain;
	
	public PartieDeJeu() {
		
		this.termine=false;
		Menu menu = Menu.getInstance();
		this.nbRobot = menu.getNbRobot();
		this.nbHumain = menu.getNbHumain();
		joueur = new LinkedList<Joueur>();
		
		//On concatène ici les deux LinkedList (d'Humain et de Robot) dans la LinkedList de Joueur.
		joueur.addAll(menu.getHumain());
		joueur.addAll(menu.getRobot());
		
	}
	
	
	public void jouerPartie() {
		Menu menu = Menu.getInstance();
		int i=0;
		int nbTour=0;
		CmdLineInterface cmd = new CmdLineInterface();
		//Tant que la partie n'est pas terminée, le joueur[i] joue.
		//On incremente i jusqu'au nombre total de joueur, on le reinitialise alors a 0.		
		//systeme pas viable ac le coup fourre //TODO
		while(this.termine==false) {
			System.out.println("jeu de "+joueur.get(i).getNom()+"\n");
			cmd.afficherJoueur(joueur.get(i));
			joueur.get(i).jouer();
			nbTour++;
			System.out.println("nb de tour "+nbTour);
			i++;
			if(i == menu.getNbRobot() + menu.getNbHumain()) {
				i=0;
			
			}
		}
	}
}
