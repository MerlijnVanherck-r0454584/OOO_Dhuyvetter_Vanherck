package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import view.panels.AssesMainPane;

public class CategoryListener implements EventHandler<ActionEvent>{

	private AssesMainPane mainPane;

	public CategoryListener(AssesMainPane mainPane) {
		this.mainPane = mainPane;
	}

	@Override
	public void handle(ActionEvent arg0) {
		mainPane.switchCategoryTab();
	}

}
