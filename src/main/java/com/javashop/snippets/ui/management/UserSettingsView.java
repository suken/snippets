/**
 *
 */
package com.javashop.snippets.ui.management;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;


/**
 * @author sukenshah
 */
public class UserSettingsView extends VerticalLayout implements View {
	private static final long serialVersionUID = 6018937339643928340L;

	@Override
	public void enter(ViewChangeEvent event) {
		new Notification("Under construction", Type.HUMANIZED_MESSAGE).show(Page.getCurrent());
	}

}
