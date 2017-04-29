package framework;

import java.util.HashMap;

public interface IDescription {

	public String getClassName();
	public void setClassName(String className);
	public String getConstraint();
	public void setConstraint(String constraint);
	public HashMap<String, String> getProperties();
	public String getProperty(String key);
	public void addProperty(String key, String value);
}
