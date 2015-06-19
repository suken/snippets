/**
 *
 */
package com.shine.snippets.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.shine.snippets.data.Snippet;
import com.shine.snippets.data.SnippetSummary;
import com.shine.snippets.data.Tag;
import com.shine.snippets.data.User;
import com.shine.snippets.service.ISnippetService;

/**
 * @author sukenshah
 */
@Component
public class SnippetServiceImpl extends BaseDaoServiceImpl<Snippet> implements ISnippetService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<SnippetSummary> getLatestSnippets(int numberOfSnippets) {
		return getAllSnippets();
	}

	@Override
	public List<SnippetSummary> getLatestSnippets(int numberOfSnippets,
			Tag... tags) {
		return getAllSnippets();
	}

	@Override
	public List<SnippetSummary> getPopularSnippets(int numberOfSnippets) {
		// TODO Auto-generated method stub
		return getAllSnippets();
	}

	@Override
	public List<SnippetSummary> getUserSnippets(int numberOfSnippets,
			Long userId) {
		return getAllSnippets();
	}

	@Override
	public void likeSnippet(Snippet snippet, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlikeSnippet(Snippet snippet, User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewedSnippet(Snippet snippet, User user) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	private List<SnippetSummary> getAllSnippets() {
		final Query query = entityManager.createQuery("select new "
				+ SnippetSummary.class.getName() + " (s.id, s.name, s.description, s.createdOn, s.authorId, s.author.userName, s.noOfViews, s.noOfLikes, s.noOfComments)"
				+ " from " + Snippet.class.getName() + " s ");
		return query.getResultList();
	}
}
