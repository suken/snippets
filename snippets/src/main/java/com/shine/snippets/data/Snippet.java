/**
 *
 */
package com.shine.snippets.data;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sukenshah
 */
@Getter
@Setter
@Entity
@Cacheable
@Table(name = "SNIPPETS")
public class Snippet extends SnippetsBaseEntity {
	private static final long serialVersionUID = -1086241690038259878L;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, length = 512)
	private String description;

	@Column(nullable = false)
	@Lob
	private String code;

	@ManyToMany
	private List<Tag> tags;

	private Integer noOfViews = 0;
	private Integer noOfLikes = 0;
	private Integer noOfComments = 0;

	public void addTag(final Tag tag) {
		tags.add(tag);
	}

}
