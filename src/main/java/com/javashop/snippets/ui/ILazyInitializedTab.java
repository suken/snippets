/**
 *
 */
package com.javashop.snippets.ui;

import com.vaadin.ui.Component;

/**
 * @author sukenshah
 *
 */
public interface ILazyInitializedTab extends Component {

	void init();

	@Override
	String getCaption();
}
