package ar.uba.fi.tdd.rulogic.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnowledgeBase {

	private Map<String, List<Fact>> facts;
	private Map<String, Rule> rules;

	public KnowledgeBase(String path) throws FileNotFoundException, IOException {
		facts = new HashMap<>();
		rules = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				if (line.contains(":") || line.contains("-")) {
					this.learnRule(Parser.createRule(line));
				} else {
					this.learnFact(Parser.createFact(line));
				}

				line = br.readLine();
			}
		}
	}

	private void learnRule(Rule newRule) {
		rules.put(newRule.getDefinition(), newRule);
	}

	public boolean answer(String queryString) {
		Query query = Parser.createQuery(queryString);
		return answer(query);
	}

	private boolean answer(Query query) {
		String definition = query.getDefinition();
		if (facts.containsKey(definition)) {
			return facts.get(definition).stream().anyMatch(fact -> fact.answer(query.getParameters()));
		}
		if (! rules.containsKey(definition))
			throw new IllegalArgumentException("queryNotFound");
		Rule rule = rules.get(definition);
		List<Query> queries = rule.generateObjectives(query.getParameters());
		return queries.stream().allMatch(partialQuery -> answer(partialQuery));
	}

	private void learnFact(Fact newFact) {
		List<Fact> list;
		if (facts.containsKey(newFact.getDefinition())) {
			list = facts.get(newFact.getDefinition());
		} else {
			list = new ArrayList<>();
			facts.put(newFact.getDefinition(), list);
		}
		list.add(newFact);
	}

}
