/**
 *
 */
package com.javashop.snippets.service;

import java.util.List;

import com.javashop.snippets.data.SnippetExtInfo;
import com.javashop.snippets.data.SnippetExtInfo.InfoType;
import com.javashop.snippets.data.User;

/**
 * @author sukenshah
 *
 */
public interface ISnippetExtraInfoService extends IDaoService<SnippetExtInfo> {

	List<String> getUserNames(final InfoType type, final Long snippetId);

	List<User> getUsers(final InfoType type, final Long snippetId);
}
