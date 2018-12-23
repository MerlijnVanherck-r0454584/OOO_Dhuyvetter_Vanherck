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
	
	public int[] getTotalScore() {
		int[] score = new int[2];
		score[0] = 0;
		score[1] = 0; // maxScore

		for (Category c : this.categories) {
			score[0] += c.getScore();
			score[1] += c.getQuestions().size();
		}

		return score;
	}

	public int[] getScoreForCategory(Category category) {
		int[] score = new int[2];
		score[0] = category.getScore();
		score[1] = category.getQuestions().size();

		return score;
	}

	public void isQuestionCorrect(Category category, Question question, String givenAnswer) {
		if (!category.getQuestions().contains(question))
			throw new IllegalArgumentException("question must be from the category given as parameter");

		if (question.isCorrectAnswer(givenAnswer))
			category.increaseScore();
	}
	
	public void startTest() {
		for (Category c : this.categories)
			c.setScore(0);
	}

}
