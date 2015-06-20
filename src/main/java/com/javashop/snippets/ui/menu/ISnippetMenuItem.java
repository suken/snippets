/**
 *
 */
package com.javashop.snippets.ui.menu;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;

/**
 * @author sukenshah
 *
 */
public interface ISnippetMenuItem extends Component {

	boolean isNavigable();

	String getNavigationKey();

	Class<? extends View> getViewClass();
}
