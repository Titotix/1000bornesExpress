package modele;

import java.util.*;

import controleur.*;

public class JeuSurTable extends Observable {

	private int nbKmMax=1000;
	
	private int nbKmParcouru=0;
	

	private ArrayList<Attaque> pileBataille;
	private ArrayList<LimiteVitesse> pileVitesse;
	private ArrayList<Botte> pileBotte;
	private ArrayList<Etape> pileEtape;
	private ArrayList<FeuVert> pileFeuVertInitial;
	

	public JeuSurTable() {
		
		this.pileBataille=new ArrayList();
		this.pileVitesse=new ArrayList();
		this.pileBotte=new ArrayList();
		this.pileEtape=new ArrayList();
		this.pileFeuVertInitial = new ArrayList();
		
		this.pileBataille = null;
		this.pileVitesse=null;
		this.pileBotte=null;
		this.pileEtape=null;
		this.pileFeuVertInitial = null;
		
		Menu menu = Menu.getInstance();
		
		if(menu.isVariante()) {
			this.nbKmMax = 700;
		}
		
	}
	
	
	/** 
	 * @param Carte
	 * 
	 */
	
	public void ajouterCarteEtape(Etape carte)
	{
		this.pileEtape.add(carte);
	}
	
	public void ajouterCarteBataille(Attaque carte)
	{
		this.pileBataille.add(carte);
	}
	
	public void ajouterCarteVitesse(LimiteVitesse carte)
	{
		this.pileVitesse.add(carte);
	}
	
	public void ajouterCarteBotte(Botte carte)
	{
		this.pileBotte.add(carte);
	}
	
	public void ajouterFeuVertInitial(FeuVert feuVert) {
		this.pileFeuVertInitial.add(feuVert);
	}
	
	/*
	 * @param Carte
	 * 
	 */
	
	
	public void retirerCarteVitesse(LimiteVitesse carte)
	{
		this.pileVitesse.remove(carte);
	}
	
	public void retirerCarteBataille(Attaque carte)
	{
		this.pileBataille.remove(carte);
	}
	
	public int nbKmParcouru() {
		
		
		for (Etape etape : pileEtape) {
			this.nbKmParcouru += etape.getNbKm();
		}
		return this.nbKmParcouru;
	}
	
	
	public void verifVictoire()
	{
		
		if(this.nbKmParcouru() == this.nbKmMax)
		{
			//TODO VICTOIRE
		}
		
	}
	
	public boolean verifDepassementKm()
	{
		
		/*si la valeur de la carte etape ajout�e > (nbKmMax-nbKilometreParcouru)
		alors on ne peut pas poser la carte (ou alors le joueur a perdu ?)
		->Mettre tout ca dans la methode ajouterCarte directement ?
		if (
		*/
		return true;
		//TODO
	}
	/**
	 * Pour savoir si ce jeu sur table a posé ou non un feu vert initiateur.
	 * @return
	 */
	public boolean isDemarrer() {
		return !(this.pileFeuVertInitial.isEmpty());
	}


	/**
	 * @return the nbKmMax
	 */
	public int getNbKmMax() {
		return nbKmMax;
	}

	/**
	 * @param nbKmMax the nbKmMax to set
	 */
	public void setNbKmMax(int nbKmMax) {
		this.nbKmMax = nbKmMax;
	}
	
	public int getNbKmParcouru() {
		return this.nbKmParcouru;
	}
	public void setNbKmParcouru(int nbKmParcouru) {
		this.nbKmParcouru = nbKmParcouru;
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


	

	
}
