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

	public KnowledgeBase(String path) throws FileNotFoundException, IOException {
		facts = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				this.learn(Parser.createImplication(line));
				line = br.readLine();
			}
		}
	}

	public boolean answer(String query) {
		Query q = Parser.createQuery(query);
		return facts.get(q.getDefinition()).stream().anyMatch(fact -> fact.answer(q.getParameters()));
	}

	private void learn(Fact newFact) {
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
