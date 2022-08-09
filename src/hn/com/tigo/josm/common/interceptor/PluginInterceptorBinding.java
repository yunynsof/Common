/**
 * PluginInterceptorBinding.java
 * Common
 * Copyright (C) Tigo Honduras
*/
package hn.com.tigo.josm.common.interceptor;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * PluginInterceptorBinding.
 *
 * @author Jose David Martinez Rico <mailto:jdmartinez@stefanini.com />
 * @version 
 * @see 
 * @since 12/02/2015 02:17:53 PM 2015
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target({METHOD, TYPE})
public @interface PluginInterceptorBinding {

}
