package hn.com.tigo.josm.common.broker.compiler.data;

import java.util.regex.Pattern;

public enum ExpressionType {
	
	VARIABLE_NAME("x"),
	INLINE_EXPRESSION("x|s|i|b|f"),
	CONDITIONAL_EXPRESSION("b"),
	STRING_EXPRESSION("s"),
	STATEMENT("((ys)|(yi)|(yx)|(yb)|(f)|(yf));");
	
	private Pattern _pattern;
	
	private ExpressionType(String regex){
		this._pattern = Pattern.compile(regex);
		
	}

	public Pattern getPattern() {
		return _pattern;
	}

	

}
