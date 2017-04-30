package app;

public interface IEvaluateur {
	
	public int calculate(String type, int[] resultDices);

	// Returns the sum of all the dices at the specified int
	public int totalSameNumber(int askedNumber, int[] resultDices);
	
	public int full(int[] resultDices);
	
	public int brelan(int[] resultDices);
	
	public int chance(int[] resultDices);
	
	public int petiteSuite(int[] resultDices);
	
	public int grandeSuite(int[] resultDices);
	
	public int yams(int[] resultDices);
}
