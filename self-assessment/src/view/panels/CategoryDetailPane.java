package view.panels;

import controller.CategoryDetailListener;
import controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Category;
import model.Subcategory;

public class CategoryDetailPane extends GridPane {
	private Button btnOK, btnCancel;
	private TextField titleField, descriptionField;
	private ComboBox categoryField;
	private Controller controller;

	public CategoryDetailPane(Controller controller) {
		this.controller = controller;
		this.setPrefHeight(150);
		this.setPrefWidth(300);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Title:"), 0, 0, 1, 1);
		titleField = new TextField();
		this.add(titleField, 1, 0, 1, 1);

		this.add(new Label("Description:"), 0, 1, 1, 1);
		descriptionField = new TextField();
		this.add(descriptionField, 1, 1, 1, 1);

		this.add(new Label("Main Category:"), 0, 2, 1, 1);
		categoryField = new ComboBox<>();
		this.add(categoryField, 1, 2, 1, 1);
		categoryField.setItems(controller.getMainCategoryNames());

		btnCancel = new Button("Cancel");
		this.add(btnCancel, 0, 3, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		this.add(btnOK, 1, 3, 1, 1);

	}

	public String getTitleFieldContents() {
		return titleField.getText();
	}

	public String getDescriptionFieldContents() {
		return descriptionField.getText();
	}

	public String getCategoryField() {
		return (String) categoryField.getSelectionModel().getSelectedItem();
	}

	public Button getBtnOK() {
		return btnOK;
	}

	public Button getBtnCancel() {
		return btnCancel;
	}

	public void emptyFields() {
		titleField.clear();
		descriptionField.clear();
		categoryField.getSelectionModel().clearSelection();
	}

	public void setSaveAction(EventHandler<ActionEvent> saveAction) {
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction(EventHandler<ActionEvent> cancelAction) {
		btnCancel.setOnAction(cancelAction);
	}

	public Controller getController() {
		return this.controller;
	}

}
