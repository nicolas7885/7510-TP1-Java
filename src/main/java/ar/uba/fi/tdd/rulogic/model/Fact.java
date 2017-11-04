package ar.uba.fi.tdd.rulogic.model;

import java.util.Arrays;
import java.util.List;

public class Fact {
	String definition;
	List<String> values;
	
	Fact (String definition, String[] values){
		this.definition = definition;
		if(values.length < 1) throw new IllegalArgumentException();
		this.values = Arrays.asList(values);
	}

	public boolean answer(String query) {
		return values.contains(query);
	}
	
	public boolean answer(String[] queries) {
		boolean result= true;
		if(queries.length != values.size()) return false;
		for(int i = 0; result && i < queries.length; i++){
			String query = queries[i];
			result = query.equals(values.get(i));
		}
		return result;
	}
}
