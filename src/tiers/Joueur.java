package tiers;

public class Joueur {
	
	String nom;
	int highscore;
	int partieGagnees;
	int partiePerdues;
	
	public Joueur(String nom) {
		super();
		this.nom = nom;
		this.highscore = 0;
		this.partieGagnees = 0;
		this.partiePerdues = 0;
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
