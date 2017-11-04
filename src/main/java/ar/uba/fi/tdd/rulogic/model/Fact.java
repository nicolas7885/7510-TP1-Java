package ar.uba.fi.tdd.rulogic.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fact {
	protected final static Pattern FACT_PATTERN = Pattern.compile("(\\w+)[ \\t]*(\\(([\\w\\s,$]+)\\))");

	public static boolean validate(String fact) {
		boolean valid = true;
		Matcher matcher = FACT_PATTERN.matcher(fact);
		if(!matcher.find())
			return false;
		String rawParameters = matcher.group(3);
		if(rawParameters.contains(" ") && !rawParameters.contains(","))
			return false;
		if ( rawParameters.contains(" ") && rawParameters.contains(","))
			valid = rawParameters.split(",").length == rawParameters.split("\\s+").length;
		return valid;
	}

}
