package app;

public interface IAfficheur {
	
	/**
	 * Destroy the GUI.
	 */
	public void shutdown();
	/**
	 * Display the result of the roll of dices in the GUI
	 * @param resultats
	 */
	public void setAffichageResultatDes(int[] resultats);
	/**
	 * Display the score in the GUI.
	 * @param score
	 */
	public void setAffichageScore(int score);
	/**
	 * Display a message in the GUI.
	 * @param message
	 */
	public void setAffichageMessage(String message);
	/** Add a new button to the GUI corresponding to the line.
	 * @param ligne
	 */
	public void addLine(ILigne ligne);
}
