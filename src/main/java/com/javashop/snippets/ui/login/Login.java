/**
 *
 */
package com.javashop.snippets.ui.login;

import com.google.gwt.thirdparty.guava.common.base.Strings;
import com.javashop.snippets.UserContext;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * @author sukenshah
 *
 */
@Theme("snippetstheme")
@Widgetset("com.javashop.snippets.SnippetsWidgetset")
public class Login extends UI {
	private static final long serialVersionUID = -7335473977417116384L;

	@Override
	protected void init(VaadinRequest request) {
		final GridLayout layout = new GridLayout(3, 5);

		final Panel panel = new Panel();
		final VerticalLayout panelLayout = new VerticalLayout();
		panel.setContent(panelLayout);
		panel.setStyleName("loginPanel");
		panel.setWidth("30%");

		final Label top = new Label("<center><h2>Snippets <strong>"+ FontAwesome.CODE.getHtml() +"</strong></h2></center>", ContentMode.HTML);
		top.setStyleName("snpt-header");
		top.setWidth("45%");
		panelLayout.addComponent(top);

		final VerticalLayout form = new VerticalLayout();
		form.setStyleName("loginForm");
		form.setWidth("100%");

		final TextField userNameField = new TextField();
		userNameField.setDescription("UserName");
		userNameField.setSizeFull();
		userNameField.setStyleName("userNameField");
		form.addComponent(userNameField);

		final PasswordField passwordField = new PasswordField();
		passwordField.setDescription("Password");
		passwordField.setSizeFull();
		passwordField.setStyleName("passwordField");
		form.addComponent(passwordField);
		form.setMargin(false);
		panelLayout.addComponent(form);

		final Button loginButton = new Button("Login", new Button.ClickListener() {
			private static final long serialVersionUID = -5071326681572279585L;

			@Override
			public void buttonClick(ClickEvent event) {
				login(userNameField.getValue(), passwordField.getValue());
			}
		});
		loginButton.setStyleName("loginButton");
		form.addComponent(loginButton);

		final Button registerButton = new Button("Register", new Button.ClickListener() {
			private static final long serialVersionUID = -8164303717542148830L;

			@Override
			public void buttonClick(ClickEvent event) {
				new Notification("Under construction", Type.HUMANIZED_MESSAGE).show(Page.getCurrent());
			}
		});
		registerButton.setStyleName("loginButton");
		form.addComponent(registerButton);
		layout.addComponent(panel, 1, 2, 2, 3);

		final HorizontalLayout bottom = new HorizontalLayout();
		final Label vaadinLogo = new Label("}>", ContentMode.HTML);
		vaadinLogo.setDescription("Vaadin");
		vaadinLogo.setStyleName("logoStyle");
		bottom.addComponent(vaadinLogo);
		final Label springLogo = new Label(FontAwesome.LEAF.getHtml(), ContentMode.HTML);
		springLogo.setDescription("Spring");
		springLogo.setStyleName("logoStyle");
		bottom.addComponent(springLogo);
		final Label hibernateLogo = new Label(FontAwesome.DATABASE.getHtml(), ContentMode.HTML);
		hibernateLogo.setDescription("Hibernate");
		hibernateLogo.setStyleName("logoStyle");
		bottom.addComponent(hibernateLogo);
		final Label devLogo = new Label(FontAwesome.COFFEE.getHtml(), ContentMode.HTML);
		devLogo.setDescription("Java");
		devLogo.setStyleName("logoStyle");
		bottom.addComponent(devLogo);
		bottom.setSizeFull();
		layout.addComponent(bottom, 2, 4);

		layout.setColumnExpandRatio(0, 0.2f);
		layout.setColumnExpandRatio(1, 0.6f);
		layout.setColumnExpandRatio(2, 0.2f);

		layout.setSizeFull();
		setContent(layout);
		setStyleName("loginstyle");
	}

	private void login(final String userName, final String password) {
		if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password)) {
			new Notification("Empty user name.", Type.ERROR_MESSAGE).show(Page.getCurrent());
			return;
		}
		UserContext.login(userName, password);
	}
}
