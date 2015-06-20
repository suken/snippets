/**
 *
 */
package com.javashop.snippets.service;

import java.util.List;

import com.javashop.snippets.data.SnippetExtInfo;
import com.javashop.snippets.data.User;
import com.javashop.snippets.data.SnippetExtInfo.InfoType;

/**
 * @author sukenshah
 *
 */
public interface ISnippetExtraInfoService extends IDaoService<SnippetExtInfo> {

	List<String> getUserNames(InfoType type, Long snippetId);

	List<User> getUsers(InfoType type, Long snippetId);
}
