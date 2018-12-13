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
	TabPane tabPane = new TabPane();
	
	
	public AssesMainPane(Pane messagePane, Pane categoryOverviewPane, Pane questionOverviewPane, QuestionDetailPane questionDetailPane, CategoryDetailPane categoryDetailPane) {

		FlowPane messageBox = new FlowPane(messagePane);
		messageBox.setAlignment(Pos.CENTER);
		Tab testTab = new Tab("Test", messageBox);
		
		categoryDetailTab = new Tab("Category", categoryDetailPane);
		questionDetailTab = new Tab("Question", questionDetailPane);
		
		categoryOverviewTab = new Tab("Categories", categoryOverviewPane);
		questionOverviewTab = new Tab("Questions", questionOverviewPane);
		
		categoriesTab = categoryOverviewTab;
		questionsTab = questionOverviewTab;
		
		tabPane.getTabs().add(testTab);
		tabPane.getTabs().add(categoriesTab);
		tabPane.getTabs().add(questionsTab);

		this.setCenter(tabPane);
	}
	
	public void switchCategoryTab() {
		if (categoriesTab == categoryOverviewTab) {
			
			tabPane.getTabs().remove(categoriesTab);
			categoriesTab = categoryDetailTab;
			tabPane.getTabs().add(categoriesTab);
			tabPane.getSelectionModel().select(categoriesTab);
		}
		else if (categoriesTab == categoryDetailTab) {
			tabPane.getTabs().remove(categoriesTab);
			categoriesTab = categoryOverviewTab;
			tabPane.getTabs().add(categoriesTab);
			tabPane.getSelectionModel().select(categoriesTab);
		}
	}
	
	public void switchQuestionTab() {
		if (questionsTab == questionOverviewTab) {
			
			tabPane.getTabs().remove(questionsTab);
			questionsTab = questionDetailTab;
			tabPane.getTabs().add(questionsTab);
			tabPane.getSelectionModel().select(questionsTab);
		}
		else if (questionsTab == questionDetailTab) {
			tabPane.getTabs().remove(questionsTab);
			questionsTab = questionOverviewTab;
			tabPane.getTabs().add(questionsTab);
			tabPane.getSelectionModel().select(questionsTab);
		}
	}
}
