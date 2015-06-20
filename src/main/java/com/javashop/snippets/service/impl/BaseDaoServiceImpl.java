/**
 *
 */
package com.javashop.snippets.service.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.javashop.snippets.data.GeneratedKeyBaseEntity;
import com.javashop.snippets.service.IDaoService;

/**
 * @author sukenshah
 *
 */
public abstract class BaseDaoServiceImpl<T extends GeneratedKeyBaseEntity> implements IDaoService<T> {

	@PersistenceContext
	private EntityManager entityManager;
	private final Class<T> entityType;

	@SuppressWarnings("unchecked")
	public BaseDaoServiceImpl() {
		this.entityType =
				(Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public final T create(T entity) {
		if (entity == null || entity.getId() != null)
			throw new IllegalArgumentException("Cannot create entity.");
		entityManager.persist(entity);
		entityManager.refresh(entity);
		return entity;
	}

	@Override
	public final T update(T entity) {
		if (entity == null || entity.getId() == null)
			throw new IllegalArgumentException("Cannot update entity.");
		return entityManager.merge(entity);
	}

	@Override
	public final boolean delete(T entity) {
		if (entity == null || entity.getId() == null)
			throw new IllegalArgumentException("Cannot delete entity.");
		entityManager.remove(entity);
		return true;
	}

	@Override
	public final T findById(Long id) {
		if (id == null || id < 0)
			throw new IllegalArgumentException("Cannot find entity for ID = " + id);
		return entityManager.find(entityType, id);
	}
}
