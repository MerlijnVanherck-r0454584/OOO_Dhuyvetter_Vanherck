package view.panels;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Question;

public class TestPane extends GridPane {
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;

	public TestPane() {
		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		questionField = new Label();
		add(questionField, 0, 0, 1, 1);

		statementGroup = new ToggleGroup();

		submitButton = new Button("Submit");
		add(submitButton, 0, 11, 1, 1);
	}

	public void setProcessAnswerAction(EventHandler<ActionEvent> processAnswerAction) {
		submitButton.setOnAction(processAnswerAction);
	}

	public String getAnswer() {
		if (statementGroup.getSelectedToggle() == null)
			return null;
		return ((RadioButton) statementGroup.getSelectedToggle()).getText();
	}
	
	public void setQuestion(Question question) {
		RadioButton rb;
		this.questionField.setText(question.getQuestionName());
		int i = 1;
		for (String s : question.getRandomOrderAnswers()) {
			rb = new RadioButton(s);
			this.statementGroup.getToggles().add(rb);
			add(rb, 0, i++, 2, 1);
		}
	}

	public void clearFields() {
		this.questionField.setText("");
		for (Toggle t : this.statementGroup.getToggles())
			this.getChildren().remove(t);

		this.statementGroup.getToggles().clear();
	}
}
