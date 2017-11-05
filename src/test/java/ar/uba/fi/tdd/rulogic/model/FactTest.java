package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FactTest {

	@Test
	public void testValidFact() {
		Fact fact = Parser.createImplication("varon (javier)");
		assert (fact.answer("javier"));
	}
	
	@Test
	public void testinvalidFact() {
		Fact fact = Parser.createImplication("varon (javier)");
		assertFalse (fact.answer("pedro"));
	}

	@Test
	public void testMultipleValidFacts() {
		Fact fact = Parser.createImplication("varon (javier, lucia)");
		assert (fact.answer(new String[]{"javier", "lucia"}));
	}
	
	@Test
	public void testMultipleFactsOneWrong() {
		Fact fact = Parser.createImplication("varon (javier, lucia)");
		assertFalse (fact.answer(new String[]{"javier", "lucio"}));
	}
}
