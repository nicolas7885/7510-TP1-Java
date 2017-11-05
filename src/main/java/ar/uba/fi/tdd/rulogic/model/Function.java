package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Function {

	protected String definition;
	protected List<String> parameters;

	Function (String definition, String[] parameters){
		this.definition = definition;
		if(parameters.length < 1) throw new IllegalArgumentException();
		this.parameters = new ArrayList<String>(Arrays.asList(parameters));
	}

	public Function(String definition, List<String> parameters) {
		this.definition = definition;
		if(parameters.size() < 1) throw new IllegalArgumentException();
		this.parameters = parameters;
	}

	public String getDefinition() {
		return definition;
	}

}