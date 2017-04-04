package plateforme;

import java.util.Map;

public class Description implements IDescription{

	private String ClassName;
	private String Constraint;
	private Map<String,String> properties;
	private String name;
	private String text;
	
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

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public Map<String, String> getProperties() {
		// TODO Auto-generated method stub
		return properties;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}
	
}
