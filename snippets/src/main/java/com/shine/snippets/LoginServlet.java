/**
 *
 */
package com.shine.snippets;

import javax.servlet.annotation.WebServlet;

import com.shine.snippets.ui.login.Login;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

/**
 * @author sukenshah
 *
 */
@WebServlet(urlPatterns = "/snpt/login/*", asyncSupported = true, loadOnStartup = 1)
@VaadinServletConfiguration(ui = Login.class, productionMode = false)
@Theme("Valo")
public class LoginServlet extends VaadinServlet {
	private static final long serialVersionUID = -5391851706083722958L;

}
