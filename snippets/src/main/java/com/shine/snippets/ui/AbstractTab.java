/**
 * 
 */
package com.shine.snippets.ui;

import com.vaadin.ui.VerticalLayout;

/**
 * @author sukenshah
 *
 */
public abstract class AbstractTab extends VerticalLayout implements ILazyInitializedTab {

	private static final long serialVersionUID = -3520895620462229745L;

	private boolean initialized = false;

	@Override
	public final void init() {
		if (initialized)
			return;
		initTab();
		initialized = true;
	}
	
	protected abstract void initTab();

}
