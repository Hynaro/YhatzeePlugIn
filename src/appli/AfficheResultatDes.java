package appli;

import java.util.ArrayList;
import java.util.Random;

public class AfficheResultatDes implements IAfficheur {
	ArrayList<Integer> dices;
	int i; 
	Random rand = new Random();
	
	public AfficheResultatDes() {
		dices = new ArrayList<>();
	}


	@Override
	public void affiche(String s) {
	
		for (i = 0 ; i < 5 ; i++){
			dices.add(roll());
		}
		System.out.println(dices);	
		
	}

	
	public int roll(){
		
		return rand.nextInt(6) + 1;
	}
}
