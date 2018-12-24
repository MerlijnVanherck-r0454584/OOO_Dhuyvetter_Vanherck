package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.AssesMainPane;
import view.panels.MessagePane;
import view.panels.TestPane;

public class TestListener implements EventHandler<ActionEvent> {
	TestPane testPane;
	Controller controller;
	AssesMainPane assesMainPane;
	MessagePane messagePane;

	public TestListener(Controller controller, TestPane testPane, MessagePane messagePane, AssesMainPane assesMainPane) {
		this.controller = controller;
		this.testPane = testPane;
		this.assesMainPane = assesMainPane;
		this.messagePane = messagePane;
	}

	@Override
	public void handle(ActionEvent arg0) {
		if (testPane.getAnswer() == null)
			return;
		
		controller.getTest().checkAnswer(testPane.getAnswer());
		controller.getTest().advanceTest();
		testPane.clearFields();
		
		if (controller.getTest().getCurrentQuestion() != null)
			testPane.setQuestion(controller.getTest().getCurrentQuestion());
		else {
			messagePane.displayResults(controller.getTest().getScoreSummary());
			assesMainPane.toggleTestTab();
		}
	}

}
