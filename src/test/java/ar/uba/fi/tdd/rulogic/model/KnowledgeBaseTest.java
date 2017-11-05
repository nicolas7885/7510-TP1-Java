package ar.uba.fi.tdd.rulogic.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class KnowledgeBaseTest {

	private KnowledgeBase knowledgeBase;

	@Before
	public void setUp() throws Exception {
		knowledgeBase = new KnowledgeBase("src/main/resources/rules.db");
	}

	@Test
	public void testQueryCorrectFact() {
		Assert.assertTrue(this.knowledgeBase.answer("varon (nicolas)."));
	}

	@Test
	public void testQueryNoFact() {
		Assert.assertFalse(this.knowledgeBase.answer("varon (javier)."));
	}

	@Test
	public void testQueryCorrectRule() {
		Assert.assertTrue(this.knowledgeBase.answer("hijo (pepe, juan)."));
	}

	@Test
	public void testQueryInorrectRule() {
		Assert.assertFalse(this.knowledgeBase.answer("hijo (juan, juan)."));
	}
}
