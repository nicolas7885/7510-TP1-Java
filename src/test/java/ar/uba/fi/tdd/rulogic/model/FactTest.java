package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactTest {

	@Test
	public void testValidateCorrectFact() {
		assert (Fact.validate("varon (javier)"));
		assert (Fact.validate("varon(javier)"));
		assert (Fact.validate("varon (javier)."));
	}

	@Test
	public void testValidateIncorrectFact() {
		assertFalse(Fact.validate("varon javier)"));
		assertFalse(Fact.validate("varon(javier"));
		assertFalse(Fact.validate("varon javier"));
		assertFalse(Fact.validate("varon ()"));
		assertFalse(Fact.validate("(javier)"));
		assertFalse(Fact.validate("avier)"));
		assertFalse(Fact.validate("(avier"));
	}

	@Test
	public void testValidateCorrectMultipleParamFact() {
		assert (Fact.validate("varon (javier, lucia)"));
		assert (Fact.validate("varon (javier, lucia, julio)"));
	}

	@Test
	public void testValidateIncorrectMultipleParamFact() {
		assertFalse(Fact.validate("varon (javier lucia)"));
		assertFalse(Fact.validate("varon (javier, lucia julio)"));
		assertFalse(Fact.validate("varon javier, lucia)"));
		assertFalse(Fact.validate("varon (javier, lucia"));
	}
}
