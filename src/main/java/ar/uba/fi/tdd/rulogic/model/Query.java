package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Query extends Function {

	public Query(String definition, String[] parameters) {
		super(definition, parameters);
	}

	public Query(String definition, List<String> parameters) {
		super(definition, parameters);
	}

	public List<String> getParameters() {
		return parameters;
	}

	public Query generateQuery(Map<String, String> parameterMap) {
		List<String> newParameters = new ArrayList<>();
		for (String parameter : parameters) {
			newParameters.add(parameterMap.get(parameter));
		}
		return new Query(this.definition, newParameters);
	}
}
