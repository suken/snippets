/**
 *
 */
package com.javashop.snippets.service;

import java.util.List;

import com.javashop.snippets.data.Snippet;
import com.javashop.snippets.data.SnippetSummary;
import com.javashop.snippets.data.Tag;
import com.javashop.snippets.data.User;

/**
 * @author sukenshah
 *
 */
public interface ISnippetService extends IDaoService<Snippet> {

	List<SnippetSummary> getLatestSnippets(final int numberOfSnippets);

	List<SnippetSummary> getLatestSnippets(final int numberOfSnippets,
			final Tag... tags);

	List<SnippetSummary> getPopularSnippets(final int numberOfSnippets);

	List<SnippetSummary> getUserSnippets(final int numberOfSnippets,
			final Long userId);

	void likeSnippet(final Snippet snippet, final User user);

	void unlikeSnippet(final Snippet snippet, final User user);

	void viewedSnippet(final Snippet snippet, final User user);

}
