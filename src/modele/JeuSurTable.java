package modele;

import java.util.*;

import controleur.*;

public class JeuSurTable extends Observable {

	private int nbKmMax;
	
	private int nbKmParcouru;
	

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
		
		this.nbKmParcouru=0;
		this.nbKmMax=1000;
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
	
	public void retirerCarteVitesse(LimiteVitesse carte)
	{
		this.pileVitesse.remove(carte);
	}
	
	public void retirerCarteBataille(Attaque carte)
	{
		this.pileBataille.remove(carte);
	}
	
	public int nbKmParcouru() {
			
		for(Iterator<Etape> it = this.pileEtape.iterator(); it.hasNext() ;) {
			this.nbKmParcouru += it.next().getNbKm();
		}
		
		return this.nbKmParcouru;
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


	public String toString() {
		return " pileBataille "+this.getPileBataille().toString() +"\n"+" pileBotte "+this.getPileBotte().toString() +"\n"+ "pileEtape "+this.getPileEtape().toString() + "\n"+" pileVitesse "+this.getPileVitesse().toString() +"\n"+ " pileFeuVertInitial "+this.getPileFeuVertInitial().toString();
	}

	
}
