package app;

public interface ILigne {
	
	public String getType();
	public void setType(String type);
	public String getNom();
	public void setNom(String nom);
	public void setCoche(boolean value);
	public boolean isCoche();
	public String toString();
	public boolean equals(Object obj);
}
