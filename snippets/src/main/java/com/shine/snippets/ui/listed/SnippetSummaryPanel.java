/**
 *
 */
package com.shine.snippets.ui.listed;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.shine.snippets.data.SnippetSummary;
import com.shine.snippets.data.User;
import com.shine.snippets.ui.ClickLabel;
import com.shine.snippets.ui.UsersListWindow;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.shared.ui.window.WindowMode;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * @author sukenshah
 *
 */
public class SnippetSummaryPanel extends CustomLayout {

	private static final long serialVersionUID = -4095177607409497056L;
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd MMM yyyy");

	public SnippetSummaryPanel(SnippetSummary snippet) {
		super("SnippetsLayout");

		final ClickLabel viewsLabel = new ClickLabel(FontAwesome.EYE.getHtml() + " " + snippet.getViews(), ContentMode.HTML);
		final ClickLabel likesLabel = new ClickLabel(FontAwesome.THUMBS_UP.getHtml() + " " + snippet.getLikes(), ContentMode.HTML);
		final ClickLabel commentsLabel = new ClickLabel(FontAwesome.COMMENTS.getHtml()
				+ " " + (snippet.getComments() == null ? 0 : snippet.getComments()), ContentMode.HTML);
		final Label descriptionLabel = new Label("<b>" + snippet.getName() + "</b><br>" + snippet.getDescription(), ContentMode.HTML);
		final Image profileImg = new Image("", new ThemeResource("images/MaleUser.png"));
		profileImg.addStyleName("profile-icon");
		final String userMetadata = snippet.getAuthorName()
				+ "<br><font style=\"font-weight:normal;font-size: 10px;\" > Created on " + FORMATTER.format(snippet.getCreatedOn()) + "</font>";
		final Label userLabel = new Label(userMetadata, ContentMode.HTML);
		descriptionLabel.setWidth("90%");

		addComponent(viewsLabel, "sViews");
		addComponent(likesLabel, "sLikes");
		addComponent(commentsLabel, "sComments");
		addComponent(userLabel, "sCreator");
		addComponent(profileImg, "sProfile");
		addComponent(descriptionLabel, "sDescription");

		// add views label listener
		viewsLabel.addLayoutClickListener(new LayoutClickListener() {

			private static final long serialVersionUID = 5440052413714881771L;

			@Override
			public void layoutClick(LayoutClickEvent event) {
				// dummy user list
				final List<User> users = new ArrayList<User>();
				for (int i = 0; i < 5; i++) {
					final User user = new User();
					user.setFirstName("Test " + i);
					user.setLastName("User");
					users.add(user);
				}
				final UsersListWindow popup = new UsersListWindow("Likes", users);
				popup.setWindowMode(WindowMode.NORMAL);
				popup.setPositionX(event.getClientX());
				popup.setPositionY(event.getClientY());
				popup.setHeight("200px");
				UI.getCurrent().addWindow(popup);
			}
		});

		setHeight("150px");
		setWidth("80%");
	}
}
