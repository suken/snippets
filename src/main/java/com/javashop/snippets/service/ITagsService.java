/**
 *
 */
package com.javashop.snippets.service;

import java.util.List;

import com.javashop.snippets.data.Tag;

/**
 * @author sukenshah
 *
 */
public interface ITagsService extends IDaoService<Tag> {

	List<Tag> getTags(Long userId);

}
