package ar.uba.fi.tdd.rulogic.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fact {
	protected final static String FACT_STRING_REGEX = "(\\w+)[ \\t]*(\\(([\\w\\s,$]+)\\))";
	protected final static Pattern FACT_PATTERN = Pattern.compile(FACT_STRING_REGEX);

	public static boolean validate(String fact) {
		Matcher matcher = FACT_PATTERN.matcher(fact);
		return matcher.find();
	}

}
