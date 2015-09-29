package de.tudresden.inf.lat.born.problog.type;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.tudresden.inf.lat.born.core.rule.CompletionRule;
import de.tudresden.inf.lat.born.core.term.Clause;
import de.tudresden.inf.lat.born.core.term.ProbClause;
import de.tudresden.inf.lat.born.core.term.Symbol;

/**
 * An object of this class models a Problog program as needed for the
 * translation.
 * 
 * @author Julian Mendez
 *
 */
public class ProblogProgram {

	static final String TITLE_COMPLETION_RULES = "%% EL completion rules";
	static final String TITLE_ONTOLOGY = "%% Ontology";
	static final String TITLE_BAYESIAN_NETWORK = "%% Bayesian Network";
	static final String TITLE_QUERIES = "%% Queries";

	private final List<CompletionRule> completionRules = new ArrayList<CompletionRule>();
	private final List<Clause> ontology = new ArrayList<Clause>();
	private final List<ProbClause> bayesianNetwork = new ArrayList<ProbClause>();
	private final List<Clause> queries = new ArrayList<Clause>();
	private String bayesianNetworkAddendum;
	private String queryListAddendum;

	public ProblogProgram() {
	}

	public List<CompletionRule> getCompletionRules() {
		return Collections.unmodifiableList(this.completionRules);
	}

	public void setCompletionRules(List<CompletionRule> completionRules) {
		this.completionRules.clear();
		this.completionRules.addAll(completionRules);
	}

	public List<Clause> getOntology() {
		return Collections.unmodifiableList(this.ontology);
	}

	public void setOntology(List<Clause> ontology) {
		this.ontology.clear();
		this.ontology.addAll(ontology);
	}

	public List<ProbClause> getBayesianNetwork() {
		return Collections.unmodifiableList(this.bayesianNetwork);
	}

	public void setBayesianNetwork(List<ProbClause> bayesianNetwork) {
		this.bayesianNetwork.clear();
		this.bayesianNetwork.addAll(bayesianNetwork);
	}

	public String getBayesianNetworkAddendum() {
		return this.bayesianNetworkAddendum;
	}

	public void setBayesianNetworkAddendum(String bayesianNetworkAddendum) {
		this.bayesianNetworkAddendum = bayesianNetworkAddendum;
	}

	public List<Clause> getQueries() {
		return this.queries;
	}

	public void setQueries(List<Clause> queries) {
		this.queries.clear();
		this.queries.addAll(queries);
	}

	public String getQueryListAddendum() {
		return this.queryListAddendum;
	}

	public void setQueryListAddendum(String queryListAddendum) {
		this.queryListAddendum = queryListAddendum;
	}

	public List<Clause> getClauses() {
		ArrayList<Clause> ret = new ArrayList<Clause>();
		ret.addAll(this.completionRules);
		ret.addAll(this.ontology);
		ret.addAll(this.bayesianNetwork);
		ret.addAll(this.queries);
		return Collections.unmodifiableList(ret);
	}

	String asString(List<Clause> clauses) {
		StringBuffer sb = new StringBuffer();
		for (Clause clause : clauses) {
			sb.append(clause.asString());
		}
		return sb.toString();
	}

	String asStringC(List<CompletionRule> clauses) {
		StringBuffer sb = new StringBuffer();
		for (CompletionRule clause : clauses) {
			sb.append(clause.asString());
			sb.append(Symbol.PERCENT_CHAR);
			sb.append(Symbol.NEW_LINE_CHAR);
		}
		return sb.toString();
	}

	String asStringP(List<ProbClause> clauses) {
		StringBuffer sb = new StringBuffer();
		for (ProbClause clause : clauses) {
			sb.append(clause.asString());
		}
		return sb.toString();
	}

	public String asString() {
		StringBuffer sb = new StringBuffer();
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(TITLE_COMPLETION_RULES);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(asStringC(this.completionRules));
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(TITLE_ONTOLOGY);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(asString(this.ontology));
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(TITLE_BAYESIAN_NETWORK);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(asStringP(this.bayesianNetwork));
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(this.bayesianNetworkAddendum);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(TITLE_QUERIES);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(asString(this.queries));
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(this.queryListAddendum);
		sb.append(Symbol.NEW_LINE_CHAR);
		sb.append(Symbol.NEW_LINE_CHAR);
		return sb.toString();
	}

	@Override
	public String toString() {
		return asString();
	}

}