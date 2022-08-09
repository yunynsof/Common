/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.com.tigo.josm.common.interfaces;

import javax.ejb.Remote;

/**
 *
 * @author Gary González Zepeda
 */
@Remote
public interface JosmServiceConsumerCacheRemote {
    void resetCache();
}
