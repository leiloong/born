package de.tudresden.inf.lat.born.core.rule;

import java.util.ArrayList;
import java.util.List;

import de.tudresden.inf.lat.born.core.term.Clause;
import de.tudresden.inf.lat.born.core.term.Term;

/**
 * This is an optimization rule for Problog.
 * <ul>
 * <li><b>if</b>X \u2291 Y &isin; <i>T</i><br>
 * <b>then</b> S := S &cup; {X \u2291 Y}</li>
 * </ul>
 * <br>
 * 
 * @author Julian Mendez
 *
 */
public class BR3Rule implements CompletionRule {

	private final Clause clause;

	/**
	 * Constructs a new BR 3 rule.
	 */
	public BR3Rule() {
		FormulaConstructor c = new FormulaConstructor();

		Term x = c.newVar("X");
		Term y = c.newVar("Y");

		Term head = c.sub(x, y);
		List<Term> body = new ArrayList<Term>();
		body.add(c.subs(x, y));

		this.clause = c.rule(head, body);
	}

	@Override
	public Term getHead() {
		return this.clause.getHead();
	}

	@Override
	public List<Term> getBody() {
		return this.clause.getBody();
	}

	@Override
	public String asString() {
		return this.clause.asString();
	}

	@Override
	public boolean equals(Object obj) {
		return this.clause.equals(obj);
	}

	@Override
	public int hashCode() {
		return this.clause.hashCode();
	}

	@Override
	public String toString() {
		return this.clause.toString();
	}

}
