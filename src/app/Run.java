package app;

import framework.Loader;

import java.util.ArrayList;

import framework.IDescription;

public class Run {	
	public static void main(String[] args) throws Exception {
		Loader l;
		IAfficheur aff;
		ArrayList<IDescription> descriptions;
		l = new Loader();
		descriptions = l.GetDescriptions();
		aff = (IAfficheur) l.getPlugin(descriptions.get(0));
	}
}
