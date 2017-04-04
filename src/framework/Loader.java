package framework;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

public class Loader {
	
	
	Object loadBean() throws Exception, Exception{
		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		// charger la classe
		Class<?> cl = Class.forName((String) p.get("Class"));

		//creer instance
		Object ob = cl.newInstance();

		//pour chaque clé appeler setter
		for (Object key : p.keySet()){
			if(!key.equals("class")){
				Method setter  = cl.getMethod("set" + key,String.class);
				setter.invoke(ob,p.get(key));
			}
		}
		return ob;
	}
	
		public static Object getPlugin(Class<?> contrainte) throws Exception, Exception{
			Properties p = new Properties();
			p.load(new FileReader("config.txt"));
			// charger la classe
			Class<?> cl = Class.forName((String) p.get("Class"));
			//Vérifier si la classe retournée est conforme à la contrainte
			try {contrainte.isAssignableFrom(cl);}
					catch (Exception e){
						System.out.println("ça marche pas");
					}
			//creer instance
			Object ob = cl.newInstance();
			return ob;
			}
		
		public List<IDescription> GetDescForPlugin(){
			return null;
		}
			
}

