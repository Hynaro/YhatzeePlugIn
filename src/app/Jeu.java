package app;

import framework.Loader;

//import java.util.ArrayList;

import framework.IDescription;

public class Jeu {	
	public static void main(String[] args) throws Exception {
		Loader l = Loader.getInstance();
//		ArrayList<IDescription> descriptions = l.loadDescriptions();
		
		// Load the Afficheur
		IDescription descAfficheur = l.getDescForPlugin(IAfficheur.class).get(0);
		IAfficheur afficheur = (IAfficheur) l.getPluginForDesc(descAfficheur);
	}
}
