package model;

import java.util.ArrayList;

public class Test {

	private ArrayList<Question> questions;

	public Test(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	
	
	public int[] getTotalScore() {
		int[] score = new int[2];
		score[0] = 0;
		score[1] = 0; //maxScore
		
		for (Question q : questions) {		
			score[0] += 1;
			score[1] += category.getQuestions().size();
		}
		
		return score;	
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}



	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}



	public int[] getScoreForCategory(Category category) {
		int[] score = new int[2];		
		score[0] = category.getScore();
		score[1] = category.getQuestions().size();
		
		return score;	
	}
	
	public Boolean isQuestionCorrect(Category category, Question question, String givenAnswer) {
		if (!category.getQuestions().contains(question)) throw new IllegalArgumentException("question must be from the category given as parameter");
		
		if (question.isCorrectAnswer(givenAnswer)) {
			category.increaseScore();
			return true;
		}
		return false;
			
	}

}
