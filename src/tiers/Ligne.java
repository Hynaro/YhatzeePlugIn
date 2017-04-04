package tiers;

public class Ligne {

	String nom;
	int score;
	
	public Ligne() {

	}

	public Ligne(String nom, int score) {
		this.nom = nom;
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int calcul(){
		return 0;
	}
	
}
