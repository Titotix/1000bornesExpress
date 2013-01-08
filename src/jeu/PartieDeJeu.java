package jeu;

import java.util.*;

import joueurs.Joueur;
import vue.*;
public class PartieDeJeu  extends Observable {
	
	private boolean termine;
	private int nbRobot;
	private int nbHumain;
	private int numeroJoueurActuel; // numero du joueur a qui c'est le tour.
	private static PartieDeJeu partie = null; //singelton
	private LinkedList<Joueur> joueurs;
	private int nbKmMax;


	private PartieDeJeu() {
		this.nbKmMax = 1000;
		this.termine=false;
		Menu menu = Menu.getInstance();
		this.nbRobot = menu.getNbRobot();
		this.nbHumain = menu.getNbHumain();
		this.joueurs = new LinkedList<Joueur>();
		this.numeroJoueurActuel = 0;
		//On concatène ici les deux LinkedList (d'Humain et de Robot) dans la LinkedList de Joueur.

		this.joueurs.addAll(menu.getHumain());
	
		this.joueurs.addAll(menu.getRobot());
	
		
	}
	
	public static PartieDeJeu getInstance() {
		if(partie == null) {
			partie = new PartieDeJeu();
		}
		return partie;
	}
	
	
	public void jouerPartie() {
		
		CmdLineInterface cmd = new CmdLineInterface();
		//Tant que la partie n'est pas terminée, le joueur[numeroJoueurActuel] joue.
		//On incremente numeroJoueurActuel jusqu'au nombre total de joueur, alors on le reinitialise alors a 0.		
		Joueur joueurActuel = null;
		while(this.termine==false) {
			System.out.println("\njeu de "+this.joueurs.get(this.numeroJoueurActuel).getNom());
			cmd.afficherJoueur(this.joueurs.get(this.numeroJoueurActuel));
			
			joueurActuel = this.joueurs.get(this.numeroJoueurActuel);
			joueurActuel.jouer();
			
			if(joueurActuel.isGagnant()) {
				this.setTermine(true);
			}
			
		}
		this.victoire(joueurActuel);
	}
	
	public void victoire(Joueur gagnant) {
		System.out.println("victoire de "+gagnant.getNom()); //TODO
	}
	
	public int getNumeroJoueurActuel() {
		return this.numeroJoueurActuel;
	}


	public void setNumeroJoueurActuel(int numeroJoueurActuel) {
		
		this.numeroJoueurActuel = numeroJoueurActuel;
		if(this.numeroJoueurActuel == this.nbRobot + this.nbHumain) {
			this.numeroJoueurActuel=0;
		
		} else if (this.numeroJoueurActuel == -1) {
			this.numeroJoueurActuel = this.nbRobot + this.nbHumain -1;
		}
		
		this.setChanged();
		this.notifyObservers(this);		
	}

	public int getNbKmMax() {
		return this.nbKmMax;
	}
	
	public void setNbKmMax(int nbKmMax) {
		//700 bornes a parcourir est la seule variante accepté.
		if(nbKmMax == 700) {
			this.nbKmMax = nbKmMax;
		}
		this.setChanged();
		this.notifyObservers(this);
	}

	public void setTermine(boolean termine) {
		this.termine = termine;
		this.setChanged();
		this.notifyObservers(this);
		
	}



}
