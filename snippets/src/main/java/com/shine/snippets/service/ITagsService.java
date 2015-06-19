/**
 *
 */
package com.shine.snippets.service;

import java.util.List;

import com.shine.snippets.data.Tag;

/**
 * @author sukenshah
 *
 */
public interface ITagsService extends IDaoService<Tag> {

	List<Tag> getTags(Long userId);

}
