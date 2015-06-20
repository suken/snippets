/**
 *
 */
package com.javashop.snippets;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.google.gwt.thirdparty.guava.common.collect.ImmutableList;
import com.google.gwt.thirdparty.guava.common.collect.ImmutableList.Builder;
import com.javashop.snippets.data.User;
import com.javashop.snippets.service.IUserService;
import com.javashop.snippets.service.ServiceRegistry;
import com.vaadin.server.Page;
import com.vaadin.ui.UI;

/**
 * @author sukenshah
 *
 */
public final class UserContext {

	private static final Logger LOGGER = Logger.getLogger(UserContext.class);

	private static final ThreadLocal<UserInfo> USER = new ThreadLocal<UserContext.UserInfo>();

	private UserContext() {
	}

	public static User getCurrentUser() {
		final UserInfo userInfo = USER.get();

		if (userInfo != null)
			return userInfo.getUser();

		if (!updateContextForAuthenticatedUser()) {
			LOGGER.warn("Could not update user context.");
			return null;
		}
		return USER.get().getUser();
	}

	public static void clearContext() {
		USER.set(null);
		SecurityContextHolder.clearContext();
	}

	public static ImmutableList<String> getCurrentUserRoles() {
		final UserInfo userInfo = USER.get();

		if (userInfo != null)
			return userInfo.getRoles();

		if (!updateContextForAuthenticatedUser()) {
			LOGGER.warn("Could not update user context.");
		}
		return USER.get().getRoles();
	}

	public static void login(final String userName, final String password) {
		final UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(userName, password);
		final Authentication authentication = ServiceRegistry.getService(AuthenticationManager.class).authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		updateContextForAuthenticatedUser();
		Page.getCurrent().setLocation("/snippets/home");
	}

	public static void logoutCurrentUser() {
		SecurityContextHolder.clearContext();
		UI.getCurrent().close();
		Page.getCurrent().setLocation("/snippets/snpt/login");
	}

	private static final boolean updateContextForAuthenticatedUser() {
		final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if (Strings.isNullOrEmpty(userName)) {
			LOGGER.warn("Authenticated user doesnt exists.");
			return false;
		}
		final User user = ServiceRegistry.getService(IUserService.class).getUserByUserName(userName);
		final Builder<String> builder = ImmutableList.builder();
		final Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			builder.add(grantedAuthority.getAuthority());
		}
		USER.set(new UserInfo(user, builder.build()));
		return true;
	}

	@Getter
	@AllArgsConstructor
	private static final class UserInfo {
		private final User user;
		private final ImmutableList<String> roles;
	}

}
