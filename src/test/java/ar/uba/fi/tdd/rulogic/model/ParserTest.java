package ar.uba.fi.tdd.rulogic.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testValidateCorrectFact() {
		assert (Parser.validate("varon (javier)"));
		assert (Parser.validate("varon(javier)"));
		assert (Parser.validate("varon (javier)."));
	}

	@Test
	public void testValidateIncorrectFact() {
		assertFalse(Parser.validate("varon javier)"));
		assertFalse(Parser.validate("varon(javier"));
		assertFalse(Parser.validate("varon javier"));
		assertFalse(Parser.validate("varon ()"));
		assertFalse(Parser.validate("(javier)"));
		assertFalse(Parser.validate("avier)"));
		assertFalse(Parser.validate("(avier"));
	}

	@Test
	public void testValidateCorrectMultipleParamFact() {
		assert (Parser.validate("varon (javier, lucia)"));
		assert (Parser.validate("varon (javier, lucia, julio)"));
	}

	@Test
	public void testValidateIncorrectMultipleParamFact() {
		assertFalse(Parser.validate("varon (javier lucia)"));
		assertFalse(Parser.validate("varon (javier, lucia julio)"));
		assertFalse(Parser.validate("varon javier, lucia)"));
		assertFalse(Parser.validate("varon (javier, lucia"));
	}
}
