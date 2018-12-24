package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import view.panels.AssesMainPane;
import view.panels.TestPane;

public class MessageListener implements EventHandler<ActionEvent> {
	private AssesMainPane assesMainPane;
	private Controller controller;
	private TestPane testPane;

	public MessageListener(Controller controller, TestPane testPane, AssesMainPane assesMainPane) {
		this.assesMainPane = assesMainPane;
		this.controller = controller;
		this.testPane = testPane;
	}

	@Override
	public void handle(ActionEvent event) {
		controller.getTest().startTest();
		testPane.setQuestion(controller.getTest().getCurrentQuestion());
		this.assesMainPane.toggleTestTab();
	}

}
