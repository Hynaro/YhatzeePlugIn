package tiers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import app.IEvaluateur;

public class EvaluateurDefault implements IEvaluateur {
	
	private static int nbYams;
	
	public int calculate(String type, int[] resultDices){
		int result = 0;
		if(type.contains("total")){
			int askedNumber = Integer.parseInt(type.split(" ")[1]);
			result = this.totalSameNumber(askedNumber, resultDices);
		}
		else
		{
			Method method;
			try {
				method = EvaluateurDefault.class.getDeclaredMethod(type,resultDices.getClass());
				try {
					result = (int) method.invoke(this,resultDices);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			}
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
	
	// return full score
	public int full(int[] resultDices){
		return 25;
	}
	
	// return brelan score
	public int brelan(int[] resultDices){
		int sumSame = 0;
		for(int i : resultDices)
				sumSame += i;
		return sumSame;
	}
	
	public int carre(int[] resultDices){
		int sumSame = 0;
		for(int i : resultDices)
				sumSame += i;
		return sumSame;
	}
	
	//retrun chance score, means the sum of all dices
	public int chance(int[] resultDices){
		return brelan(resultDices);
	}
	
	// return petite suite score
	public int petiteSuite(int[] resultDices){
		return 30;
	}
	
	// return grande suite score
	public int grandeSuite(int[] resultDices){
		return 40;
	}
	
	// return yams score
	public int yams(int[] resultDices){
		nbYams++;
		if (nbYams < 1){
			return 50;	
		}
		else{
			return 100;
		}
	}

}
