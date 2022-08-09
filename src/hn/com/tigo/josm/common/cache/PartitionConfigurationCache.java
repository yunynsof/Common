/**
 * PartitionConfigurationCache.java
 * Common
 * Copyright (c) Tigo Honduras.
 */
package hn.com.tigo.josm.common.cache;

import hn.com.tigo.josm.common.configuration.dto.Partitioning;
import hn.com.tigo.josm.common.configuration.dto.ResponseJOSM;
import hn.com.tigo.josm.common.exceptions.ScheduleCacheException;
import hn.com.tigo.josm.common.interfaces.ConfigurationJosmRemote;
import hn.com.tigo.josm.common.locator.ServiceLocatorException;

import java.io.IOException;

import javax.xml.bind.JAXBException;

/**
 * PartitionConfigurationCache.
 *
 * @author Harold Castillo
 * @version 1.0
 * @since 11/08/2015 10:39:30 AM 2015
 */
public class PartitionConfigurationCache extends Cache<Partitioning, ScheduleCacheException> {

	private static final String URI_CONFIGURATION_PARTITION = "hn.com.tigo.persistence.partitions.";

	/**
	 * Instantiates a new task configuration cache.
	 *
	 * @param expiration the expiration
	 */
	public PartitionConfigurationCache(final int expiration,
			final String partitionName) {
		super(expiration, URI_CONFIGURATION_PARTITION.concat(partitionName));
	}

	/* (non-Javadoc)
	 * @see hn.com.tigo.schedule.thread.cache.Cache#loadData()
	 */
	@Override
	public Partitioning loadData() throws ScheduleCacheException {

		Partitioning partitioning = null;

		try {
			final ConfigurationJosmRemote configurationJosmRemote = getConfiguration();
			final ResponseJOSM response = configurationJosmRemote.getConfiguration(super.path);
			partitioning = response.getConfigurations().getPartitioningType();
		} catch (ServiceLocatorException | JAXBException | IOException e) {
			throw new ScheduleCacheException(e.getMessage(), e);
		}

		return partitioning;
	}

}
