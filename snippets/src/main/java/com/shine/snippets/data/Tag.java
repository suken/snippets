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
@Table(name = "SNPT_TAGS")
public class Tag extends SnippetsBaseEntity {
	private static final long serialVersionUID = -1527517251433460463L;

	@Column(nullable = false, length = 20)
	private String tagName;

	@Column(nullable = false, length = 256)
	private String description;
}
