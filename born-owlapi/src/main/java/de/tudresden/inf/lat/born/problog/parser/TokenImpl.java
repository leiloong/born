package de.tudresden.inf.lat.born.problog.parser;

import java.util.Set;
import java.util.TreeSet;

import de.tudresden.inf.lat.born.core.term.Symbol;

/**
 * Default implementation of a token.
 * 
 * @author Julian Mendez
 *
 */
public class TokenImpl implements Token {

	private final String tokenValue;
	private final TokenType tokenType;
	private final int lineNumber;

	/**
	 * Constructs an empty token.
	 * 
	 * @param str
	 *            string
	 * @param lineNumber
	 *            line number
	 */
	public TokenImpl(String str, int lineNumber) {
		this.tokenValue = str;
		this.lineNumber = lineNumber;
		this.tokenType = findType(str);
	}

	Set<String> getSymbols() {
		Set<String> ret = new TreeSet<String>();
		ret.add("" + Symbol.PAR_A_CHAR); // "(";
		ret.add("" + Symbol.PAR_B_CHAR); // ")";
		ret.add("" + Symbol.SQB_A_CHAR); // "[";
		ret.add("" + Symbol.SQB_B_CHAR); // "]";
		ret.add("" + Symbol.VERT_CHAR); // "|";
		ret.add("" + Symbol.COMMA_CHAR); // ",";
		ret.add("" + Symbol.SEMICOLON); // ";";
		ret.add("" + Symbol.POINT_CHAR); // ".";
		ret.add("" + Symbol.EXCL_MARK_CHAR); // "!";
		ret.add("" + Symbol.PERCENT_CHAR); // "%";
		ret.add("" + Symbol.COLON_CHAR); // ":";
		ret.add("" + Symbol.APOSTROPHE_CHAR); // "'";
		ret.add("" + Symbol.QUOTES_CHAR); // "\"";
		ret.add(Symbol.IF_SYMBOL); // ":-";
		return ret;
	}

	boolean isBlank(String str) {
		return ((str == null) || str.trim().isEmpty());
	}

	boolean isComment(String str) {
		return ((str != null) && str.startsWith("" + Symbol.PERCENT_CHAR));
	}

	boolean isSymbol(String str) {
		return getSymbols().contains(str);
	}

	boolean isString(String str) {
		return ((str != null) && str.trim().length() >= 2
				&& str.startsWith("" + Symbol.QUOTES_CHAR) && str.endsWith(""
				+ Symbol.QUOTES_CHAR));
	}

	boolean isConstantWithApostrophes(String str) {
		return ((str != null) && str.trim().length() >= 2
				&& str.startsWith("" + Symbol.APOSTROPHE_CHAR) && str
					.endsWith("" + Symbol.APOSTROPHE_CHAR));
	}

	boolean isIdentifier(String str) {
		if ((str == null) || str.trim().isEmpty()) {
			return false;
		} else {
			boolean ret = true;
			for (int i = 0; ret && (i < str.length()); i++) {
				char ch = str.charAt(i);
				ret = ret
						&& (Character.isLetterOrDigit(ch) || (ch == Symbol.UNDERSCORE_CHAR));
			}
			char ch = str.charAt(0);
			ret = ret
					&& (Character.isLetter(ch) || (ch == Symbol.UNDERSCORE_CHAR));
			return ret;
		}
	}

	boolean isConstant(String str) {
		if ((str == null) || str.trim().isEmpty()) {
			return false;
		} else if (isConstantWithApostrophes(str)) {
			return true;
		} else {
			boolean ret = true;
			for (int i = 0; ret && (i < str.length()); i++) {
				char ch = str.charAt(i);
				ret = ret && (!Character.isSpaceChar(ch));
			}
			return ret;
		}
	}

	TokenType findType(String str) {
		if (isBlank(str)) {
			return TokenType.BLANK;
		} else if (isComment(str)) {
			return TokenType.COMMENT;
		} else if (isSymbol(str)) {
			return TokenType.SYMBOL;
		} else if (isString(str)) {
			return TokenType.STRING;
		} else if (isIdentifier(str)) {
			return TokenType.IDENTIFIER;
		} else if (isConstant(str)) {
			return TokenType.CONSTANT;
		} else {
			return TokenType.UNDEFINED;
		}
	}

	@Override
	public String getValue() {
		return this.tokenValue;
	}

	@Override
	public TokenType getType() {
		return this.tokenType;
	}

	@Override
	public int getLineNumber() {
		return this.lineNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (!(obj instanceof Token)) {
			return false;
		} else {
			Token other = (Token) obj;
			return getType().equals(other.getType())
					&& getValue().equals(other.getValue())
					&& (getLineNumber() == other.getLineNumber());
		}
	}

	@Override
	public int hashCode() {
		return this.tokenType.hashCode() + 0x1F
				* (this.tokenValue.hashCode() + 0x1F * this.lineNumber);
	}

	@Override
	public String toString() {
		return "[" + getType().toString().toLowerCase() + ":" + getLineNumber()
				+ "]" + getValue();
	}

}
