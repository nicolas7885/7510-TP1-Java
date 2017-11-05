package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class FactTest {

	@Test
	public void testValidFact() {
		Fact fact = new Fact("varon", new String[] {"javier"});
		assert (fact.answer("javier"));
	}
	
	@Test
	public void testinvalidFact() {
		Fact fact = new Fact("varon", new String[] {"javier"});
		assertFalse (fact.answer("pedro"));
	}

	@Test
	public void testMultipleValidFacts() {
		Fact fact = new Fact("varon", new String[] {"javier", "lucia"});
		assert (fact.answer(new String[]{"javier", "lucia"}));
	}
	
	@Test
	public void testMultipleFactsOneWrong() {
		Fact fact = new Fact("varon", new String[] {"javier", "lucia"});
		assertFalse (fact.answer(new String[]{"javier", "lucio"}));
	}
}
