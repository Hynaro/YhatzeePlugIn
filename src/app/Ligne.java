package app;

public class Ligne implements ILigne {

	String nom;
	String type;
	int score;
	boolean coche;
	
	public Ligne(String nom, int score, String type) {
		this.nom = nom;
		this.type = type;
		this.score = 0;
		this.coche = false;
	}

	public Ligne() {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	public String toString() {
		return "Ligne [nom=" + nom + ", type=" + type + ", score=" + score + ", coche=" + coche + "]";
	}
	
}
