package controleur;

import modele.*;

public abstract class Joueur {

	protected static Joueur[] joueur;
	protected JeuSurTable jeuSurTable;
	protected JeuEnMain jeuEnMain;
	protected int numPassage;
	protected String nom;
	protected boolean tourFini;

	
	//constructeur
	public Joueur (String nomJoueur, int numPassage){
		this.nom=nomJoueur;
		this.numPassage=numPassage;

		this.jeuEnMain = new JeuEnMain();
		this.jeuSurTable = new JeuSurTable();
	}
	
	public abstract void jouer(); 
	
	public void piocher() {
		
	}
	
	public void piocherTalon() {
		Talon talon = Talon.getInstance();
		this.jeuEnMain.ajouterCarte(talon.piocher());
		
	}
	
	public void piocherDefausse() {
		Defausse defausse = Defausse.getInstance();
		this.jeuEnMain.ajouterCarte(defausse.piocher());
	}
	
	//Le choix de la carte a jouer.
	public void choixCarte (){
		
	}

	
	public void defausser(Carte carte) {
		Defausse defausse = Defausse.getInstance();
		this.jeuEnMain.retirerCarte(carte);  //va retirer la carte de la main du joueur
		defausse.ajouterCarte(carte);  //ajoute la carte défausser à la défausse
	}
	
	//Pour finir son tour et que ce soit au joueur suivant
	public void joueurSuivant (){
		/* if clic sur bouton FINTOUR(interface graphique)
		tourFini=true; (et tourFini=false � chaque d�but de tour d'un joueur humain)
		*/
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
	

}
