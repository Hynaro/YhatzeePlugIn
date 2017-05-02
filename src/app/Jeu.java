package app;

import framework.Loader;
import framework.IDescription;

import java.io.IOException;
import java.util.ArrayList;

public class Jeu {	
	
	private static Jeu instance = new Jeu();
	private int[] resultatDes;
	private int score;
	private boolean dejaJoue;
	private ArrayList<ILigne> lignes;
	private IAfficheur afficheur;
	private int tour;
	
	public Jeu() {}

	public static Jeu getInstance(){
		return instance;
	}
	
	public static void main(String[] args) {
		try {
			Jeu.getInstance().startGame();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	 * Start the game, and load the plugin
	 * @throws Exception
	 */
	public void startGame() throws Exception{
		this.lignes = new ArrayList<ILigne>();
		this.score = 0;
		this.tour = 0;
		this.dejaJoue = true; // must be true to roll the dices a first time
		
		Loader loader = Loader.getInstance();
		
		// Destroy the Afficheur if it exists
		if(this.afficheur != null){
			this.afficheur.shutdown();
		}
		// Load the Afficheur
		IDescription descAfficheur = loader.getDescForPlugin(IAfficheur.class).get(0);
		this.afficheur = (IAfficheur) loader.getPluginForDesc(descAfficheur);
		
		//Load the Lines
		ArrayList<IDescription> descLignes = loader.getDescForPlugin(ILigne.class);
		for(IDescription descLigne : descLignes){
			ILigne ligne = (ILigne) loader.getPluginForDesc(descLigne);
			this.lignes.add(ligne);
			this.afficheur.addLine(ligne);
		}
		System.out.println("New game started");
	}
	
	/**
	 * Save the result of the roll of dice, and display in the GUI. Check if the dices has not already been rolled, otherwise it displays an error message in the GUI.
	 */
	public void rollDicesButtonPressed(){
		if(this.dejaJoue == true){			
			// record the player has to play
			this.dejaJoue = false;
			
			Loader l = Loader.getInstance();
			System.out.println("The player roll the dices.");
			// Load the JetDeDes
			try {
				IDescription descJetDeDes = l.getDescForPlugin(IJetDeDes.class).get(0);
				IJetDeDes jetdeDes = (IJetDeDes) l.getPluginForDesc(descJetDeDes);
				this.resultatDes = jetdeDes.jeter();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			// updating the view
			this.afficheur.setAffichageResultatDes(this.resultatDes);
		} else {
			System.out.println("ERROR : the player hasn't played yet.");
			// updating the view
			this.afficheur.setAffichageMessage("Vous n'avez pas encore joue ce tour. Cochez une ligne.");
		}
	}
	
	/**
	 * Calculate the score depending of the results of the dices and the chosen line
	 * @param ligne, the chosen line
	 */
	public void lineButtonPressed(ILigne ligne){
		// check that the player hasn't already played the round
		if(dejaJoue == false){			
			// check if the Ligne is not already checked
			if(this.isLigneCoche(ligne, this.lignes) == false){
				System.out.println("The player choose the line : " + ligne.getType());
				
				Loader l = Loader.getInstance();			
				System.out.println("Button to roll dices pressed");
				// Load the Evaluateur
				try {
					// calculating the score
					IDescription descEvaluateur = l.getDescForPlugin(IEvaluateur.class).get(0);
					IEvaluateur evaluateur = (IEvaluateur) l.getPluginForDesc(descEvaluateur);
					int points = evaluateur.calculate(ligne.getType(), this.resultatDes);
					this.score += points;
					// checking the Ligne
					this.cocheLigne(ligne, true);
					// record the player played this round
					this.dejaJoue = true;
					// updating the view
					this.afficheur.setAffichageScore(this.score);
					this.afficheur.setAffichageMessage("Vous avez marque : " + points + " points.");
					// increment the round, and check if it was the last
					this.tour++;
					if(this.tour >= this.lignes.size())
						this.afficheur.setAffichageMessage(	
								"Vous avez marque : " + points + " points.\n" + 
								"Vous avew termine la partie, votre score est de " + this.score + " points."
						);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				System.out.println("ERROR : the line has already been used.");
				// updating the view
				this.afficheur.setAffichageMessage("La ligne a deja ete selectionnee.");
			}
		}
		else{
			System.out.println("ERROR : the player already played.");
			// updating the view
			this.afficheur.setAffichageMessage("Vous avez deja joue pour ce tour. Relancez les des.");			
		}
	}
	
	/**
	 * Find the line in the array and check if it is checked
	 * @param ligne 
	 * @param lignes
	 * @return
	 */
	public boolean isLigneCoche(ILigne ligne, ArrayList<ILigne> lignes){
		for(ILigne l : lignes)
			// the type is used to identify the Ligne
			if(ligne.equals(l))
				return ligne.isCoche();
		// if not found
		System.out.println("Ligne not found.");
		return false;
	}
	
	/**
	 * Check or uncheck the line.
	 * @param ligne
	 * @param value
	 */
	public void cocheLigne(ILigne ligne, boolean value){
		int index = this.lignes.indexOf(ligne);
		this.lignes.get(index).setCoche(value);
	}

	public int[] getResultatDes() {
		return resultatDes;
	}

	public void setResultatDes(int[] resultatDes) {
		this.resultatDes = resultatDes;
	}

	public ArrayList<ILigne> getLignes() {
		return lignes;
	}

	public void setLignes(ArrayList<ILigne> lignes) {
		this.lignes = lignes;
	}

	public IAfficheur getAfficheur() {
		return afficheur;
	}

	public void setAfficheur(IAfficheur afficheur) {
		this.afficheur = afficheur;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
