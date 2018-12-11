package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test {
	private ObservableList<Category> categories;

	public ObservableList<Category> getCategories() {
		return categories;
	}

	public Test(ArrayList<Category> categories) {
		this.categories = FXCollections.observableArrayList(categories);
	}
/*
	public int[] getTotalScore() {
		int[] score = new int[2];
		score[0] = 0;
		score[1] = 0; // maxScore

		for (Question q : questions) {
			score[0] += 1;
			score[1] += q.getAnswers().length;
		}

		return score;
	}
	
	public ArrayList<Question> getQuestionsOfCategory(Category category) {
		ArrayList<Question> questions = new ArrayList<>();
		
		for (Question q : this.questions)
			if (q.getCategory() == category)
				questions.add(q);
				
		return questions;
	}

	public int[] getScoreForCategory(Category category) {
		int[] score = new int[2];
		score[0] = category.getScore();
		score[1] = getQuestionsOfCategory(category).size();

		return score;
	}

	public Boolean isQuestionCorrect(Category category, Question question, String givenAnswer) {
		if (!getQuestionsOfCategory(category).contains(question))
			throw new IllegalArgumentException("question must be from the category given as parameter");

		if (question.isCorrectAnswer(givenAnswer)) {
			category.increaseScore();
			return true;
		}
		return false;

	}
*/


}
