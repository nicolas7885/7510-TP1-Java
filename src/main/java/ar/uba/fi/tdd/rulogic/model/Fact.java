package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fact {
	private String definition;
	private List<String> values;
	
	Fact (String definition, String[] values){
		this.definition = definition;
		if(values.length < 1) throw new IllegalArgumentException();
		this.values = new ArrayList<String>(Arrays.asList(values));
	}

	public boolean answer(String parameter) {
		return values.contains(parameter);
	}
	
	public boolean answer(String[] parameters) {
		boolean result= true;
		if(parameters.length != values.size()) return false;
		for(int i = 0; result && i < parameters.length; i++){
			String query = parameters[i];
			result = query.equals(values.get(i));
		}
		return result;
	}

	public String getDefinition() {
		return definition;
	}
}
