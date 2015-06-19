/**
 *
 */
package com.shine.snippets.service;

import java.util.List;

import com.shine.snippets.data.SnippetExtInfo;
import com.shine.snippets.data.SnippetExtInfo.InfoType;
import com.shine.snippets.data.User;

/**
 * @author sukenshah
 *
 */
public interface ISnippetExtraInfoService extends IDaoService<SnippetExtInfo> {

	List<String> getUserNames(InfoType type, Long snippetId);

	List<User> getUsers(InfoType type, Long snippetId);
}
