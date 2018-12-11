package view.panels;

import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class AssesMainPane extends BorderPane {

	Tab categoriesTab;
	Tab questionsTab;
	Tab categoryDetailTab;
	Tab questionDetailTab;
	Tab categoryOverviewTab;
	Tab questionOverviewTab;
	
	
	public AssesMainPane(Pane messagePane, Pane categoryOverviewPanel, Pane questionOverviewPanel, QuestionDetailPane questionDetailPane, CategoryDetailPane categoryDetailPanel) {
		TabPane tabPane = new TabPane();

		FlowPane messageBox = new FlowPane(messagePane);
		messageBox.setAlignment(Pos.CENTER);
		Tab testTab = new Tab("Test", messageBox);
		
		categoryDetailTab = new Tab("Category", categoryDetailPanel);
		questionDetailTab = new Tab("Categories", questionDetailPane);
		
		categoryOverviewTab = new Tab("Categories", categoryOverviewPanel);
		questionOverviewTab = new Tab("Questions", questionOverviewPanel);
		
		categoriesTab = categoryOverviewTab;
		questionsTab = questionOverviewTab;
		
		tabPane.getTabs().add(testTab);
		tabPane.getTabs().add(categoriesTab);
		tabPane.getTabs().add(questionsTab);

		this.setCenter(tabPane);
	}
	
	public void switchCategoryTab(CategoryDetailPane cdPane) {
		if (categoriesTab == categoryOverviewTab) categoriesTab = categoryDetailTab;
		if (categoriesTab == categoryDetailTab) categoriesTab = categoryOverviewTab;
	}
	
	public void switchQuestionTab(QuestionDetailPane qdPane) {
		if (questionsTab == questionOverviewTab) questionsTab = questionDetailTab;
		if (questionsTab == questionDetailTab) questionsTab = questionOverviewTab;
	}
}
