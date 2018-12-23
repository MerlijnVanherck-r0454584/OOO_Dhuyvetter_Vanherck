package application;

import controller.CategoryDetailListener;
import controller.CategoryListener;
import controller.Controller;
import controller.MessageListener;
import controller.QuestionDetailListener;
import controller.QuestionListener;
import controller.TestListener;
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
	
	Controller controller = new Controller();
	
	@Override
	public void start(Stage primaryStage) {

		try {
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(controller);
			QuestionDetailPane questionDetailPane = new QuestionDetailPane(controller);

			CategoryOverviewPane categoryOverviewPane = new CategoryOverviewPane(controller);
			CategoryDetailPane categoryDetailPane = new CategoryDetailPane(controller);
			
			TestPane testPane = new TestPane();
			MessagePane messagePane = new MessagePane();

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);

			AssesMainPane assesMainPane = new AssesMainPane(messagePane, testPane, categoryOverviewPane, questionOverviewPane, questionDetailPane, categoryDetailPane);
			assesMainPane.prefHeightProperty().bind(scene.heightProperty());
			assesMainPane.prefWidthProperty().bind(scene.widthProperty());

			CategoryListener cListener = new CategoryListener(assesMainPane);
			QuestionListener qListener = new QuestionListener(assesMainPane);
			categoryOverviewPane.setNewAction(cListener);
			questionOverviewPane.setNewAction(qListener);
			
			CategoryDetailListener cdpListener = new CategoryDetailListener(categoryDetailPane, assesMainPane);
			categoryDetailPane.setSaveAction(cdpListener);
			categoryDetailPane.setCancelAction(cdpListener);
			
			QuestionDetailListener qdListener = new QuestionDetailListener(questionDetailPane, assesMainPane);
			questionDetailPane.setSaveAction(qdListener);
			questionDetailPane.setCancelAction(qdListener);
			
			MessageListener mListener = new MessageListener(controller, assesMainPane);
			messagePane.setTestAction(mListener);
			
			TestListener tListener = new TestListener(controller, testPane, assesMainPane);
			testPane.setSubmitAction(tListener);
			
			root.getChildren().add(assesMainPane);
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
	
	@Override
	public void stop() {
		controller.getDbController().storeCategories();
	}
	
}
