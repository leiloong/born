package de.tudresden.inf.lat.born.core.rule;

import java.util.ArrayList;
import java.util.List;

import de.tudresden.inf.lat.born.core.term.Clause;
import de.tudresden.inf.lat.born.core.term.Term;

/**
 * This is a basic completion rule for Problog.
 * <ul>
 * <li><b>if</b> X is concept in <i>T</i><br>
 * <b>then</b> S := S &cup; {X \u2291 \u22A4 }</li>
 * </ul>
 * <br>
 * 
 * @author Julian Mendez
 *
 */
public class BR2Rule implements CompletionRule {

	private final Clause clause;

	/**
	 * Constructs a new BR-2 rule.
	 */
	public BR2Rule() {
		FormulaConstructor c = new FormulaConstructor();

		Term x = c.newVar("X");

		Term head = c.sub(x, c.top());
		List<Term> body = new ArrayList<Term>();
		body.add(c.con(x));

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