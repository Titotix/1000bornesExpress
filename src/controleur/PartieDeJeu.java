package controleur;

import java.util.*;
import vue.*;
public class PartieDeJeu {

	private LinkedList<Joueur> joueur;
	
	private boolean termine;
	private int nbRobot;
	private int nbHumain;
	private int numeroJoueurActuel; // numero du joueur a qui c'est le tour.
	private static PartieDeJeu partie = null; //singelton



	private PartieDeJeu() {
		
		this.termine=false;
		Menu menu = Menu.getInstance();
		this.nbRobot = menu.getNbRobot();
		this.nbHumain = menu.getNbHumain();
		joueur = new LinkedList<Joueur>();
		this.numeroJoueurActuel = 0;
		//On concatène ici les deux LinkedList (d'Humain et de Robot) dans la LinkedList de Joueur.
		joueur.addAll(menu.getHumain());
		joueur.addAll(menu.getRobot());
		
	}
	
	public static PartieDeJeu getInstance() {
		if(partie == null) {
			partie = new PartieDeJeu();
		}
		return partie;
	}
	
	
	public void jouerPartie() {
		Menu menu = Menu.getInstance();

		int nbTour=0;
		CmdLineInterface cmd = new CmdLineInterface();
		//Tant que la partie n'est pas terminée, le joueur[i] joue.
		//On incremente i jusqu'au nombre total de joueur, on le reinitialise alors a 0.		
		//systeme pas viable ac le coup fourre //TODO
		while(this.termine==false) {
			System.out.println("\njeu de "+joueur.get(this.numeroJoueurActuel).getNom());
			cmd.afficherJoueur(joueur.get(this.numeroJoueurActuel));
			joueur.get(this.numeroJoueurActuel).jouer();
			nbTour++;
			System.out.println("nb de tour "+nbTour);
			
			if(this.numeroJoueurActuel == menu.getNbRobot() + menu.getNbHumain()) {
				this.numeroJoueurActuel=0;
			
			}
		}
	}
	
	public int getNumeroJoueurActuel() {
		return this.numeroJoueurActuel;
	}


	public void setNumeroJoueurActuel(int numeroJoueurActuel) {
		if(numeroJoueurActuel == this.nbHumain + this.nbRobot ) {
			
		}
		this.numeroJoueurActuel = numeroJoueurActuel;
	}
}
