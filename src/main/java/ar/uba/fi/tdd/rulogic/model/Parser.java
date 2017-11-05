package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//fact, rules and query factory
public class Parser {
	private static final String INVALID_PARAMETER_DELIMETER = "invalidParameterDelimeter";
	private static final String RULE_DELIMETER = ":-";
	protected final static Pattern FACT_PATTERN = Pattern.compile("(\\w+)[ \\t]*(\\(\\s*([\\w\\s,$]+)\\s*\\))");

	public static boolean validate(String implicacion) {
		if (implicacion.contains(":") || implicacion.contains("-")) {
			return validateRule(implicacion);
		} else {
			return validateFact(implicacion);
		}
	}

	private static boolean validateRule(String rule) {
		String[] separatedRule = rule.split(RULE_DELIMETER);
		if (separatedRule.length != 2) return false;
		String definition = separatedRule[0];
		boolean valid = validateFact(definition);
		Matcher objectiveMatcher = FACT_PATTERN.matcher(separatedRule[1]);
		while (valid && objectiveMatcher.find()){
			valid = valid && validateFact(objectiveMatcher.group());
		}
		return valid;
	}

	private static boolean validateFact(String fact) {
		Matcher matcher = FACT_PATTERN.matcher(fact);
		if (!matcher.find())
			return false;
		String rawParameters = matcher.group(3);
		List<String> parameters = Arrays.asList(rawParameters.split("[,\\s]+"));
		parameters = parameters.stream()
				.filter(s -> !s.isEmpty())
				.collect(Collectors.toList());
		return rawParameters.split(",").length == parameters.size();
	}

	public static Fact createFact(String fact) {
		Matcher matcher = matchFact(fact);
		List<String> parameters = extractParameters(matcher);
		return new Fact(matcher.group(1), parameters.toArray(new String[parameters.size()]));
	}

	private static Matcher matchFact(String fact) {
		if(!validate(fact)) throw new IllegalArgumentException();
		Matcher matcher = FACT_PATTERN.matcher(fact);
		if (!matcher.find())
			throw new RuntimeException("invalidFact");
		return matcher;
	}

	private static List<String> extractParameters(Matcher matcher) {
		String rawParameters = matcher.group(3);
		List<String> parameters = Arrays.asList(rawParameters.split("[,\\s]+"));
		parameters = parameters.stream()
				.filter(s -> !s.isEmpty())
				.collect(Collectors.toList());
		if(rawParameters.split(",").length  != parameters.size())
			throw new IllegalArgumentException(INVALID_PARAMETER_DELIMETER);
		return parameters;
	}

	public static Query createQuery(String query) {
		Matcher matcher = matchFact(query);
		List<String> parameters = extractParameters(matcher);
		return new Query(matcher.group(1), parameters.toArray(new String[parameters.size()]));
	}

	public static Rule createRule(String ruleString) {
		String[] separatedRule = ruleString.split(RULE_DELIMETER);
		if (separatedRule.length != 2) throw new IllegalArgumentException("invalidRuleDelimeter");
		Matcher definitionMatcher = matchFact(separatedRule[0]);
		List<String> parameters = extractParameters(definitionMatcher);
		Matcher objectiveMatcher = FACT_PATTERN.matcher(separatedRule[1]);
		List<Fact> objectives = new ArrayList<>();
		while (objectiveMatcher.find()){
			objectives.add(createFact(objectiveMatcher.group()));
		}
		return new Rule(definitionMatcher.group(1),parameters, objectives);
	}
}
