/**
 *
 */
package com.shine.snippets.data;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sukenshah
 *
 */
@Getter
@Setter
@Entity
@Cacheable
@Table(name = "SNPT_COMMENTS")
public class Comment extends SnippetsBaseEntity {
	private static final long serialVersionUID = 4857541007444341205L;

	@Column(nullable = false, length = 512)
	private String text;
}
