package joueurs;

import java.util.*;

import jeu.PartieDeJeu;

import carte.attaque.Attaque;
import carte.attaque.LimiteVitesse;
import carte.bottes.Botte;
import carte.etape.Etape;
import carte.parade.FeuVert;

/**
 * Represente le jeu sur table des joueurs
 * @author Damien
 *
 */
public class JeuSurTable extends Observable {
	

	private int nbKmParcouruBotte;
	

	private ArrayList<Attaque> pileBataille;
	private ArrayList<LimiteVitesse> pileVitesse;
	private ArrayList<Botte> pileBotte;
	private ArrayList<Etape> pileEtape;
	private ArrayList<FeuVert> pileFeuVertInitial;
	private Joueur joueur=null; 


	public JeuSurTable(Joueur joueur) {
		
		this.pileBataille=new ArrayList<Attaque>();
		this.pileVitesse=new ArrayList<LimiteVitesse>();
		this.pileBotte=new ArrayList<Botte>();
		this.pileEtape=new ArrayList<Etape>();
		this.pileFeuVertInitial = new ArrayList<FeuVert>();
		this.joueur = joueur;
		this.nbKmParcouruBotte=0;

	}
	
	
	/** 
	 * Ajoute une carte Etape sur le bon tas
	 * @param carte
	 * 
	 */
	
	public void ajouterCarteEtape(Etape carte)
	{
		this.pileEtape.add(carte);
		this.setChanged();
		this.notifyObservers();
	}
	
	/** 
	 * Ajoute une carte attaque sur le bon tas
	 * @param carte
	 * 
	 */
	public void ajouterCarteBataille(Attaque carte)
	{
		if(this.pileBataille.isEmpty()) {			
			this.pileBataille.add(carte);	
			this.setChanged();
			this.notifyObservers();
		} 
	}
	
	/** 
	 * Ajoute une carte vitesse sur le bon tas
	 * @param carte
	 * 
	 */
	public void ajouterCarteVitesse(LimiteVitesse carte)
	{
		if(this.pileVitesse.isEmpty()) {
			this.pileVitesse.add(carte);
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	/** 
	 * Ajoute une carte botte sur le bon tas
	 * @param carte
	 * 
	 */
	public void ajouterCarteBotte(Botte carte)
	{
		this.pileBotte.add(carte);
		this.setChanged();
		this.notifyObservers();
	}
	
	/** 
	 * Ajoute une carte feu vert  sur le bon tas au debut de la partie
	 * @param feuVert
	 * 
	 */
	public void ajouterFeuVertInitial(FeuVert feuVert) {
		this.pileFeuVertInitial.add(feuVert);
		this.setChanged();
		this.notifyObservers();
	}
	
	/** 
	 * Retire une carte vitesse depuis le bon tas
	 * @param carte
	 * 
	 */
	public void retirerCarteVitesse(LimiteVitesse carte)
	{
		this.pileVitesse.remove(carte);
		this.setChanged();
		this.notifyObservers();
	}
	
	/** 
	 * Retire une carte attaque depuis le bon tas
	 * @param carte
	 * 
	 */
	public void retirerCarteBataille(Attaque carte)
	{
		this.pileBataille.remove(carte);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Donne la valeur des km parcourus par le joueur
	 * 
	 */
	public int getNbKmParcouruTotal() {	
		return this.getNbKmParcouruEtape() + this.nbKmParcouruBotte;
	}
	

	/**
	 * Pour savoir si ce jeu sur table a posé ou non un feu vert initiateur.
	 * 
	 */
	public boolean isDemarrer() {
		return !(this.pileFeuVertInitial.isEmpty());
	}
	
	public int getNbKmParcouruEtape() {
		int nbKmParcouruEtape=0;
		
		for(Iterator<Etape> it = this.pileEtape.iterator(); it.hasNext() ;) {
			nbKmParcouruEtape += it.next().getNbKm();
		}
		
		return nbKmParcouruEtape;
	}
	
	public void addNbKmParcouruBotte(int nbKm) {
		this.nbKmParcouruBotte += nbKm;
		this.setChanged();
		this.notifyObservers();
	}
	
	public ArrayList<Attaque> getPileBataille() {
		return this.pileBataille;
	}
	public ArrayList<LimiteVitesse> getPileVitesse() {
		return this.pileVitesse;
	}
	public ArrayList<Botte> getPileBotte() {
		return this.pileBotte;
	}
	public ArrayList<Etape> getPileEtape() {
		return this.pileEtape;
	}
	public ArrayList<FeuVert> getPileFeuVertInitial() {
		return this.pileFeuVertInitial;
	}


	public String toString() {
		return " pileBataille "+this.getPileBataille().toString() +"\n"+" pileBotte "+this.getPileBotte().toString() +"\n"+ "pileEtape "+this.getPileEtape().toString() + "\n"+" pileVitesse "+this.getPileVitesse().toString() +"\n"+ " pileFeuVertInitial "+this.getPileFeuVertInitial().toString();
	}

	public Joueur getJoueur() {
		return joueur;
	}

}
