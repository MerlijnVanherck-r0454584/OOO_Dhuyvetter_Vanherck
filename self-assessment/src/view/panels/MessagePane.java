package view.panels;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MessagePane extends GridPane {
	private Button testButton;
	private Label results;

	public MessagePane() {
		setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		results = new Label();
		results.setText("You have not taken this test yet.");
		add(results, 0, 0, 1, 1);

		testButton = new Button("Evaluate");
		add(testButton, 0, 1, 1, 1);
		setHalignment(testButton, HPos.CENTER);
	}

	public void setTestAction(EventHandler<ActionEvent> newAction) {
		testButton.setOnAction(newAction);
	}

	public void displayResults(ArrayList<String> results) {
		this.results.setText("");
		for (String s : results)
			this.results.setText(this.results.getText() + s + "\n");
	}

}
