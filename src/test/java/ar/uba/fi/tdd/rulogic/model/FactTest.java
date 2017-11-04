package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactTest {

	@Test
	public void testValidateCorrectFact() {
		boolean result = Fact.validate("varon (javier)");
		assert (result);
	}

	@Test
	public void testValidateIncorrectFact() {
		assertFalse(Fact.validate("varon javier)"));
		assertFalse(Fact.validate("varon (javier"));
		assertFalse(Fact.validate("varon javier"));
		assertFalse(Fact.validate("varon ()"));
		assertFalse(Fact.validate("(javier)"));
		assertFalse(Fact.validate("avier)"));
		assertFalse(Fact.validate("(avier"));
	}

	@Test
	public void testTemplate() {
		String fact = "varon (javier)";
		boolean result = Fact.validate(fact);
		assert (result);
	}

}
