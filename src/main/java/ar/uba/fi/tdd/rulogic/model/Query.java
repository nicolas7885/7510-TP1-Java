package ar.uba.fi.tdd.rulogic.model;

import java.util.List;

public class Query extends Function{

	public Query(String definition, String[] parameters) {
		super(definition, parameters);
	}

	public List<String> getParameters() {
		return parameters;
	}
}
