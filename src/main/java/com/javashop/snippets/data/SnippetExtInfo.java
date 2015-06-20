/**
 *
 */
package com.javashop.snippets.data;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;

/**
 * @author sukenshah
 *
 */
@Entity
@Cacheable
@Table(name = "SNPT_EXTNFO")
public class SnippetExtInfo extends SnippetsBaseEntity {
	private static final long serialVersionUID = 8567148825127261831L;

	@Getter
	@Enumerated(EnumType.ORDINAL)
	private final InfoType type;

	@Getter
	@Column(name = "userId", insertable = false, updatable = false, nullable = false)
	private final Long userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId")
	private final User user;

	@Getter
	@Column(name = "snippetId", insertable = false, updatable = false, nullable = false)
	private final Long snippetId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "snippetId")
	private final Snippet snippet;

	public SnippetExtInfo(InfoType type, User user, Snippet snippet) {
		this.type = type;
		this.user = user;
		userId = user.getId();
		this.snippet = snippet;
		snippetId = snippet.getId();
	}

	public enum InfoType {
		LIKE,
		VIEWS;
	}
}
