package framework;

import java.util.HashMap;
import java.util.Map;

public class Description implements IDescription{

	private String className;
	private String constraint;
	private HashMap<String,String> properties;
	private String name;
	
	public Description(String className, String constraint, String name) {
		this.className = className;
		this.constraint = constraint;
		this.name = name;
		this.properties = new HashMap<String, String>();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getConstraint() {
		return constraint;
	}

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}

	public HashMap<String, String> getProperties() {
		return properties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Description [className=" + className + ", constraint=" + constraint + ", properties=" + properties
				+ ", name=" + name + "]";
	}
	
	
}
