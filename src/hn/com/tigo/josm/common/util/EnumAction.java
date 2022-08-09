/**
 * EnumAction.java
 * Gateway
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.util;

/**
 * EnumAction.
 *
 * This enum defines the actions of JOSM orders
 *
 * @author Harold Castillo <mailto:hjobando@stefanini.com />
 * @version 1.0
 * @since 10/10/2014 16:43:46 2014
 */
public enum EnumAction {


	/** Constant that defines the Activate action. */
	ACTIVATE("Activate"), 
	
	/** Constant that defines the Deactivate action. */
	DEACTIVATE("Deactivate"), 
	
	/** Constant that defines the Loan action. */
	LOAN("Loan"), 
	
	/** Constant that defines the Purchase action. */
	PURCHASE("Purchase"), 
	
	/** Constant that defines the Sell action. */
	SELL("Sell"), 
	
	/** Constant that defines the Transfer action. */
	TRANSFER("Transfer");

	/** Attribute that stores the enum's action. */
	private String action;

	/**
	 * Instantiates a new enum action.
	 *
	 * @param action the action
	 */
	private EnumAction(final String action) {
		this.action = action;
	}

	/**
	 * Gets the action.
	 *
	 * @return the action
	 */
	public String getAction() {
		return this.action;
	}

}
