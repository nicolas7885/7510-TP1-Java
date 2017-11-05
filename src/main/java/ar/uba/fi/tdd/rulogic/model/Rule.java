package ar.uba.fi.tdd.rulogic.model;

import java.util.List;

public class Rule extends Function {

	public Rule(String definition, List<String> parameters, List<Fact> objectives) {
		super(definition, parameters);
	}

}
