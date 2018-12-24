package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Category;
import model.Question;
import view.panels.AssesMainPane;
import view.panels.QuestionDetailPane;

public class QuestionDetailListener implements EventHandler<ActionEvent> {

	private QuestionDetailPane qdPane;
	private AssesMainPane assesMainPane;
	
	public QuestionDetailListener(QuestionDetailPane questionDetailPane, AssesMainPane assesMainPane) {
		qdPane = questionDetailPane;
		this.assesMainPane = assesMainPane;
	}

	@Override
	public void handle(ActionEvent event) {
		Question question;
		if (event.getSource() == qdPane.getBtnOK()) {
			question = new Question(qdPane.getQuestionField().getText(), qdPane.getStatementsArea().getText().split("\n"), (String) qdPane.getCategoryField().getSelectionModel().getSelectedItem(), qdPane.getFeedbackField().getText());
			
			for (Category c : qdPane.getController().getCategories()) {
				if (c.equals(qdPane.getController().getCategoryFromName(question.getCategory())))
					c.addQuestion(question);
			}
		}
		qdPane.emptyFields();
		assesMainPane.switchQuestionTab();
		
	}

}
