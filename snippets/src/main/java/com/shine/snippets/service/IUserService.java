/**
 *
 */
package com.shine.snippets.service;

import com.shine.snippets.data.User;

/**
 * @author sukenshah
 *
 */
public interface IUserService extends IDaoService<User> {

	User getUserByUserName(final String userName);
}
