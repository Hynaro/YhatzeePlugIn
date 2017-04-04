package appli;

public class Joueur implements IJoueur {
	
	String nom;
	int highscore;
	int partieGagnees;
	int partiePerdues;
	
	public Joueur(String nom, int highscore, int partieGagnees, int partiePerdues) {
		super();
		this.nom = nom;
		this.highscore = highscore;
		this.partieGagnees = partieGagnees;
		this.partiePerdues = partiePerdues;
	}
		
	public Joueur() {
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getHighscore() {
		return highscore;
	}
	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}
	public int getPartieGagnees() {
		return partieGagnees;
	}
	public void setPartieGagnees(int partieGagnees) {
		this.partieGagnees = partieGagnees;
	}
	public int getPartiePerdues() {
		return partiePerdues;
	}
	public void setPartiePerdues(int partiePerdues) {
		this.partiePerdues = partiePerdues;
	}
	

}
