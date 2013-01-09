package jeu;

import java.util.*;

import joueurs.Joueur;
import tasDeCartes.Carte;
import vue.*;
/**
 * Represente une partie de jeu entière : contient le numero du joueur actuel, lance et termine la partie, selectionne le nombre de km Max
 * @author Damien
 *
 */
public class PartieDeJeu  extends Observable {
	
	private boolean termine;
	private int nbRobot;
	private int nbHumain;
	private Joueur gagnant;
	/**
	 *  numero du joueur dont c'est le tour.
	 */
	private int numeroJoueurActuel; 
	/**
	 * singelton
	 */
	private static PartieDeJeu partie = null;
	private LinkedList<Joueur> joueurs;
	private int nbKmMax;


	private PartieDeJeu() {
		this.gagnant = null;
		this.nbKmMax = 1000;
		this.termine=false;
		Menu menu = Menu.getInstance();
		this.nbRobot = menu.getNbRobot();
		this.nbHumain = menu.getNbHumain();
		this.joueurs = new LinkedList<Joueur>();
		this.numeroJoueurActuel = 0;
		/**
		 * On concatène ici les deux LinkedList (d'Humain et de Robot) dans la LinkedList de Joueur.
		 */
		
	}
	/**
	 * Singleton
	 * 
	 */
	public synchronized static PartieDeJeu getInstance() {
		
		if(partie == null) {
			partie = new PartieDeJeu();
		}
		return partie;
	}
	/**
	 * Synchronise la création de la partie entre les thread.
	 */
	public void initPartie() {
		synchronized(this) {
			try {
				
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.joueurs.addAll(Menu.getInstance().getHumain());
		
		this.joueurs.addAll(Menu.getInstance().getRobot());
	}
	
	/**
	 * Lance la partie de mille bornes à proprement dit.
	 * Une fois la nouvelle partie crée, cette méthode s'occupe de faire jouer les joueur chacun à leur tour de jeu.
	 */
	public void jouerPartie() {
		this.initPartie();
		/**
		 * Tant que la partie n'est pas terminée, le joueur[numeroJoueurActuel] joue.
		 * On incremente numeroJoueurActuel jusqu'au nombre total de joueur, alors on le reinitialise alors a 0.		
		 */
		Joueur joueurActuel = null;
		while(this.termine==false) {
			this.setChanged();
			this.notifyObservers("debut");
					
			joueurActuel = this.joueurs.get(this.numeroJoueurActuel);
			System.out.println(""+joueurActuel.getNom());
			System.out.println(""+joueurActuel.getJeuEnMain().getMain().toString());
			System.out.println(""+joueurActuel.getJeuSurTable().toString());

			joueurActuel.jouer();


			if(joueurActuel.isGagnant()) {
				this.gagnant = joueurActuel;
				this.setTermine(true, joueurActuel);
				
			}
			
		}
		
	}
	
	/**
	 * Recupere le numero du joueur actuel
	 *
	 */
	
	public int getNumeroJoueurActuel() {
		return this.numeroJoueurActuel;
	}

	/**
	 * Definit le numero du joueur actuel
	 * @param numeroJoueurActuel
	 */
	public void setNumeroJoueurActuel(int numeroJoueurActuel) {
		
		this.numeroJoueurActuel = numeroJoueurActuel;
		if(this.numeroJoueurActuel == this.nbRobot + this.nbHumain) {
			this.numeroJoueurActuel=0;
		
		} else if (this.numeroJoueurActuel == -1) {
			this.numeroJoueurActuel = this.nbRobot + this.nbHumain -1;
		}
		
		this.setChanged();
		this.notifyObservers();		
	}
	
	public int getNbKmMax() {
		return this.nbKmMax;
	}
	
	/**
	 * Definit le nombre de km max
	 * @param nbKmMax
	 */
	public void setNbKmMax(int nbKmMax) {
		/**
		 * 700 bornes a parcourir est la seule variante accepté.
		 */
		if(nbKmMax == 700) {
			this.nbKmMax = nbKmMax;
		}
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Indique que la partie a été gagné ou non. Si c'est le cas, notification de la vue avec comme argument le gagnant.
	 * @param termine
	 * @param gagnant
	 */
	public void setTermine(boolean termine, Joueur gagnant) {
		this.termine = termine;
		this.setChanged();
		this.notifyObservers();
		
	}
	
	/**
	 * Recupere le booleen termine
	 *
	 */
	public boolean isTerminee() {
		
		return this.termine;
	}
	public Joueur getGagnant() {
	
		return this.gagnant;
	}
	public LinkedList<Joueur> getJoueurs() {
	
		return this.joueurs;
	}



}
