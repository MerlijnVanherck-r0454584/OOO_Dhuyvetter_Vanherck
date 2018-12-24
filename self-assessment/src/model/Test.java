package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test {
	private ObservableList<Category> categories;
	private Question currentQuestion = null;

	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

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
	
	public ArrayList<String> getScoreSummary() {
		ArrayList<String> score = new ArrayList<String>();
		
		score.add("Total: " + this.getTotalScore()[0] + "/" + this.getTotalScore()[1]);
		
		for (Category c : this.categories) {
			score.add(c.getName() + ": " + this.getScoreForCategory(c)[0] + "/" + this.getScoreForCategory(c)[1]);
		}
		
		return score;
	}

	public void checkAnswer(String givenAnswer) {
		if (this.currentQuestion.isCorrectAnswer(givenAnswer))
			this.getCategoryOfQuestion(currentQuestion).increaseScore();
	}
	
	public void startTest() {
		for (Category c : this.categories)
			c.setScore(0);
		this.currentQuestion = this.getAllQuestions().get(0);
	}
	
	public void advanceTest() {
		if (this.getAllQuestions().indexOf(currentQuestion) + 1 < this.getAllQuestions().size())
			this.currentQuestion = this.getAllQuestions().get(this.getAllQuestions().indexOf(currentQuestion) + 1);
		else
			this.currentQuestion = null;
	}

	public ArrayList<Question> getAllQuestions() {
		ArrayList<Question> list = new ArrayList<>();
		for (Category c : this.getCategories())
			list.addAll(c.getQuestions());
		return list;
	}
	
	public Category getCategoryOfQuestion(Question question) {
		for (Category c : this.getCategories())
			if (c.getQuestions().contains(question))
				return c;
		return null;
	}
}
