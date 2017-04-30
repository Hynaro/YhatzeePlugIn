package tiers;

import app.IEvaluateur;

public class EvaluateurDefault implements IEvaluateur {
	
	public int calculate(String type, int[] resultDices){
		int result = 0;
		if(type.contains("total")){
			int askedNumber = Integer.parseInt(type.split(" ")[1]);
			result = this.totalSameNumber(askedNumber, resultDices);
		}
		return result;
	}
	
	// Returns the sum of all the dices at the specified int
	public int totalSameNumber(int askedNumber, int[] resultDices){
		int sumSame = 0;
		for(int i : resultDices)
			if(i == askedNumber)
				sumSame += askedNumber;
		return sumSame;
	}
	
	public int full(int[] resultDices){
		return 0;
	}
	
	public int brelan(int[] resultDices){
		return 0;
	}
	
	public int chance(int[] resultDices){
		return 0;
	}
	
	public int petiteSuite(int[] resultDices){
		return 0;
	}
	
	public int grandeSuite(int[] resultDices){
		return 0;
	}
	
	public int yams(int[] resultDices){
		return 0;
	}

}
