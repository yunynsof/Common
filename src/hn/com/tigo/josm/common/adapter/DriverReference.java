package hn.com.tigo.josm.common.adapter;

import hn.com.tigo.josm.common.exceptions.AdapterException;

import java.io.Serializable;

public class DriverReference<S> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3489774581940645580L;
	
	private S _driver;
	private AbstractAdapter<S> _adapter;
	private long _version;
	
	public DriverReference(final AbstractAdapter<S> adapter, final long version){
		this._adapter = adapter;
		this._version = version;
	}
	
	
	public S getDriver() throws AdapterException{
		if(_driver == null){
			_driver = _adapter.createDriver();
		}
		
		return _driver;
	}
	
	
	public void clearDriver(){
		_driver = null;
	}


	public long getVersion() {
		return _version;
	}


	
		
	

}
