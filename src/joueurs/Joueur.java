package joueurs;

import java.util.Iterator;

import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import tasDeCartes.Talon;
import tasDeCartes.TasDeCarte;

import jeu.PartieDeJeu;



import carte.bottes.Botte;


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

	public abstract void coupFourre() ;
	
	public boolean isGagnant() {
		PartieDeJeu partie = PartieDeJeu.getInstance();
		if(this.getJeuSurTable().getNbKmParcouru() >= partie.getNbKmMax() ) {
			return true;
		} 
		return false;
	}
	
	public boolean canCoupFourre() {
		for(Iterator<Carte> it = this.getJeuEnMain().getMain().iterator() ; it.hasNext() ; ) {
			Carte carte = it.next();
			if(carte instanceof Botte) {
				if(((Botte) carte).isJouableCoupFourre(this.getJeuSurTable())) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	public void piocher(TasDeCarte pioche) {
		if(pioche instanceof Talon) {
			this.piocherTalon();
		} else {
			this.piocherDefausse();
		}
			
	}
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
