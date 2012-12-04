package modele;

import java.util.*;
import controleur.*;

public class Talon extends Observable {
	
	private final int nombreCarteInitial = 66;
	private int nombreCarteADistribuer;
	private int nombreCarteActuel;
	private LinkedList<Carte> pileCarte; 
	
	//constructeur, qui cr�� la pile de carte contenant toutes les cartes
	public Talon () {
		pileCarte = new LinkedList<Carte>();
		this.creerCartes();
	}
	
	
	/**
	 * Permet la creation des cartes grace aux constructeurs des types
	 * @param 
	 * 
	 */
	public void creerCartes() {
		int i;
		//Les attaques
		for (i=1;i<3;i++){
			Attaque crevaison=new Attaque(Attaque.CREVAISON);// Fonctionne avec le i comme ca ? TODO
			pileCarte.add(crevaison);			
			}
			
		for (i=3;i<5;i++){
			Attaque accident=new Attaque(Attaque.ACCIDENT);
			pileCarte.add(accident);		
			}
		
		for (i=5;i<7;i++){
			Attaque panneEssence=new Attaque(Attaque.PANNE_ESSENCE);
			pileCarte.add(panneEssence);			
			}
		
		for (i=7;i<9;i++){
			Attaque limiteVitesse=new Attaque(Attaque.LIMITE_VITESSE);
			pileCarte.add(limiteVitesse);			
			}
		
		for (i=9;i<11;i++){
			Attaque feuRouge=new Attaque(Attaque.FEU_ROUGE);
			pileCarte.add(feuRouge);		
			}
		
		//Les parades
		
		for (i=11;i<15;i++){
			Parade roueDeSecours=new Parade(Parade.ROUE_SECOURS);
			pileCarte.add(roueDeSecours);			
			}
		
		for (i=15;i<19;i++){
			Parade reparation=new Parade(Parade.REPARATION);
			pileCarte.add(reparation);			
			}
		
		for (i=19;i<23;i++){
			Parade essence=new Parade(Parade.ESSENCE);
			pileCarte.add(essence);		
			}
		
		for (i=23;i<27;i++){
			Parade finLimiteVitesse=new Parade(Parade.FIN_LIMITE_VITESSE);
			pileCarte.add(finLimiteVitesse);			
			}
		
		for (i=27;i<32;i++){
			Parade feuVert=new Parade(Parade.FEU_VERT);
			pileCarte.add(feuVert);			
			}
		
		//Les bottes
		Botte increvable=new Botte(Botte.INCREVABLE);
		pileCarte.add(increvable);
		Botte asDuVolant=new Botte(Botte.AS_DU_VOLANT);
		pileCarte.add(asDuVolant);
		Botte prioritaire=new Botte(Botte.PRIORITAIRE);
		pileCarte.add(prioritaire);
		Botte citerne=new Botte(Botte.CITERNE_ESSENCE);
		pileCarte.add(citerne);
		
		//Les �tapes
		for (i=36;i<42;i++){
			Etape etape=new Etape(25);
			pileCarte.add(etape);		
			}
		
		for (i=42;i<48;i++){
			Etape etape=new Etape(50);
			pileCarte.add(etape);			
			}
		
		for (i=48;i<54;i++){
			Etape etape=new Etape(75);
			pileCarte.add(etape);			
			}
		
		for (i=54;i<64;i++){
			Etape etape=new Etape(100);
			pileCarte.add(etape);	
			}
		
		for (i=64;i<67;i++){
			Etape etape=new Etape(200);
			pileCarte.add(etape);		
			}
		
		//Ce message permet d'avoir la liste de toutes les cartes de la pileCarte
	System.out.println(pileCarte.toString()); //TODO ( a virer a l'avenir)
		
		
	}
	
	/**
	 * Calcul du nombre de cartes a distribuer
	 * @param menu
	 * @return nombre de carte a distribuer au total
	 */
	public int nbCarteADistribuer(){
		Menu menu = Menu.getInstance();
		return menu.getNbJoueurTotal() * 4; 
	}
	
	//Trier les cartes al�atoirement
	public void aleatoirePileCarte(){
		
	}
	
	//Distribuer les cartes depuis le talon
	public void distribuer() {
		Menu menu = Menu.getInstance();
		Humain[] humain = menu.getHumain();
		Robot[] robot = menu.getRobot();
		int nbCarteADistribuer = this.nbCarteADistribuer();
		
		while( nbCarteADistribuer > 0 ) {
			
			for(int j=0; j < menu.getNbHumain() ; j++) {
				nbCarteADistribuer--;
				
				humain[j].getMain().ajouterCarte(this.pileCarte.removeFirst());
			}
			
			for(int k=0; k < menu.getNbRobot() ; k++) {
				nbCarteADistribuer--;
				robot[k].getMain().ajouterCarte(this.pileCarte.removeFirst());
			}
		}
		
		
			for(int i=0; i < menu.getNbRobot(); i++) {
						
			System.out.println(menu.getRobot()[i].getMain().toString());
			}
			for(int i=0; i < menu.getNbHumain(); i++) {
				
			System.out.println(menu.getHumain()[i].getMain().toString());

			}
		//TODO //System.out.println(pileCarte.toString());
		
	}
	
	/*//Piocher dans le talon
	public Carte piocheTalon(){
		
	}*/
	public void afficherJeuDesHumains () {
		Menu menu = Menu.getInstance();
		for(int i=0; i < menu.getNbHumain(); i++) {
			
			System.out.println(menu.getHumain()[i].getMain().toString());

			}
	}

}
