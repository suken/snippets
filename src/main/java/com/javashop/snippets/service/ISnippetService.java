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

	List<SnippetSummary> getLatestSnippets(int numberOfSnippets);

	List<SnippetSummary> getLatestSnippets(int numberOfSnippets, Tag...tags);

	List<SnippetSummary> getPopularSnippets(int numberOfSnippets);

	List<SnippetSummary> getUserSnippets(int numberOfSnippets, Long userId);

	void likeSnippet(Snippet snippet, User user);

	void unlikeSnippet(Snippet snippet, User user);

	void viewedSnippet(Snippet snippet, User user);

}
