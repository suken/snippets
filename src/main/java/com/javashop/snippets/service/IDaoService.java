/**
 *
 */
package com.javashop.snippets.service;

import com.javashop.snippets.data.GeneratedKeyBaseEntity;

/**
 * @author sukenshah
 *
 */
public interface IDaoService<T extends GeneratedKeyBaseEntity> {

	T create(final T entity);

	T update(final T entity);

	boolean delete(final T entity);

	T findById(final Long id);
}
