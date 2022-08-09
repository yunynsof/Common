package hn.com.tigo.josm.common.broker.compiler.data;

import java.util.regex.Pattern;

/**
 * ExpressionType.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 17/02/2016 09:46:00 AM 2016
 */
public enum ExpressionType {
	
	/** The variable name. */
	VARIABLE_NAME("x"),
	
	/** The inline expression. */
	INLINE_EXPRESSION("x|s|i|b|f"),
	
	/** The conditional expression. */
	CONDITIONAL_EXPRESSION("b"),
	
	/** The string expression. */
	STRING_EXPRESSION("s"),
	
	/** The statement. */
	STATEMENT("((ys)|(yi)|(yx)|(yb)|(f)|(yf));");
	
	/** The _pattern. */
	private Pattern _pattern;
	
	/**
	 * Instantiates a new expression type.
	 *
	 * @param regex the regex
	 */
	private ExpressionType(String regex){
		this._pattern = Pattern.compile(regex);
		
	}

	/**
	 * Gets the pattern.
	 *
	 * @return the pattern
	 */
	public Pattern getPattern() {
		return _pattern;
	}

	

}
