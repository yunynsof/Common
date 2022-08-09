package hn.com.tigo.josm.common.jmx.event;

import hn.com.tigo.josm.common.dto.JOSMEvent;

import java.io.Serializable;

/**
 * ReleaseDriverEvent.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 8/05/2015 06:03:17 PM 2015
 */
public class ReleaseDriverEvent extends JOSMEvent implements Serializable  {

	/** Attribute that determine a Constant of serialVersionUID. */
	private static final long serialVersionUID = -4824979036761927018L;
	
	public ReleaseDriverEvent(){
		super(MonitoringEventType.RELEASE_DRIVER, MXBeanType.DRIVER);
	}

}
