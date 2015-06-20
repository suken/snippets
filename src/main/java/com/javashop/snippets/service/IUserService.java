/**
 *
 */
package com.javashop.snippets.service;

import com.javashop.snippets.data.User;

/**
 * @author sukenshah
 *
 */
public interface IUserService extends IDaoService<User> {

	User getUserByUserName(final String userName);
}
