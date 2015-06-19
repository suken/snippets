/**
 *
 */
package com.shine.snippets.ui.listed;

import java.util.List;

import com.google.gwt.thirdparty.guava.common.collect.Lists;
import com.shine.snippets.data.SnippetSummary;
import com.shine.snippets.data.Tag;
import com.shine.snippets.service.ISnippetService;
import com.shine.snippets.service.ServiceRegistry;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

/**
 * @author sukenshah
 *
 */
public abstract class AbstractSnippetsContent extends VerticalLayout implements View {

	private static final long serialVersionUID = -2882762563411705355L;
	private static final int PAGE_SIZE = 10;

	private final ContentType type;
	private final ISnippetService snippetService = ServiceRegistry.getService(ISnippetService.class);
	private final int size = PAGE_SIZE;

	public AbstractSnippetsContent() {
		type = getType();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		final List<SnippetSummary> snippets = Lists.newArrayList();
		if (ContentType.LATEST == type)
			snippets.addAll(snippetService.getLatestSnippets(size));
		else if (ContentType.POPULAR ==type)
			snippets.addAll(snippetService.getLatestSnippets(size, new Tag[]{}));
		else if (ContentType.MY_SNIPPETS == type)
			snippets.addAll(snippetService.getUserSnippets(size, 0l));

		removeAllComponents();
		for (final SnippetSummary snippet : snippets) {
			addComponent(new SnippetSummaryPanel(snippet));
		}

		if (snippets.isEmpty())
			new Notification("No snippets found", Type.HUMANIZED_MESSAGE).show(Page.getCurrent());
	}

	abstract protected ContentType getType();

	public enum ContentType {
		LATEST,
		POPULAR,
		TAGS,
		MY_SNIPPETS;
	}
}
