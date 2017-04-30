package tiers;

import java.util.Random;

import app.IJetDeDes;

public class JetDeDesDefault implements IJetDeDes{
	
	private int nombreDeDes;
	private int nombreDeFaces;

	
	public int getNombreDeDes() {
		return nombreDeDes;
	}

	public void setNombreDeDes(int nombreDeDes) {
		this.nombreDeDes = nombreDeDes;
	}


	public int getNombreDeFaces() {
		return nombreDeFaces;
	}


	public void setNombreDeFaces(int nombreDeFaces) {
		this.nombreDeFaces = nombreDeFaces;
	}


	@Override
	public int[] jeter() {
		int[] jet = new int[this.nombreDeDes];
		Random rand = new Random();
		for (int i = 0 ; i < jet.length ; i++){
			jet[i] = rand.nextInt(6) + 1;
		}
		return jet;
	}

}
