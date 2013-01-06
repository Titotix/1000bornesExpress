package vue;



import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

import jeu.Menu;

public class FenetrePrincipale extends JFrame{
	
	
	protected int nbJoueurs;
	protected String nom;
	
	//Variables pour le Joueur 1
	JButton etapeJ1=new JButton("Etape");
	JButton attaqueJ1=new JButton("Attaque");
	JButton limiteJ1=new JButton("Limite de vitesse");
	JButton botteJ1=new JButton("Bottes");
	JLabel kmJ1=new JLabel("Km :");
	JLabel bottePossJ1=new JLabel("Bottes :");
	
	//Variables Joueur 2
	JButton etapeJ2=new JButton("Etape");
	JButton attaqueJ2=new JButton("Attaque");
	JButton limiteJ2=new JButton("Limite de vitesse");
	JButton botteJ2=new JButton("Bottes");
	JLabel kmJ2=new JLabel("Km :");
	JLabel bottePossJ2=new JLabel("Bottes :");
	
	//Variables Joueur 3
	JButton etapeJ3=new JButton("Etape");
	JButton attaqueJ3=new JButton("Attaque");
	JButton limiteJ3=new JButton("Limite de vitesse");
	JButton botteJ3=new JButton("Bottes");
	JLabel kmJ3=new JLabel("Km :");
	JLabel bottePossJ3=new JLabel("Bottes :");
	
	//Variables Joueur 4
	JButton etapeJ4=new JButton("Etape");
	JButton attaqueJ4=new JButton("Attaque");
	JButton limiteJ4=new JButton("Limite de vitesse");
	JButton botteJ4=new JButton("Bottes");
	JLabel kmJ4=new JLabel("Km :");
	JLabel bottePossJ4=new JLabel("Bottes :");
	
	//Variables cartes en main
	JButton carte1Joueur=new JButton("Selectionner");
	JButton carte2Joueur=new JButton("Selectionner");
	JButton carte3Joueur=new JButton("Selectionner");
	JButton carte4Joueur=new JButton("Selectionner");
	JButton carte5Joueur=new JButton("Selectionner");
	
	//Variables talon/defausse/evenements
	JButton talonBouton=new JButton("Piocher");
	JButton defausseBouton=new JButton("Piocher");
	JLabel eventLabel = new JLabel("Ici les evenements");
	
	Box b1 = Box.createHorizontalBox();
	
	Controleur controleur;
	
  public FenetrePrincipale(Controleur controleur){
    this.setTitle("1000 Bornes EXPRESS");
    this.setSize(1366, 768);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.controleur = controleur;
    nbJoueurs=Menu.getInstance().getNbJoueurTotal();
    
   
    if (nbJoueurs==2){

    //On crée un conteneur avec gestion horizontale pour les joueurs
    
    JInternalFrame joueur1 = new JInternalFrame(); 
    joueur1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
    
    nom=controleur.getJoueurs().get(0).getNom();
    
	joueur1.setTitle(nom);
	joueur1.setVisible(true);//On la rend visible
	joueur1.setLayout(new GridLayout(3, 2));//Quadrillage pour les tas du joueur
	
		
	//On implémente l'action d'appuyer sur CE bouton (on doit le faire pour chaque bouton)
	etapeJ1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du premier joueur");
			kmJ1.setText("Km : ");//Afficher la valeur de l'int de km parcourus TODO
			if (controleur.isPosableSurEtape==TRUE){
				
			}
			//TODO
		}
	});
	
	joueur1.add (etapeJ1);
	
	
	
	attaqueJ1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du premier joueur");
			//Quand on attaque un jour, délai de 5 sec , puis apparition des cartes du joueur attaqué pendant 5 sec (il peut sortir une botte), 
			//puis si aucune botte sortie, c'est au tour du joueur suivant l'attaquant. (->Coup fourré)
			
			//TODO
			if (controleur.isPosableSurAttaque==TRUE){
				
			}
		}
	});
	joueur1.add(attaqueJ1);
	
	
	
	
	limiteJ1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du premier joueur");
			//TODO
			if (controleur.isPosableLimiteVitesse==TRUE){
				
			}
		}
	});
	joueur1.add(limiteJ1);
	
	
	
	botteJ1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du premier joueur");
			//Afficher les initiales des bottes que le joueur possede : IC/RS/PR/CI avec un bottePossJ1.setText("...");
			//TODO
			if (controleur.isPosableLimiteVitesse==TRUE){
				
			}
		}
	});
	joueur1.add(botteJ1);
	
	
	joueur1.add(kmJ1);
	joueur1.add(bottePossJ1);
	
	// On ajoute le joueur a la box horizontale
	b1.add(joueur1);
	
	/////////
	JInternalFrame joueur2 = new JInternalFrame(); 
	joueur2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(1).getNom();
	joueur2.setTitle(nom);
	joueur2.setVisible(true);//On la rend visible
	joueur2.setLayout(new GridLayout(3, 2));
	
	
	etapeJ2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du deuxième joueur");
			//TODO
		}
	});
	joueur2.add (etapeJ2);
	
	
	attaqueJ2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du deuxième joueur");
			//TODO
		}
	});
	joueur2.add(attaqueJ2);
	
	
	limiteJ2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du deuxième joueur");
			//TODO
		}
	});
	joueur2.add(limiteJ2);
	
	
	botteJ2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du deuxième joueur");
			//TODO
		}
	});
	joueur2.add(botteJ2);
	
	
	joueur2.add(kmJ2);
	joueur2.add(bottePossJ2);
	
	b1.add(joueur2);
    }
	
    else if (nbJoueurs==3){
    	
    	
    	 //On crée un conteneur avec gestion horizontale pour les joueurs
        
        JInternalFrame joueur1 = new JInternalFrame(); 
        joueur1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
        nom=controleur.getJoueurs().get(0).getNom();
    	joueur1.setTitle(nom);
    	joueur1.setVisible(true);//On la rend visible
    	joueur1.setLayout(new GridLayout(3, 2));//Quadrillage pour les tas du joueur
    	
    		
    	//On implémente l'action d'appuyer sur CE bouton (on doit le faire pour chaque bouton)
    	etapeJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du premier joueur");
    			kmJ1.setText("Km : ");//Afficher la valeur de l'int de km parcourus TODO
    			//TODO
    		}
    	});
    	joueur1.add (etapeJ1);
    	
    	
    	
    	attaqueJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du premier joueur");
    			//Quand on attaque un jour, délai de 5 sec , puis apparition des cartes du joueur attaqué pendant 5 sec (il peut sortir une botte), 
    			//puis si aucune botte sortie, c'est au tour du joueur suivant l'attaquant. (->Coup fourré)
    			
    			//TODO
    		}
    	});
    	joueur1.add(attaqueJ1);
    	
    	
    	
    	
    	limiteJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du premier joueur");
    			//TODO
    		}
    	});
    	joueur1.add(limiteJ1);
    	
    	
    	
    	botteJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du premier joueur");
    			//Afficher les initiales des bottes que le joueur possede : IC/RS/PR/CI avec un bottePossJ1.setText("...");
    			//TODO
    		}
    	});
    	joueur1.add(botteJ1);
    	
    	
    	joueur1.add(kmJ1);
    	joueur1.add(bottePossJ1);
    	
    	// On ajoute le joueur a la box horizontale
    	b1.add(joueur1);
    	
    	/////////
    	JInternalFrame joueur2 = new JInternalFrame(); 
    	joueur2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
    	nom=controleur.getJoueurs().get(1).getNom();
    	joueur2.setTitle(nom);
    	joueur2.setVisible(true);//On la rend visible
    	joueur2.setLayout(new GridLayout(3, 2));
    	
    	
    	etapeJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add (etapeJ2);
    	
    	
    	attaqueJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add(attaqueJ2);
    	
    	
    	limiteJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add(limiteJ2);
    	
    	
    	botteJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add(botteJ2);
    	
    	
    	joueur2.add(kmJ2);
    	joueur2.add(bottePossJ2);
    	
    	b1.add(joueur2);
    
    /////////
	JInternalFrame joueur3 = new JInternalFrame(); 
	joueur3.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(2).getNom();
	joueur3.setTitle(nom);
	joueur3.setVisible(true);//On la rend visible
	joueur3.setLayout(new GridLayout(3, 2));
	
	
	etapeJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du troisième joueur");
			//TODO
		}
	});
	joueur3.add (etapeJ3);
	
	
	attaqueJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du troisième joueur");
			//TODO
		}
	});
	joueur3.add(attaqueJ3);
	
	
	limiteJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du troisième joueur");
			//TODO
		}
	});
	joueur3.add(limiteJ3);
	
	
	botteJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du troisième joueur");
			//TODO
		}
	});
	joueur3.add(botteJ3);
	
	
	joueur3.add(kmJ3);
	joueur3.add(bottePossJ3);
	
	b1.add(joueur3);
	
    }
    
    else if (nbJoueurs == 4){
    	
    	//On crée un conteneur avec gestion horizontale pour les joueurs
       
        JInternalFrame joueur1 = new JInternalFrame(); 
        joueur1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
        nom=controleur.getJoueurs().get(0).getNom();
    	joueur1.setTitle(nom);
    	joueur1.setVisible(true);//On la rend visible
    	joueur1.setLayout(new GridLayout(3, 2));//Quadrillage pour les tas du joueur
    	
    		
    	//On implémente l'action d'appuyer sur CE bouton (on doit le faire pour chaque bouton)
    	etapeJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du premier joueur");
    			kmJ1.setText("Km : ");//Afficher la valeur de l'int de km parcourus TODO
    			//TODO
    		}
    	});
    	joueur1.add (etapeJ1);
    	
    	
    	
    	attaqueJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du premier joueur");
    			//Quand on attaque un jour, délai de 5 sec , puis apparition des cartes du joueur attaqué pendant 5 sec (il peut sortir une botte), 
    			//puis si aucune botte sortie, c'est au tour du joueur suivant l'attaquant. (->Coup fourré)
    			
    			//TODO
    		}
    	});
    	joueur1.add(attaqueJ1);
    	
    	
    	
    	
    	limiteJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du premier joueur");
    			//TODO
    		}
    	});
    	joueur1.add(limiteJ1);
    	
    	
    	
    	botteJ1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du premier joueur");
    			//Afficher les initiales des bottes que le joueur possede : IC/RS/PR/CI avec un bottePossJ1.setText("...");
    			//TODO
    		}
    	});
    	joueur1.add(botteJ1);
    	
    	
    	joueur1.add(kmJ1);
    	joueur1.add(bottePossJ1);
    	
    	// On ajoute le joueur a la box horizontale
    	b1.add(joueur1);
    	
    	/////////
    	JInternalFrame joueur2 = new JInternalFrame(); 
    	joueur2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
    	nom=controleur.getJoueurs().get(1).getNom();
    	joueur2.setTitle(nom);
    	joueur2.setVisible(true);//On la rend visible
    	joueur2.setLayout(new GridLayout(3, 2));
    	
    	
    	etapeJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add (etapeJ2);
    	
    	
    	attaqueJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add(attaqueJ2);
    	
    	
    	limiteJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add(limiteJ2);
    	
    	
    	botteJ2.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent event){
    			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du deuxième joueur");
    			//TODO
    		}
    	});
    	joueur2.add(botteJ2);
    	
    	
    	joueur2.add(kmJ2);
    	joueur2.add(bottePossJ2);
    	
    	b1.add(joueur2);
    
    /////////
	JInternalFrame joueur3 = new JInternalFrame(); 
	joueur3.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(2).getNom();
	joueur3.setTitle(nom);
	joueur3.setVisible(true);//On la rend visible
	joueur3.setLayout(new GridLayout(3, 2));
	
	
	etapeJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du troisième joueur");
			//TODO
		}
	});
	joueur3.add (etapeJ3);
	
	
	attaqueJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du troisième joueur");
			//TODO
		}
	});
	joueur3.add(attaqueJ3);
	
	
	limiteJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du troisième joueur");
			//TODO
		}
	});
	joueur3.add(limiteJ3);
	
	
	botteJ3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du troisième joueur");
			//TODO
		}
	});
	joueur3.add(botteJ3);
	
	
	joueur3.add(kmJ3);
	joueur3.add(bottePossJ3);
	
	b1.add(joueur3);
	
	///////////
	JInternalFrame joueur4 = new JInternalFrame(); 
	joueur4.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	nom=controleur.getJoueurs().get(3).getNom();
	joueur4.setTitle(nom);
	joueur4.setVisible(true);//On la rend visible
	joueur4.setLayout(new GridLayout(3, 2));
	
	
	etapeJ4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'étape du quatrième joueur");
			//TODO
		}
	});
	joueur4.add (etapeJ4);
	
	
	attaqueJ4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas d'attaque du quatrième joueur");
			//TODO
		}
	});
	joueur4.add(attaqueJ4);
	
	
	limiteJ4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de vitesse du quatrième joueur");
			//TODO
		}
	});
	joueur4.add(limiteJ4);
	
	
	botteJ4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez posé la carte sur le tas de limite de bottes du quatrième joueur");
			//TODO
		}
	});
	joueur4.add(botteJ4);
	
	
	joueur4.add(kmJ4);
	joueur4.add(bottePossJ4);
	
	b1.add(joueur4);
	
    }
    
    //Idem pour les cartes en main du joueur qui joue
    
    Box b2 = Box.createHorizontalBox();
    
    JInternalFrame carte1 = new JInternalFrame(); 
	carte1.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte1.setTitle("Carte 1");
	carte1.setVisible(true);//On la rend visible
	
	
	carte1Joueur.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez choisi la première carte");
			//TODO
		}
	});
	carte1.add(carte1Joueur);
	b2.add(carte1);
	
	JInternalFrame carte2 = new JInternalFrame(); 
	carte2.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte2.setTitle("Carte 2");
	carte2.setVisible(true);//On la rend visible
	
	
	carte2Joueur.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez choisi la deuxième carte");
			//TODO
		}
	});
	carte2.add(carte2Joueur);
	b2.add(carte2);
	
	JInternalFrame carte3 = new JInternalFrame(); 
	carte3.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte3.setTitle("Carte 3");
	carte3.setVisible(true);//On la rend visible

	
	carte3Joueur.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez choisi la troisième carte");
			//TODO
		}
	});
	carte3.add(carte3Joueur);
	b2.add(carte3);
	
	JInternalFrame carte4 = new JInternalFrame(); 
	carte4.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte4.setTitle("Carte 4");
	carte4.setVisible(true);//On la rend visible
	
	
	carte4Joueur.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez choisi la quatrième carte");
			//TODO
		}
	});
	carte4.add(carte4Joueur);
	b2.add(carte4);
	
	JInternalFrame carte5 = new JInternalFrame(); 
	carte5.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	carte5.setTitle("Carte 5");
	carte5.setVisible(true);//On la rend visible
	
	
	carte5Joueur.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez choisi la cinquième carte");
			//TODO
		}
	});
	carte5.add(carte5Joueur);
	b2.add(carte5);
	
    //Idem
    Box b3 = Box.createHorizontalBox();
    
    JInternalFrame talon = new JInternalFrame(); 
    talon.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	talon.setTitle("Talon");
	talon.setVisible(true);//On la rend visible
	
	
	talonBouton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez pioché dans le talon");
			//TODO
		}
	});
	talon.add(talonBouton);
	b3.add(talon);
	
	///////
	JInternalFrame defausse = new JInternalFrame(); 
	defausse.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	defausse.setTitle("Defausse");
	defausse.setVisible(true);//On la rend visible
	
	
	defausseBouton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			eventLabel.setText("Vous avez pioché dans la défausse");
			//TODO
		}
	});
	defausse.add(defausseBouton);
	b3.add(defausse);
	
	//////
	JInternalFrame evenement = new JInternalFrame(); 
	eventLabel.setForeground(Color.BLUE);
	evenement.setSize(30, 20);//On lui donne une taille pour qu'on puisse la voir
	evenement.setTitle("Evenements");
	evenement.setVisible(true);//On la rend visible
	evenement.add(eventLabel);
	b3.add(evenement);
    
    
    //On crée un conteneur avec gestion verticale
    Box b4 = Box.createVerticalBox();
    b4.add(b1);
    b4.add(b2);
    b4.add(b3);

    this.getContentPane().add(b4);
    this.setVisible(true);
  }	
}