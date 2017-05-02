package app;

public interface IJetDeDes {
	
	/**
	 * Set the number of dices that is used in the game
	 * @param nombreDeDes
	 */
	public void setNombreDeDes(int nombreDeDes); 
	/**
	 * Set the number of faces of the each dices
	 * @param nombreDeFaces
	 */
	public void setNombreDeFaces(int nombreDeFaces);
	/**
	 * Generate random integers between 1 and the maximum dice's faces, for the number of dices in the game
	 * @return the result of the roll of dices
	 */
	int[] jeter();
}
