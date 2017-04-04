package framework;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

public class Loader {
	
	
/*	Object loadBean() throws Exception, Exception{
		Properties p = new Properties();
		p.load(new FileReader("config.txt"));
		// charger la classe
		Class<?> cl = Class.forName((String) p.get("Class"));

		//creer instance
		Object ob = cl.newInstance();

		//pour chaque cl� appeler setter
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
			//V�rifier si la classe retourn�e est conforme � la contrainte
			try {contrainte.isAssignableFrom(cl);}
					catch (Exception e){
						System.out.println("�a marche pas");
					}
			//creer instance
			Object ob = cl.newInstance();
			return ob;
			}*/
		
		public Loader() {
		// TODO Auto-generated constructor stub
	}

		public List<IDescription> GetDescForPlugin() throws IOException{
			
			Properties p = new Properties();
			p.load(new FileReader("config.txt"));
			System.out.println(p.toString() + " " + p.size());
			return null;
		}
			
}

