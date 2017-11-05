package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;

public class Fact extends Function {
	Fact (String definition, String[] values){
		super(definition,values);
	}

	public boolean answer(String parameter) {
		return parameters.contains(parameter);
	}

	public boolean answer(String[] parameters) {
		return answer(Arrays.asList(parameters));
	}

	public boolean answer(List<String> parameters) {
		boolean result= true;
		if(parameters.size() != this.parameters.size()) return false;
		for(int i = 0; result && i < parameters.size(); i++){
			String query = parameters.get(i);
			result = query.equals(this.parameters.get(i));
		}
		return result;
	}
}
