package app;

public interface IAfficheur {
	
	public void setAffichageResultatDes(int[] resultats);
	public void setAffichageScore(int score);
	public void setAffichageMessage(String message);
	public void addLine(ILigne ligne);
}
