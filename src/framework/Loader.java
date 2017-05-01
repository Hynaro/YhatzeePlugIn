package framework;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Loader {
	public static ArrayList<IDescription> ListeDescriptionsPlugins;
	
		public Loader() {}
		
		public Object getPlugin(IDescription desc) throws Exception, Exception{
			System.out.println(desc.getClassName());
			Class<?> cl = Class.forName((String) desc.getClassName());
			Object ob = cl.newInstance();
			return ob;
			}
		
		
		
		public ArrayList<IDescription> GetDescriptions() throws IOException{
			Properties p = new Properties();
			ArrayList<IDescription> listeRetour = new ArrayList<IDescription>();
			File repo;
			Description desc = new Description();
			File[] fileFound;
			repo = new File(System.getProperty("user.dir"));
			fileFound = repo.listFiles();
			for (File fichier : fileFound) {
				if (fichier.getName().contains("Plugin_")){
					p.load(new FileReader(fichier));
					desc.setClassName(p.getProperty("class"));
					desc.setConstraint(p.getProperty("interface"));
					desc.setName(p.getProperty("nom"));
					listeRetour.add(desc);
				}
		    }
			ListeDescriptionsPlugins = listeRetour;
			return listeRetour;
		}
		
		public ArrayList<IDescription> GetDescFor(Class<?> contrainte) throws IOException, ClassNotFoundException{
			ArrayList<IDescription> listeRetour = new ArrayList<IDescription>();
			for(IDescription d: ListeDescriptionsPlugins){
				Class<?> cl = Class.forName(d.getConstraint());
				try {contrainte.isAssignableFrom(cl);}
				catch (Exception e){
					System.out.println("ça marche pas");
				}
				System.out.println(cl.getName());
				listeRetour.add(d);
			}
			return listeRetour;
		}

}

