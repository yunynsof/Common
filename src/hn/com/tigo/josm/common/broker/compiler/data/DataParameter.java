package hn.com.tigo.josm.common.broker.compiler.data;

import java.io.Serializable;

/**
 * DataParameter.
 *
 * @author Jhon Fredy Cortes Gaspar <mailto:jfgaspar@stefanini.com />
 * @version 1.0
 * @since 12/02/2016 04:33:34 PM 2016
 */
public class DataParameter implements Serializable {

	/** Generated serialVersionUID. */
	private static final long serialVersionUID = 7299231083778679537L;
	
	/** The _type. */
	private ExpressionType _type;
	
	/** The _expression. */
	private String _expression;
	
	/**
	 * Instantiates a new data parameter.
	 *
	 * @param type the type
	 * @param expression the expression
	 */
	public DataParameter(final ExpressionType type, final String expression){
		this._type = type;
		this._expression = expression;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public ExpressionType getType() {
		return _type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(final ExpressionType type) {
		this._type = type;
	}
	
	/**
	 * Gets the expression.
	 *
	 * @return the expression
	 */
	public String getExpression() {
		return _expression;
	}
	
	/**
	 * Sets the expression.
	 *
	 * @param expression the new expression
	 */
	public void setExpression(final String expression) {
		this._expression = expression;
	}
	
}
