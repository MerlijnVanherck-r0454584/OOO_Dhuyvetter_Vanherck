package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.AssesMainPane;

public class QuestionListener implements EventHandler<ActionEvent>{

	private AssesMainPane mainPane;

	public QuestionListener(AssesMainPane mainPane) {
		this.mainPane = mainPane;
	}

	@Override
	public void handle(ActionEvent arg0) {
		mainPane.switchQuestionTab();
		
	}

}