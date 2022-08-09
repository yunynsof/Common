package hn.com.tigo.josm.common.broker.compiler.data;

import java.io.Serializable;

public class DataParameter implements Serializable {

	/**
	 * Generated serialVersionUID 
	 */
	private static final long serialVersionUID = 7299231083778679537L;
	
	private ExpressionType _type;
	private String _expression;
	
	public DataParameter(ExpressionType type, String expression){
		this._type = type;
		this._expression = expression;
	}
	
	public ExpressionType getType() {
		return _type;
	}
	public void setType(ExpressionType type) {
		this._type = type;
	}
	public String getExpression() {
		return _expression;
	}
	public void setExpression(String expression) {
		this._expression = expression;
	}
	
}
