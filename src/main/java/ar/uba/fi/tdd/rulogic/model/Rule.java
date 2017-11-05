package ar.uba.fi.tdd.rulogic.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rule extends Function {

	private List<Query> objectives;

	public Rule(String definition, List<String> parameters, List<Query> objectives) {
		super(definition, parameters);
		this.objectives = objectives;
	}

	public List<Query> generateObjectives(List<String> parameters) {
		if (parameters.size() != this.parameters.size()) {
			throw new IllegalArgumentException("invalidNumberOfParametersForRule");
		}
		Map<String, String> parameterMap = new HashMap<>();
		for (int i = 0; i < parameters.size(); i++) {
			parameterMap.put(this.parameters.get(i), parameters.get(i));
		}
		return objectives.stream().map(objective -> objective.generateQuery(parameterMap)).collect(Collectors.toList());
	}

}
