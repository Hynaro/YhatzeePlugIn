package app;

import framework.Loader;
import framework.IDescription;

import java.io.IOException;
import java.util.ArrayList;

public class Jeu {	
	
	private static Jeu instance = new Jeu();
	private int[] resultatDes;
	private ArrayList<ILigne> lignes;
	private IAfficheur afficheur;
	
	
	
	public Jeu() {
		this.lignes = new ArrayList<ILigne>();
	}

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
	
	public void startGame() throws Exception{
		Loader loader = Loader.getInstance();
//		ArrayList<IDescription> descriptions = l.loadDescriptions();
		
		// Load the Afficheur
		IDescription descAfficheur = loader.getDescForPlugin(IAfficheur.class).get(0);
		this.afficheur = (IAfficheur) loader.getPluginForDesc(descAfficheur);
		
		//Load the Lines
		ArrayList<IDescription> descLignes = loader.getDescForPlugin(ILigne.class);
		for(IDescription descLigne : descLignes){
			ILigne ligne = (ILigne) loader.getPluginForDesc(descLigne);
			this.lignes.add(ligne);
			this.afficheur.addLine(ligne.getNom());
		}
		
	}
	
	public void rollDicesButtonPressed(){
		Loader l = Loader.getInstance();
		System.out.println("Button pressed");
		// Load the JetDeDes
		try {
			IDescription descJetDeDes = l.getDescForPlugin(IJetDeDes.class).get(0);
			IJetDeDes jetdeDes = (IJetDeDes) l.getPluginForDesc(descJetDeDes);
//			System.out.println("Jet de des : " + jetdeDes.jeter()[0]);
			this.resultatDes = jetdeDes.jeter();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		this.afficheur.setAffichageResultatDes(this.resultatDes);
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
	
	
	
}
