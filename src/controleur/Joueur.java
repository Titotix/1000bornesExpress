package controleur;

import modele.*;

public class Joueur {

	protected static Joueur[] joueur;
	protected JeuSurTable jeuSurTable;
	protected JeuEnMain jeuEnMain;
	protected int numPassage;
	protected String nom;
	protected boolean tourFini;

	
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
	public void poseCarteAttaque(Attaque carte){
		
	}
	
	
	//Pour la limite de vitesse
	public void poseLimiteVitesse(Attaque carte){
		
	}
	
	
	//Pour la parade
	public void parade(Parade parade) {
	
		if (parade.getType() == "ROUE_SECOURS") {
			this.paradeCrevaison(parade);
		} 
		else if (parade.getType() == "FEU_ROUGE") {
			this.paradeFeuRouge(parade);
		} 
		else if (parade.getType()== "FIN_LIMITE_VITESSE") {
			this.paradeLimiteDeVitesse(parade);
		}
		else if (parade.getType() == "REPARATION") {
			this.paradeAccident(parade);
		}
		else if (parade.getType() == "ESSENCE") {
			this.paradePanneDEssence(parade);
		}
		
	}
	
	public void paradeCrevaison(Parade parade) {
		//methode bas niveau a coder en supposant que tous les controle que la carte est approprié à poser sont faits.
	}
	
	public void paradeFeuRouge(Parade parade) {

		//methode bas niveau a coder en supposant que tous les controle que la carte est approprié à poser sont faits.
	}
	
	public void paradeLimiteDeVitesse (Parade parade) {

		//methode bas niveau a coder en supposant que tous les controle que la carte est approprié à poser sont faits.
	}
	
	public void paradeAccident(Parade parade) {

		//methode bas niveau a coder en supposant que tous les controle que la carte est approprié à poser sont faits.
	}
	
	public void paradePanneDEssence(Parade parade) {

		//methode bas niveau a coder en supposant que tous les controle que la carte est approprié à poser sont faits.
	}
	
	//Pour avancer
	public void parcourir(Etape etape){
		this.jeuSurTable.setNbKilometreParcouru(etape.getNombreKilometres());		
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
	
	public JeuSurTable getJeu() {
		return this.jeuSurTable;
	}
	
	public JeuEnMain getMain() {
		return this.jeuEnMain;
	}
	

}
