package com.javashop.snippets.ui.dashboard;

import java.util.Iterator;

import com.javashop.snippets.UserContext;
import com.javashop.snippets.data.User;
import com.javashop.snippets.ui.StringGenerator;
import com.javashop.snippets.ui.menu.ISnippetMenuItem;
import com.javashop.snippets.ui.menu.MenuItemButton;
import com.javashop.snippets.ui.menu.MenuItemsProvider;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *@author sukenshah
 */
@Theme("snippetstheme")
@Widgetset("com.javashop.snippets.SnippetsWidgetset")
public class Dashboard extends UI {
	private static final long serialVersionUID = 6972694474830766261L;

	private final DashboardMenuLayout root = new DashboardMenuLayout();
	private final ComponentContainer viewDisplay = root.getContentContainer();
	private final CssLayout menu = new CssLayout();
	private final CssLayout menuItemsLayout = new CssLayout();
	{
		menu.setId("testMenu");
	}
	private Navigator navigator;
	private MenuItemsProvider menuProvider;

	@Override
	protected void init(final VaadinRequest request) {
		if (request.getParameter("test") != null) {

			if (browserCantRenderFontsConsistently()) {
				getPage().getStyles().add(
						".v-app.v-app.v-app {font-family: Sans-Serif;}");
			}
		}

		if (getPage().getWebBrowser().isIE()
				&& getPage().getWebBrowser().getBrowserMajorVersion() == 9) {
			menu.setWidth("320px");
		}
		Responsive.makeResponsive(this);

		getPage().setTitle("Snippets");
		setContent(root);
		root.setWidth("100%");

		menuProvider = new MenuItemsProvider();
		root.addMenu(buildMenu());
		addStyleName(ValoTheme.UI_WITH_MENU);

		navigator = new Navigator(this, viewDisplay);

		for (final ISnippetMenuItem menuItem : menuProvider.getMenuItems()) {
			if (menuItem.isNavigable())
				navigator.addView(menuItem.getNavigationKey(), menuItem.getViewClass());
		}

		final String f = Page.getCurrent().getUriFragment();
		if (f == null || f.equals("")) {
			navigator.navigateTo(menuProvider.getDefaultNavigationKey());
		}

		navigator.addViewChangeListener(new ViewChangeListener() {
			private static final long serialVersionUID = -8494482159132056254L;

			@Override
			public boolean beforeViewChange(final ViewChangeEvent event) {
				return true;
			}

			@Override
			public void afterViewChange(final ViewChangeEvent event) {
				for (final Iterator<Component> it = menuItemsLayout.iterator(); it
						.hasNext();) {
					it.next().removeStyleName("selected");
				}
				menuProvider.getMenuItem(event.getViewName()).addStyleName("selected");
				menu.removeStyleName("valo-menu-visible");
			}
		});

	}

	private boolean browserCantRenderFontsConsistently() {
		// PhantomJS renders font correctly about 50% of the time, so
		// disable it to have consistent screenshots
		// https://github.com/ariya/phantomjs/issues/10592

		// IE8 also has randomness in its font rendering...

		return getPage().getWebBrowser().getBrowserApplication()
				.contains("PhantomJS")
				|| (getPage().getWebBrowser().isIE() && getPage()
						.getWebBrowser().getBrowserMajorVersion() <= 9);
	}

	private CssLayout buildMenu() {
		// Add items

		final VerticalLayout top = new VerticalLayout();
		top.setWidth("100%");
		top.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		top.addStyleName("valo-menu-title");
		final Label title = new Label(
				"<h3>Snippets</h3>", ContentMode.HTML);
		title.setSizeUndefined();
		top.addComponent(title);
		top.setExpandRatio(title, 1);
		menu.addComponent(top);

		final MenuBar settings = new MenuBar();
		settings.addStyleName("user-menu");
		new StringGenerator();
		final User user = UserContext.getCurrentUser();
		final MenuItem settingsItem = settings.addItem(user.getFirstName() + " " + user.getLastName(),
				new ThemeResource("images/profile-pic-300px.jpg"),
				null);
		settingsItem.addItem("Sign Out", new Command() {
			private static final long serialVersionUID = -113372039137573781L;

			@Override
			public void menuSelected(MenuItem selectedItem) {
				UserContext.logoutCurrentUser();
			}
		});
		menu.addComponent(settings);

		menuItemsLayout.setPrimaryStyleName("valo-menuitems");
		menu.addComponent(menuItemsLayout);

		for (final ISnippetMenuItem item : menuProvider.getMenuItems()) {
			if (item.isNavigable()) {
				((MenuItemButton) item).addClickListener(new ClickListener() {
					private static final long serialVersionUID = -6638347383370146515L;

					@Override
					public void buttonClick(ClickEvent event) {
						navigator.navigateTo(item.getNavigationKey());
					}
				});
			}
			menuItemsLayout.addComponent(item);
		}

		return menu;
	}

}
