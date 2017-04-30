package framework;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import app.*;
import framework.IDescription;

public class Loader {
	
		private static Loader instance = new Loader();
		private ArrayList<IDescription> listDescriptionPlugin;
	
		private Loader() {}
		
		public static Loader getInstance(){
			return instance;
		}
		
		// read all the plugin descriptions that are in the corresponding files, and returns an ArrayList of Description objects
		public ArrayList<IDescription> loadDescriptions() throws IOException{
			ArrayList<IDescription> listeRetour = new ArrayList<IDescription>();
			// path to the plugins text files folder
			File pluginFolder = new File(System.getProperty("user.dir") + File.separator + "plugins");
			File[] pluginFileList = pluginFolder.listFiles();
			
			// browse all the files in the plugins folder
			for (File file : pluginFileList) {
				if (file.getName().contains("Plugin_")){
					Properties p = new Properties();
					p.load(new FileReader(file));
					
					String className = p.getProperty("class");
					String constraint = p.getProperty("interface");
					Description description = new Description(className, constraint);
					// load all the other properties found in the file, into the Description hashmap of tproperties
					for(Object key : p.keySet()){
						if(!key.equals("class") && !key.equals("interface")){
							description.addProperty(key+"", p.getProperty(key+""));
						}
					}
//					System.out.println(" description " + description.toString());
					listeRetour.add(description);
				}
		    }
			return listeRetour;
		}	
		
		public ArrayList<IDescription> getDescForPlugin(Class<?> constraint) throws IOException{
			ArrayList<IDescription> inputList = this.loadDescriptions();
			ArrayList<IDescription> outputList = new ArrayList<IDescription>();
//			System.out.println("inputList : " + inputList.size());
//			System.out.println("constraint : " + constraint.getName());
			for(IDescription description : inputList){
//				System.out.println("description.getConstraint() : " + description.getConstraint());
				if(description.getConstraint().equals(constraint.getName())){
					outputList.add(description);
				}
			}
//			System.out.println("outputList : " + outputList.size());
			return outputList;
			
		}
		
		/**
		 * Chargement de l'extension.
		 * @param desc
		 * @return
		 */
		public Object getPluginForDesc (IDescription desc) throws Exception{
			// get the class from the Description
			Class<?> cl = Class.forName(desc.getClassName());
			// create an instance from the class
			Object o = cl.newInstance();
			// configure the instance
			if(IAfficheur.class.isAssignableFrom(cl)){
				Method setTitre = cl.getMethod("setTitre", String.class);
				setTitre.invoke(o, desc.getProperty("titre"));
			} else if(IJetDeDes.class.isAssignableFrom(cl)) {
				Method setNombreDeDes = cl.getMethod("setNombreDeDes", int.class);
				setNombreDeDes.invoke(o, Integer.parseInt(desc.getProperty("nombreDeDes")));
			} else if(ILigne.class.isAssignableFrom(cl)){
				Method setNom = cl.getMethod("setNom", String.class);
				setNom.invoke(o, desc.getProperty("nom"));
				Method setType = cl.getMethod("setType", String.class);
				setType.invoke(o, desc.getProperty("type"));
			}
//			
			return o;
		}
}

