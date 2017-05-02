package tiers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import app.IEvaluateur;
import app.IJetDeDes;
import framework.IDescription;
import framework.Loader;

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
	
	/**
	 * Returns the sum of all the dices with the specified number
	 * @param askedNumber
	 * @param resultDices
	 * @return
	 */
	public int totalSameNumber(int askedNumber, int[] resultDices){
		int sumSame = 0;
		for(int i : resultDices)
			if(i == askedNumber)
				sumSame += askedNumber;
		return sumSame;
	}
	
	/**
	 * Return full score.
	 * @param resultDices
	 * @return
	 */
	public int full(int[] resultDices){
		return 25;
	}
	
	/**
	 * Return brelan score.
	 * @param resultDices
	 * @return
	 */
	public int brelan(int[] resultDices){
		HashMap<Integer, Integer> occurences = this.countOccurences(resultDices);
		int maximumFace = 0;
		
		// Get the number of dice's faces
		Loader l = Loader.getInstance();
		int nombreDeFaces = 0;
		try {
			IDescription descJetDeDes = l.getDescForPlugin(IJetDeDes.class).get(0);
			IJetDeDes jetdeDes = (IJetDeDes) l.getPluginForDesc(descJetDeDes);
			nombreDeFaces = jetdeDes.getNombreDeFaces();
			System.out.println("nbface " + nombreDeFaces);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// find the faces which have at least 3 occurences, and the maximum value
		for(int i = 1; i <= nombreDeFaces; i++){
			if(occurences.get(i) >= 3){
				maximumFace = i;
			}
		}
		
		if(maximumFace != 0){
			return maximumFace*3;
		}
		else{
			return 0;
		}
		
	}
	
	/**
	 * Return the carre score.
	 * @param resultDices
	 * @return
	 */
	public int carre(int[] resultDices){
		int sumSame = 0;
		for(int i : resultDices)
				sumSame += i;
		return sumSame;
	}
	
	/**
	 * Return chance score, meaning the sum of all dices.
	 * @param resultDices
	 * @return
	 */
	public int chance(int[] resultDices){
		return brelan(resultDices);
	}
	
	/**
	 * Return petite suite score
	 * @param resultDices
	 * @return
	 */
	public int petiteSuite(int[] resultDices){
		return 30;
	}
	
	/**
	 * Return grande suite score
	 * @param resultDices
	 * @return
	 */
	public int grandeSuite(int[] resultDices){
		return 40;
	}
	
	/**
	 * Return yams score.
	 * @param resultDices
	 * @return
	 */
	public int yams(int[] resultDices){
		nbYams++;
		if (nbYams < 1){
			return 50;	
		}
		else{
			return 100;
		}
	}
	
	
	/**
	 * Count the occurences of every face's number.
	 * @param resultDices
	 * @return
	 */
	public HashMap<Integer, Integer> countOccurences(int[] resultDices){
		HashMap<Integer, Integer> occurences = new HashMap<Integer, Integer>();
		// Get the number of dice's faces
		Loader l = Loader.getInstance();
		int nombreDeFaces = 0;
		try {
			IDescription descJetDeDes = l.getDescForPlugin(IJetDeDes.class).get(0);
			IJetDeDes jetdeDes = (IJetDeDes) l.getPluginForDesc(descJetDeDes);
			nombreDeFaces = jetdeDes.getNombreDeFaces();
			System.out.println("nbface " + nombreDeFaces);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// initialize the occurences hashmap
		for(int i = 1; i <= nombreDeFaces; i++){
			occurences.put(i, 0);
		}
		// count the occurences
		for(int i = 0; i < resultDices.length; i++){
			int face = resultDices[i];
			System.out.println("face " + face);
			occurences.put(face, (occurences.get(face))+1);
		}
		return occurences;
	}

}
