package ar.uba.fi.tdd.rulogic.model;

public class Query {
	private String definition;
	private String[] parameters;

	public Query(String definition, String[] parameters) {
		this.definition = definition;
		this.parameters = parameters;
	}

	public String getDefinition(){
		return definition;
	}

	public String[] getParameters() {
		return parameters;
	}
}
