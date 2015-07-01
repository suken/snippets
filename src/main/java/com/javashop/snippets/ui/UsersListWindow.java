/**
 *
 */
package com.javashop.snippets.ui;

import java.util.List;

import com.javashop.snippets.data.User;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * @author sukenshah
 */
public class UsersListWindow extends Window {

	private static final long serialVersionUID = 2176740403274951431L;

	private final VerticalLayout layout;

	public UsersListWindow(final String title, final List<User> users) {
		setCaptionAsHtml(true);
		setCaption("<b>" + title + "</b>");
		layout = new VerticalLayout();
		setContent(layout);
		layout.setMargin(true);

		for (final User user : users) {
			final HorizontalLayout userLayout = new HorizontalLayout();
			// userLayout.addComponent(new Image("", new
			// ThemeResource("images/FemaleUser.png")));
			userLayout.addComponent(new Label(FontAwesome.USER.getHtml() + " "
					+ user.getFirstName() + " " + user.getLastName(),
					ContentMode.HTML));
			layout.addComponent(userLayout);
		}
	}
}
