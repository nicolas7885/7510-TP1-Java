package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactTest {

	@Test
	public void testValidateCorrectFact() {
		//given
		String fact = "varon (javier)";
		//when
		boolean result = Fact.validate(fact);
		//then
		assert(result);
	}
	
	@Test
	public void testTemplate() {
		//given
		String fact = "varon (javier)";
		//when
		boolean result = Fact.validate(fact);
		//then
		assert(result);
	}

}
