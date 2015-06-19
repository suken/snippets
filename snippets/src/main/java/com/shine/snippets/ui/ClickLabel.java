/**
 *
 */
package com.shine.snippets.ui;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * @author sukenshah
 *
 */
public class ClickLabel extends VerticalLayout {

	private static final long serialVersionUID = -5786277356211635362L;

	public ClickLabel(final String caption) {
		addComponent(new Label(caption));
	}

	public ClickLabel(final String caption, final ContentMode mode) {
		addComponent(new Label(caption, mode));
	}
}
