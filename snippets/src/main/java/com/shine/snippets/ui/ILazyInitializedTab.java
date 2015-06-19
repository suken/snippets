/**
 * 
 */
package com.shine.snippets.ui;

import com.vaadin.ui.Component;

/**
 * @author sukenshah
 *
 */
public interface ILazyInitializedTab extends Component {

	void init();
	
	String getCaption();
}
