package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.AssesMainPane;

public class MessageListener implements EventHandler<ActionEvent> {
	private AssesMainPane assesMainPane;
	private Controller controller;
	
	public MessageListener(Controller controller, AssesMainPane assesMainPane) {
		this.assesMainPane = assesMainPane;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		controller.getTest().startTest();
		this.assesMainPane.toggleTestTab();
	}

}
