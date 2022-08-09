package hn.com.tigo.josm.common.util;

import hn.com.tigo.josm.common.adapter.dto.ParameterArray;
import hn.com.tigo.josm.common.adapter.dto.ParameterType;
import hn.com.tigo.josm.common.adapter.dto.TaskRequestType;

/**
 * The Class BuilderUtil.
 * 
 * @author Jhon Cortes <mailto:jcortesg@stefaninicolombia.com />
 * @version
 * @since 11/03/2015 11:22:26 AM 2015
 */
public final class BuilderUtil {
	
	/** The Constant SHORTCODE. */
	private static final String SHORTCODE = "SHORTCODE";

	/** The Constant SMS. */
	private static final String SMS = "SMS";

	/**
	 * Instantiates a new builder util.
	 */
	public BuilderUtil() {
	}

	/**
	 * Builds the task request type as the input parameter for
	 * PlatformMappingAdapter with two parameters, The first parameter is
	 * PRODUCT_ID and PLATFORM_KEY.
	 * 
	 * @param to
	 *            the to is the destination value.
	 * @param sms
	 *            the sms is the message.
	 * @param platform
	 *            the platform platform is the string field used to map the
	 *            outer shelf product with the product of the local platform.
	 * @return the task request type is an array parameter whit one value named
	 *         PLATFORM_PRODUCT_ID.
	 */
	public TaskRequestType buildTaskRequestType(final String to, final String sms, final String platform) {

		final ParameterType parameterTypeTo = new ParameterType();
		parameterTypeTo.setName(SHORTCODE);
		parameterTypeTo.setValue(to);

		final ParameterType parameterTypeSms = new ParameterType();
		parameterTypeSms.setName(SMS);
		parameterTypeSms.setValue(sms);

		final ParameterArray parameterArray = new ParameterArray();
		parameterArray.getParameter().add(parameterTypeTo);
		parameterArray.getParameter().add(parameterTypeSms);
		
		final TaskRequestType taskRequestType = new TaskRequestType();
		taskRequestType.setParameters(parameterArray);

		return taskRequestType;

	}

}
