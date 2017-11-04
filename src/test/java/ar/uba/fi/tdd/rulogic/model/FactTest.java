package ar.uba.fi.tdd.rulogic.model;

import org.junit.Test;

public class FactTest {

	@Test
	public void testValidFact() {
		Fact fact = Parser.create("varon (javier)");
		assert (fact.answer("javier"));
	}

}
