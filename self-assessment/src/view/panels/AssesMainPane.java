package view.panels;

import controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class AssesMainPane extends BorderPane {

	private Tab categoriesTab;
	private Tab questionsTab;
	private Tab categoryDetailTab;
	private Tab questionDetailTab;
	private Tab categoryOverviewTab;
	private Tab questionOverviewTab;
	private Tab messageTab;
	private Tab testTab;
	private TabPane tabPane = new TabPane();

	public AssesMainPane(Pane messagePane, Pane testPane, Pane categoryOverviewPane, Pane questionOverviewPane,
			QuestionDetailPane questionDetailPane, CategoryDetailPane categoryDetailPane) {

		FlowPane messageBox = new FlowPane(messagePane);
		messageBox.setAlignment(Pos.CENTER);
		messageTab = new Tab("Test", messageBox);
		testTab = new Tab("Test", testPane);

		categoryDetailTab = new Tab("Category", categoryDetailPane);
		questionDetailTab = new Tab("Question", questionDetailPane);

		categoryOverviewTab = new Tab("Categories", categoryOverviewPane);
		questionOverviewTab = new Tab("Questions", questionOverviewPane);

		categoriesTab = categoryOverviewTab;
		questionsTab = questionOverviewTab;

		tabPane.getTabs().add(messageTab);
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
		} else if (categoriesTab == categoryDetailTab) {
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
		} else if (questionsTab == questionDetailTab) {
			tabPane.getTabs().remove(questionsTab);
			questionsTab = questionOverviewTab;
			tabPane.getTabs().add(questionsTab);
			tabPane.getSelectionModel().select(questionsTab);
		}
	}

	public void toggleTestTab() {
		if (tabPane.getTabs().contains(testTab)) {
			tabPane.getTabs().add(messageTab);
			tabPane.getTabs().add(categoriesTab);
			tabPane.getTabs().add(questionsTab);
			tabPane.getSelectionModel().select(messageTab);
			tabPane.getTabs().remove(testTab);
		} else {
			tabPane.getTabs().clear();
			tabPane.getTabs().add(testTab);
			tabPane.getSelectionModel().select(testTab);
		}

	}
}
