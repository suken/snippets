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

	T create(T entity);

	T update(T entity);

	boolean delete(T entity);

	T findById(Long id);
}
