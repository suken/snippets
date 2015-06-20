/**
 *
 */
package com.javashop.snippets.ui.menu;

import lombok.Getter;

import com.vaadin.navigator.View;
import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

/**
 * @author sukenshah
 *
 */
public class MenuItemButton extends Button implements ISnippetMenuItem {
	private static final long serialVersionUID = -1377919076800405048L;

	@Getter
	private final String displayText;
	@Getter
	private final String navigationKey;
	@Getter
	private final Class<? extends View> viewClass;

	public MenuItemButton(final String key, final String display, final Resource icon, final Class<? extends View> clazz) {
		navigationKey = key;
		displayText = display;
		viewClass = clazz;
		setCaption(display);
		setHtmlContentAllowed(true);
		setPrimaryStyleName("valo-menu-item");
		setIcon(icon);
	}

	@Override
	public boolean isNavigable() {
		return true;
	}

}
