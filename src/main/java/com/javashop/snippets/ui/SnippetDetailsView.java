/**
 *
 */
package com.javashop.snippets.ui;

import org.vaadin.aceeditor.AceEditor;
import org.vaadin.aceeditor.AceMode;
import org.vaadin.aceeditor.AceTheme;

import com.javashop.snippets.UserContext;
import com.javashop.snippets.data.Snippet;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author sukenshah
 */
public class SnippetDetailsView extends VerticalLayout implements View {
	private static final long serialVersionUID = 6018937339643928340L;
	private static final String ACE_EDITOR_PATH = "/snippets/static/ace";

	private boolean initialized = false;

	private void init() {
		if (initialized)
			return;

		initialized = true;

		final FormLayout layout = new FormLayout();
		layout.setMargin(true);

		// add left panel
		final TextField nameField = new TextField("Name");
		nameField.setWidth("40%");
		layout.addComponent(nameField);

		final TextArea descriptionField = new TextArea("Description");
		descriptionField.setWidth("70%");
		layout.addComponent(descriptionField);

		// add right panel
		final AceEditor editorField = new AceEditor();
		editorField.setCaption("Snippet");
		editorField.setThemePath(ACE_EDITOR_PATH);
		editorField.setModePath(ACE_EDITOR_PATH);
		editorField.setWorkerPath(ACE_EDITOR_PATH);
		editorField.setMode(AceMode.java);
		editorField.setTheme(AceTheme.eclipse);
		editorField.setUseWorker(true);
		editorField.setImmediate(true);
		editorField.setWordWrap(false);
		editorField.setReadOnly(false);
		editorField.setShowInvisibles(false);
		editorField.setWidth("70%");

		final GridLayout editorOptions = new GridLayout(2, 1);

		final ComboBox modes = new ComboBox("Languages");
		modes.addItems(AceMode.values());
		modes.setValue(AceMode.java);
		modes.setNullSelectionAllowed(false);
		modes.addValueChangeListener((event) -> {
			editorField.setMode((AceMode) event.getProperty().getValue());
		});
		editorOptions.addComponent(modes, 0, 0);

		final ComboBox themes = new ComboBox("Themes");
		themes.addItems(AceTheme.values());
		themes.setValue(AceTheme.eclipse);
		themes.setNullSelectionAllowed(false);
		themes.addValueChangeListener((event) -> {
			editorField.setTheme((AceTheme) event.getProperty().getValue());
		});
		editorOptions.addComponent(themes, 1, 0);
		editorOptions.setSpacing(true);
		editorOptions.setMargin(new MarginInfo(false, false, true, false));
		layout.addComponent(editorOptions);

		layout.addComponent(editorField);

		final BeanFieldGroup<Snippet> fieldGroup = new BeanFieldGroup<Snippet>(
				Snippet.class);
		final Snippet snippet = new Snippet();
		snippet.setAuthor(UserContext.getCurrentUser());
		snippet.setName("");
		snippet.setDescription("");
		fieldGroup.setItemDataSource(snippet);
		fieldGroup.bind(nameField, "name");
		fieldGroup.bind(descriptionField, "description");
		fieldGroup.bind(editorField, "code");

		final GridLayout buttonPanel = new GridLayout(2, 1);
		final Button okButton = new Button("Ok", (event) -> {
			try {
				fieldGroup.commit();
				// make service call here to save the data
			} catch (final CommitException exception) {
				new Notification("Error while saving snippet. Exception = "
						+ exception, Type.ERROR_MESSAGE).show(Page
								.getCurrent());
			}
		});
		buttonPanel.addComponent(okButton, 0, 0);

		final Button cancelButton = new Button("Cancel", (event) -> {
			fieldGroup.discard();
		});
		buttonPanel.addComponent(cancelButton, 1, 0);
		buttonPanel.setSpacing(true);
		layout.addComponent(buttonPanel);

		addComponent(layout);
	}

	@Override
	public void enter(final ViewChangeEvent event) {
		init();
	}

}
