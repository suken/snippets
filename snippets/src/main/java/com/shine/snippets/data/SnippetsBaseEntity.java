/**
 *
 */
package com.shine.snippets.data;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sukenshah
 *
 */
@MappedSuperclass
public abstract class SnippetsBaseEntity extends GeneratedKeyBaseEntity {
	private static final long serialVersionUID = 1167301791118091567L;

	@Setter
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "authorId")
	private User author;

	@Getter
	@Column(name = "authorId", updatable = false, insertable = false, nullable = false)
	private Long authorId;

	@Getter
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Setter
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "modiferId")
	private User modifedBy;

	@Getter
	@Column(name = "modifierId", insertable = false, updatable = false)
	private Long modifierId;

	@Getter
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	@PreUpdate
	@PrePersist
	void modifiedTime()
	{
		modifiedOn = Calendar.getInstance().getTime();
		//		setModifier((User) SecurityContext.getAuthenticatedUser());
	}
}
