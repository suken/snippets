/**
 *
 */
package com.javashop.snippets.service;

import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.thirdparty.guava.common.collect.Maps;


/**
 * @author sukenshah
 * @param <T>
 *
 */
public final class ServiceRegistry {

	private static ServiceRegistry instance;

	private static final Map<Class<?>, Object> mappings = Maps.newHashMap();

	public static ServiceRegistry createRegistry(ArrayList<ServiceInfo> services) {
		if (instance != null)
			return instance;
		instance = new ServiceRegistry();

		for (final ServiceInfo info : services) {
			try {
				if (mappings.containsKey(info.getServiceType()))
					throw new IllegalArgumentException("Cannot register service multiple times. Service class = " + info.getServiceType());
				mappings.put(info.getServiceType(), info.getService());
			} catch (final ClassNotFoundException e) {
				throw new IllegalArgumentException("Cant find service class.");
			}
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getService(Class<T> type) {
		if (!mappings.containsKey(type))
			throw new IllegalArgumentException("No service regsitered for " + type);
		return (T) mappings.get(type);
	}

}
