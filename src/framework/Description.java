package framework;

import java.util.HashMap;
import java.util.Map;

public class Description implements IDescription{

	private String ClassName;
	private String Constraint;
	private HashMap<String,String> properties;
	private String name;
	
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getConstraint() {
		return Constraint;
	}
	public void setConstraint(String constraint) {
		Constraint = constraint;
	}
	public HashMap<String, String> getProperties() {
		return properties;
	}
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Description(String className, String constraint, String name) {
		ClassName = className;
		Constraint = constraint;
		this.name = name;
		this.properties = new HashMap<String, String>();
	}
	public Description() {
		super();
	}
	
	
}
