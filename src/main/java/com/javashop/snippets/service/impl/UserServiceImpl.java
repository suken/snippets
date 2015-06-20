/**
 *
 */
package com.javashop.snippets.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.javashop.snippets.data.User;
import com.javashop.snippets.service.IUserService;

/**
 * @author sukenshah
 *
 */
public class UserServiceImpl extends BaseDaoServiceImpl<User> implements IUserService {

	@PersistenceContext
	private EntityManager entityManager;

	private static final String USER_NAME_QUERY = "select u from " + User.class.getName() + " u where u.userName = ?";

	@Override
	public User getUserByUserName(final String userName) {
		if (Strings.isNullOrEmpty(userName))
			throw new IllegalArgumentException("Null user name.");

		final TypedQuery<User> query = entityManager.createQuery(USER_NAME_QUERY, User.class);
		query.setParameter(1, userName);
		return query.getSingleResult();
	}

}
