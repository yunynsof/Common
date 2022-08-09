package hn.com.tigo.josm.common.validator;

public enum SchemaType {
	
	SUBSCRIPTION("/hn/com/tigo/josm/subscription/xsd/BasicSubscription_schema.xsd", "hn.com.tigo.josm.subscription.dto");
	
	
	private String _path;
	private String _context;
	
	private SchemaType(final String path, final String context){
		this._path = path;
		this._context = context; 
	}
	
	
	public String getPath(){
		return _path;
	}
	
	public String getContext(){
		return _context;
	}

}
