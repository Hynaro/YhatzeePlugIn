package appli;

public class Ligne implements ILigne {

	String nom;
	int score;
	boolean coche;
	
	public Ligne(String nom, int score) {
		this.nom = nom;
		this.score = score;
		this.coche=false;
	}

	public Ligne() {

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
	
	public boolean isCoche() {
		return coche;
	}

	public void setCoche(boolean coche) {
		this.coche = coche;
	}
	
	@Override
	public int calcul(){
		return 0;
	}
	
}
