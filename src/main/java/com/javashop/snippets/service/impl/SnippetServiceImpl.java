/**
 *
 */
package com.javashop.snippets.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.javashop.snippets.data.Snippet;
import com.javashop.snippets.data.SnippetSummary;
import com.javashop.snippets.data.Tag;
import com.javashop.snippets.data.User;
import com.javashop.snippets.service.ISnippetService;

/**
 * @author sukenshah
 */
@Component
public class SnippetServiceImpl extends BaseDaoServiceImpl<Snippet> implements
ISnippetService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SnippetSummary> getLatestSnippets(final int numberOfSnippets) {
		return getAllSnippets();
	}

	@Override
	public List<SnippetSummary> getLatestSnippets(final int numberOfSnippets,
			final Tag... tags) {
		return getAllSnippets();
	}

	@Override
	public List<SnippetSummary> getPopularSnippets(final int numberOfSnippets) {
		// TODO Auto-generated method stub
		return getAllSnippets();
	}

	@Override
	public List<SnippetSummary> getUserSnippets(final int numberOfSnippets,
			final Long userId) {
		return getAllSnippets();
	}

	@Override
	public void likeSnippet(final Snippet snippet, final User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlikeSnippet(final Snippet snippet, final User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewedSnippet(final Snippet snippet, final User user) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	private List<SnippetSummary> getAllSnippets() {
		final Query query = entityManager
				.createQuery("select new "
						+ SnippetSummary.class.getName()
						+ " (s.id, s.name, s.description, s.createdOn, s.authorId, s.author.userName, s.noOfViews, s.noOfLikes, s.noOfComments)"
						+ " from " + Snippet.class.getName() + " s ");
		return query.getResultList();
	}
}
