/**
 *
 */
package com.shine.snippets.service;

import java.util.List;

import com.shine.snippets.data.Snippet;
import com.shine.snippets.data.SnippetSummary;
import com.shine.snippets.data.Tag;
import com.shine.snippets.data.User;

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
