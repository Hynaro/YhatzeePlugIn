package app;

import framework.Loader;

//import java.util.ArrayList;

import framework.IDescription;

public class Jeu {	
	public static void main(String[] args) throws Exception {
		Loader l = new Loader();;
//		ArrayList<IDescription> descriptions = l.loadDescriptions();
		
		// Load the Afficheur
		IDescription descAffiheur = l.getDescForPlugin(IAfficheur.class).get(0);
		IAfficheur afficheur = (IAfficheur) l.getPluginForDesc(descAffiheur);
	}
}
