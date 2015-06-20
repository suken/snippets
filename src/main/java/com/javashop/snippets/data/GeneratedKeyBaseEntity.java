/**
 *
 */
package com.javashop.snippets.data;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

/**
 * @author sukenshah
 *
 */
@MappedSuperclass
public class GeneratedKeyBaseEntity implements Serializable {

	private static final long serialVersionUID = 8616233817311366333L;

	@Getter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
