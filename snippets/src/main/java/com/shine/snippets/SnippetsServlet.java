/**
 *
 */
package com.shine.snippets;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.shine.snippets.ui.dashboard.Dashboard;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

/**
 * @author sukenshah
 */
@WebServlet(urlPatterns = "/*",
name = "SnippetsServlet", asyncSupported = true, loadOnStartup = 1, //
initParams = {
		@WebInitParam(name = "contextConfigLocation", value = "/WEB-INF/applicationContext.xml")
})
@VaadinServletConfiguration(ui = Dashboard.class, productionMode = false)
@Theme("Valo")
public class SnippetsServlet extends VaadinServlet {
	private static final long serialVersionUID = -7368058834155992415L;
}
