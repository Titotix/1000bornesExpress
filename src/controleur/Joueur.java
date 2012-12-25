package controleur;

import modele.*;

public abstract class Joueur {

	protected static Joueur[] joueur;
	protected JeuSurTable jeuSurTable;
	protected JeuEnMain jeuEnMain;
	protected int numPassage;
	protected String nom;

	
	//constructeur
	public Joueur (String nomJoueur, int numPassage){
		this.nom=nomJoueur;
		this.numPassage=numPassage;

		this.jeuEnMain = new JeuEnMain();
		this.jeuSurTable = new JeuSurTable();
	}
	
	public abstract void jouer(); 

	public abstract TasDeCarte choixPioche(JeuEnMain jeuEnMain);
	
	public abstract Carte choixCarte();
	
	public void piocherTalon() {
		Talon talon = Talon.getInstance();
		this.jeuEnMain.ajouterCarte(talon.piocher());
		
	}
	
	public void piocherDefausse() {
		Defausse defausse = Defausse.getInstance();
		this.jeuEnMain.ajouterCarte(defausse.piocher());
	}
	


	
	public void defausser(Carte carte) {
		Defausse defausse = Defausse.getInstance();
		this.jeuEnMain.retirerCarte(carte);  //va retirer la carte de la main du joueur
		defausse.ajouterCarte(carte);  //ajoute la carte défausser à la défausse
	}
	
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		
	}
	
	public int getNumPassage() {
		return this.numPassage;
	}

	public void setNumPassage(int numPassage) {
		this.numPassage = numPassage;
		
	}
	
	public JeuSurTable getJeuSurTable() {
		return this.jeuSurTable;
	}
	
	public JeuEnMain getJeuEnMain() {
		return this.jeuEnMain;
	}
	
	public String toString() {
		return this.nom;
	}

}
