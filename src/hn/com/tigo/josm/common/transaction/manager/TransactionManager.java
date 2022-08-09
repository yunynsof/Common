package hn.com.tigo.josm.common.transaction.manager;

import hn.com.tigo.josm.common.exceptions.ResponseFaultMsg;
import hn.com.tigo.josm.common.exceptions.TransactionManagerException;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;

/**
 * TransactionManager.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 12/08/2015 03:42:08 PM 2015
 */
public class TransactionManager {
	
	
	/** Attribute that determine a Constant of LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(TransactionManager.class);
	
	/** Attribute that determine _success. */
	private boolean _success;
	
	private boolean _start;
	
	/** Attribute that determine _trx. */
	private UserTransaction _trx;
	
	private long _startTime;
	
	private final long _timeout;
	
	
	
	/**
	 * Instantiates a new transaction manager.
	 */
	public TransactionManager(final UserTransaction trx, final long timeout){
		this._success = false;
		this._trx = trx;
		this._timeout = timeout;
		this._startTime = 0L;
		this._start = false;
	}
	
	/**
	 * Instantiates a new transaction manager.
	 */
	public TransactionManager(final UserTransaction trx){
		this._success = false;
		this._trx = trx;
		this._timeout = -1L;
		this._startTime = 0L;
		this._start = false;
	}
	
	
	/**
	 * Begin trx.
	 *
	 * @param trx the trx
	 * @throws ResponseFaultMsg the response fault msg
	 * @throws TransactionManagerException the transaction manager exception
	 */
	public void beginTRX(final long startTime) throws TransactionManagerException {
		try {
			_startTime = startTime;
			
			_success = false;
			_trx.begin();
			_start = true;
			
		} catch (NotSupportedException | SystemException e) {
			LOGGER.error(e.getMessage(), e);
			throw new TransactionManagerException(e);
		}

	}
	
	
	/**
	 * Begin trx.
	 *
	 * @param trx the trx
	 * @throws ResponseFaultMsg the response fault msg
	 * @throws TransactionManagerException the transaction manager exception
	 */
	public void beginTRX() throws TransactionManagerException {
		try {
			_startTime = System.currentTimeMillis();
			_success = false;
			_trx.begin();
			_start = true;
		} catch (NotSupportedException | SystemException e) {
			LOGGER.error(e.getMessage(), e);
			throw new TransactionManagerException(e);
		}

	}

	/**
	 * Commit trx.
	 *
	 * @param trx the trx
	 * @throws ResponseFaultMsg the response fault msg
	 * @throws TransactionManagerException the transaction manager exception
	 */
	public  void commitTRX() throws  TransactionManagerException {

		try {
			final long end = System.currentTimeMillis() - _startTime;
			if(_timeout != -1L && end > _timeout ){
				rollbackTRX();
				_success = false;
			}else{
				_trx.commit();
				this._success = true;
			}
			_start = false;
			
		} catch (SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException
				| SystemException e) {
			LOGGER.error(e.getMessage(), e);
			throw new TransactionManagerException(e);
		}

	}

	/**
	 * Rollback trx.
	 *
	 * @param trx the trx
	 */
	public void rollbackTRX() {

		try {
			if(_start){
				_trx.rollback();
				_start = false;
			}
		} catch (IllegalStateException | SecurityException | SystemException e) {
			LOGGER.error(e.getMessage(), e);
		}

	}


	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess() {
		return _success;
	}


		

}
