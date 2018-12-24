package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question {
	private String questionName;
	private String[] answers; // index 0 is correct answer
	private String category; // helper string for view
	private String feedback;

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String name) {
		this.questionName = name;
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Question(String questionName, String[] answers, String category, String feedback) {
		this.questionName = questionName;
		this.answers = answers;
		this.category = category;
		this.feedback = feedback;
	}

	public Boolean isCorrectAnswer(String givenAnswer) {
		if (answers[0].equals(givenAnswer)) {
			return true;
		}
		return false;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<String> getRandomOrderAnswers() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < this.answers.length; i++)
			list.add(this.getAnswers()[i]);
		Collections.shuffle(list);
		return list;
	}

}
