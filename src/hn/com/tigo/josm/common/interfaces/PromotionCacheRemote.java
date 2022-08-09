package hn.com.tigo.josm.common.interfaces;

import javax.ejb.Remote;

@Remote
public interface PromotionCacheRemote {

	void resetCache();
	
}
