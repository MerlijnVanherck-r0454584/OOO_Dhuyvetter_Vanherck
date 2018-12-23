package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import view.panels.AssesMainPane;

public class TestListener implements EventHandler<ActionEvent> {
	
	Pane testPane;
	Controller controller;
	Pane assesMainPane;

	public TestListener(Controller controller, Pane testPane, Pane assesMainPane) {
		this.controller = controller;
		this.testPane = testPane;
		this.assesMainPane = assesMainPane;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		
		
	}
	
}
