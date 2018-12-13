package application;

import controller.CategoryListener;
import controller.Controller;
import controller.QuestionListener;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.panels.AssesMainPane;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionDetailPane;
import view.panels.QuestionOverviewPane;
import view.panels.TestPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		try {
			Controller controller = new Controller();
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(controller);
			QuestionDetailPane questionDetailPane = new QuestionDetailPane();

			CategoryOverviewPane categoryOverviewPane = new CategoryOverviewPane(controller);
			CategoryDetailPane categoryDetailPanel = new CategoryDetailPane(controller);

			TestPane testPane = new TestPane();
			MessagePane messagePane = new MessagePane();

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);

			AssesMainPane borderPane = new AssesMainPane(messagePane, categoryOverviewPane, questionOverviewPane, questionDetailPane, categoryDetailPanel);
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());

			CategoryListener cListener = new CategoryListener(borderPane);
			QuestionListener qListener = new QuestionListener(borderPane);
			categoryOverviewPane.setNewAction(cListener);
			questionOverviewPane.setNewAction(qListener);
			
			root.getChildren().add(borderPane);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
