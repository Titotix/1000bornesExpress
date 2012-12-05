package controleur;

import modele.*;

public class Joueur {

	protected static Joueur[] joueur;
	protected JeuSurTable jeuSurTable;
	protected JeuEnMain jeuEnMain;
	protected int numPassage;
	protected String nom;
	
	/** 
	 * TODO
	 * Creer une partie
	 * Piocher(prendre une carte dans le talon/Defausse
	 * Choix de la carte � poser (parmis la main)
	 * Poser une carte sur son jeu
	 * Attaquer (poser une carte sur le jeu adverse)
	 * D�fausser(poser une carte dans la defausse)
	 * Choisir une cible
	 * Sortir la carte Botte qui convient
	 * 
	 * 
	 */

	
	//constructeur
	public Joueur (String nomJoueur, int numPassage){
		this.nom=nomJoueur;
		this.numPassage=numPassage;

		this.jeuEnMain = new JeuEnMain();
		this.jeuSurTable = new JeuSurTable();
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

	//Pour commencer � attaquer
	public void attaquer(Carte carte){
		
		//TODO
	}
	
	
	//Pour l'attaque autre que limite de vitesse
	public void poseCarteAttaque(){
		
	}
	
	
	//Pour la limite de vitesse
	public void poseLimiteVitesse(){
		
	}
	
	
	//Pour la parade
	public void parade(){
		
	}
	
	//Pour avancer
	public void parcourir(){
		
	}
	
	/** 
	 * 
	 * 
	 */
	public boolean feuVertInitial(){
		if(!this.jeuSurTable.isFeuVertInitial()) {
			this.jeuSurTable.setFeuVertInitial(true);
			return true;
		} else {
			return false;
		}
		
	}
	
	public void defausser(Carte carte) {
		Defausse defausse = Defausse.getInstance();
		this.jeuEnMain.retirerCarte(carte);  //va retirer la carte de la main du joueur
		defausse.ajouterCarte(carte);  //ajoute la carte défausser à la défausse
	}
	
	//Pour finir son tour et que ce soit au joueur suivant
	public void joueurSuivant (){
		
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
	
	public JeuSurTable getJeu() {
		return this.jeuSurTable;
	}
	
	public JeuEnMain getMain() {
		return this.jeuEnMain;
	}
	
}
