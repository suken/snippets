/**
 *
 */
package com.javashop.snippets.ui.menu;

import com.vaadin.navigator.View;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

/**
 * @author sukenshah
 *
 */
public class MenuItemLabel extends Label implements ISnippetMenuItem {
	private static final long serialVersionUID = -7137380039766047789L;

	public MenuItemLabel(final String text, final ContentMode mode) {
		super(text, mode);
		setPrimaryStyleName("valo-menu-subtitle");
		addStyleName("h4");
		setSizeUndefined();
	}

	@Override
	public boolean isNavigable() {
		return false;
	}

	@Override
	public String getNavigationKey() {
		return null;
	}

	@Override
	public Class<? extends View> getViewClass() {
		return null;
	}
}
