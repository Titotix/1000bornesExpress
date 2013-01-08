package joueurs;

import java.util.Iterator;

import jeu.Menu;
import jeu.PartieDeJeu;



import carte.attaque.Attaque;
import carte.bottes.Botte;


import strategie.Strategy;
import tasDeCartes.Carte;
import tasDeCartes.Defausse;
import tasDeCartes.TasDeCarte;
import vue.CmdLineInterface;

public class Robot extends Joueur {
	
	public Robot(String nomJoueur, int numPassage, Strategy stratInitiale) {
		super(nomJoueur, numPassage);
		this.strat = stratInitiale;
	
	}

	private Strategy strat;

	public void jouer() {
		this.piocher(this.choixPioche());
		CmdLineInterface cmd = new CmdLineInterface();//TODO A VIRER
		cmd.afficherMainJoueur(this);//TODO A VIRER
		if(this.choixDefausser()) {
			
			/**
			 * Le robot choisit une carte à défausser.
			 */
			this.defausser(this.choixCarte(true)); 
			
		} else {
			Carte carteChoisie = this.choixCarte(false);
			if(carteChoisie instanceof Attaque) {
				Joueur adversaire = this.choixCible((Attaque) carteChoisie);
				carteChoisie.jouer(this, adversaire);
				
				/**
				 * On regarde si le joueur peut faire un coup fourre
				 */
				Botte botte = adversaire.canCoupFourre();
				if(botte != null) {
					if(adversaire instanceof Robot) {	
						adversaire.coupFourre(botte);
					}
					

					//Pour que ce soit au joueur qui a fait un coup fourre de jouer

				
				}
			} else {
				carteChoisie.jouer(this, null);
				
				

			}
			
		}

	}
	
	public Strategy getStrat() {
		return strat;
	}

	/**
	 * Renvoie faux si l'action choisie est de jouer une carte.
	 * Renvoie vrai si l'action choisie est de défausser une carte.
	 * Le robot choisira de défausser uniquement quand il n'aura aucune carte à jouer.
	 * @return boolean
	 */
	public boolean choixDefausser(){ 
		
		/**
		 * On teste toutes les cartes de la main du joueur
		 */
		for(Iterator<Carte> it = this.jeuEnMain.getMain().iterator(); it.hasNext() ; ) {
			
			Carte carte = it.next();
			Menu menu = Menu.getInstance();
			if(carte instanceof Attaque) {
				/**
				 * Pour chaque carte Attaque, on tente de les jouer sur tous les joueurs autre que nous même.
				 */
				for(Iterator<Joueur> it1 = menu.getJoueurs().iterator() ; it1.hasNext() ; ) {
					
					Joueur joueur = it1.next();
					/**
					 * Si une des carte Attaque du jeu du Robot est jouable alors il jouera et ne defaussera pas.
					 */
					if(carte.isJouable(this, joueur) && joueur != this) {
						
						return false;
					}
				}
			} else {
				/**
				 * Si une des carte autre que Attaque du jeu du Robot est jouable alors il jouera et ne defaussera pas.
				 */
				if(carte.isJouable(this, null)) {
					
					return false;
				}
			}
		}
		
		/**
		 * /Si ce n'est pas le cas, il defausse et cette methode renvoie alors false.
		 */
		return true;
	}
	
	public Carte choixCarte(boolean defausser) {
		return this.strat.choixCarte(this, defausser);		
	}

	
	public Joueur choixCible(Attaque carte) {
		return this.strat.choixCible(this, carte);
	}
	

	public void coupFourre(Botte botte) {
		
		botte.coupFourre(this);

	}

	
	public TasDeCarte choixPioche() {
		return this.strat.choixPioche();
	}
	
	public String toString() {
		return ""+this.strat;
	}


}
