/**
 *
 */
package com.shine.snippets.data;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sukenshah
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class SnippetSummary implements Serializable {

	private static final long serialVersionUID = 4384778208962963979L;

	private Long id;
	private String name;
	private String description;
	private Date createdOn;
	private Long authorId;
	private String authorName;
	private Integer views = 0;
	private Integer likes = 0;
	private Integer comments = 0;
}
