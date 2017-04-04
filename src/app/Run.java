package app;

import framework.Loader;

public class Run {
	static Loader l;
	static IAfficheur aff;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		aff = (IAfficheur) Loader.getPlugin(IAfficheur.class);
	}
}
