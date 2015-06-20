/**
 *
 */
package com.javashop.snippets.data;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sukenshah
 *
 */
@Entity
@Cacheable
@Table(name = "SNPT_USER_ROLES")
public class UserRoles extends GeneratedKeyBaseEntity {
	private static final long serialVersionUID = -215790163772732059L;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<User> users;

	@Getter
	@Setter
	@Column(nullable = false, length = 64)
	private String role;
}
