/**
 * MetaOrderRequest.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.dto;

import hn.com.tigo.josm.common.order.ComplexOrderRequest;

import java.io.Serializable;

/**
 * MetaOrderRequest. MetaOrderRequest DTO contains a complexOrderRequest
 * including ipAddress, userPrincipal, interfaceId ,interfaceName and a
 * transactionID.
 * 
 * @author Harold Castillo <mailto:hjobando@stefanini.com />
 * @version 1.0
 * @since 10/10/2014 16:48:54 2014
 */
public class MetaOrderRequest implements Serializable {

	/** serialVersionUID of type long. */
	private static final long serialVersionUID = 1L;

	/** Attribute that determine complexProductRequestOrder. */
	private ComplexOrderRequest complexOrderRequest;

	/** Attribute that determine ipAddress. */
	private String ipAddress;

	/** Attribute that determine userPrincipal. */
	private String userPrincipal;

	/** Attribute that determine transactionID. */
	private String transactionID;

	/**
	 * Gets the user principal.
	 * 
	 * @return the userPrincipal
	 */
	public String getUserPrincipal() {
		return userPrincipal;
	}

	/**
	 * Sets the user principal.
	 * 
	 * @param userPrincipal
	 *            the userPrincipal to set
	 */
	public void setUserPrincipal(final String userPrincipal) {
		this.userPrincipal = userPrincipal;
	}

	/**
	 * Gets the ip address.
	 * 
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the ip address.
	 * 
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ORDER Request " + " TRANSACTION ID :" + this.transactionID + ", IP :" + this.getIpAddress()
				+ ", USER : " + this.getUserPrincipal();
	}

	/**
	 * Gets the complex product request order.
	 * 
	 * @return the complex product request order
	 */
	public ComplexOrderRequest getComplexOrderRequest() {
		return complexOrderRequest;
	}

	/**
	 * Sets the complex product request order.
	 * 
	 * @param complexProductRequestOrder
	 *            the new complex product request order
	 */
	public void setComplexOrderRequest(final ComplexOrderRequest complexProductRequestOrder) {
		this.complexOrderRequest = complexProductRequestOrder;
	}

	/**
	 * Gets the transaction id.
	 * 
	 * @return the transaction id
	 */
	public String getTransactionID() {
		return transactionID;
	}

	/**
	 * Sets the transaction id.
	 * 
	 * @param transactionID
	 *            the new transaction id
	 */
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

}
