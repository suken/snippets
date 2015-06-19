/**
 *
 */
package com.shine.snippets.service;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sukenshah
 *
 */
@Getter
@Setter
final class ServiceInfo {

	private String name;
	private Object service;

	Class<?> getServiceType() throws ClassNotFoundException {
		return Class.forName(name);
	}
}
