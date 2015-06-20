/**
 *
 */
package com.javashop.snippets;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.javashop.snippets.data.User;


/**
 * @author sukenshah
 *
 */
@Service
public class Bootstrap {

	private static final Logger LOGGER = LoggerFactory.getLogger(Bootstrap.class.getName());

	//	@Resource
	//	private IUserService userService;

	private boolean enabled = false;
	private String resourcePath;

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setResourcePath(String path) {
		resourcePath = path;
	}

	@Transactional
	public void start() {
		if (!enabled)
			return;

		try {
			loadUsers();
		} catch (final IOException exception) {
			LOGGER.error("Error in loading databootstrap." + exception);
		}
	}

	private void loadUsers() throws IOException {
		final CsvToBean<User> csvUserBeanMapper = new CsvToBean<User>();
		final CSVReader reader = new CSVReader(new FileReader(new File(resourcePath + File.pathSeparator + "Users.csv")));
		final ColumnPositionMappingStrategy<User> mappingStrategy = new ColumnPositionMappingStrategy<User>();
		mappingStrategy.setType(User.class);
		mappingStrategy.setColumnMapping(new String[]{"id", "uname", "firstName", "lastName"});

		final List<User> users = csvUserBeanMapper.parse(mappingStrategy, reader);
		// save all users
		for (final User user : users) {
			//			userService.create(user);
		}
	}
}
