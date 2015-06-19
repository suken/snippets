/**
 *
 */
package com.shine.snippets.ui.menu;

import java.util.Collection;
import java.util.Map;

import com.google.gwt.thirdparty.guava.common.collect.Maps;
import com.shine.snippets.ui.SnippetDetailsView;
import com.shine.snippets.ui.listed.LatestSnippets;
import com.shine.snippets.ui.listed.MySnippets;
import com.shine.snippets.ui.listed.PopularSnippets;
import com.shine.snippets.ui.listed.TagsSnippets;
import com.shine.snippets.ui.management.TagsManagementView;
import com.shine.snippets.ui.management.UserSettingsView;
import com.shine.snippets.ui.management.UsersManagementView;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;

/**
 * @author sukenshah
 *
 */
public class MenuItemsProvider {

	private final Map<String, ISnippetMenuItem> menuItems = Maps.newLinkedHashMap();

	public MenuItemsProvider() {
		// ideally we would perform role checking to make sure correct items are rendered for the user
		menuItems.put("SnippetsSeparator", new MenuItemLabel("Snippets", ContentMode.HTML));
		menuItems.put("latest", new MenuItemButton("latest", "Latest", FontAwesome.CODE, LatestSnippets.class));
		menuItems.put("popular", new MenuItemButton("popular", "Popular", FontAwesome.STAR, PopularSnippets.class));
		menuItems.put("tags", new MenuItemButton("tags", "Tags", FontAwesome.TAG, TagsSnippets.class));
		menuItems.put("MySnippetsSeparator", new MenuItemLabel("My Stuff", ContentMode.HTML));
		menuItems.put("my-snippets", new MenuItemButton("my-snippets", "My Snippets", FontAwesome.FILES_O, MySnippets.class));
		menuItems.put("new-snippet", new MenuItemButton("new-snippet", "New", FontAwesome.FILE_CODE_O, SnippetDetailsView.class));
		menuItems.put("SettingsSeparator", new MenuItemLabel("Settings", ContentMode.HTML));
		menuItems.put("user-settings", new MenuItemButton("user-settings", "User Settings", FontAwesome.COG, UserSettingsView.class));
		menuItems.put("tags-mgmt", new MenuItemButton("tags-mgmt", "Tags Management", FontAwesome.TAGS, TagsManagementView.class));
		menuItems.put("users-mgmt", new MenuItemButton("users-mgmt", "Users Management", FontAwesome.USERS, UsersManagementView.class));
	}

	public Collection<ISnippetMenuItem> getMenuItems() {
		return menuItems.values();
	}

	public ISnippetMenuItem getMenuItem(final String key) {
		return menuItems.get(key);
	}

	public String getDefaultNavigationKey() {
		return "latest";
	}
}
