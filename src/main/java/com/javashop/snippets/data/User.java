/**
 *
 */
package com.javashop.snippets.data;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
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
@Table(name = "SNPT_USERS")
public class User extends GeneratedKeyBaseEntity {
	private static final long serialVersionUID = -5435134042376764352L;

	@Column(nullable = false, length = 64, unique = true)
	private String userName;

	@Column(nullable = false, length = 256)
	private String password;

	private boolean enabled;

	@Column(nullable = false, length = 32)
	private String firstName;

	@Column(nullable = false, length = 32)
	private String lastName;

	@Column(nullable = false, length = 128)
	private String email;

	@Enumerated(EnumType.ORDINAL)
	private Gender gender = Gender.MALE;

	private String profileImgSrc;

	@ManyToMany
	private List<Tag> tags;

	public enum Gender {
		MALE, FEMALE;
	}
}
