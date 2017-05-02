package app;

public interface IEvaluateur {
	
	/**
	 * 
	 * @param type, the type of the line
	 * @param resultDices
	 * @return the score made
	 */
	public int calculate(String type, int[] resultDices);

}
