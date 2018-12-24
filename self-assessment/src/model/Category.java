package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Category {
	private String name;
	private String description;
	private ObservableList<Question> questions;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void addQuestion(Question question) {
		question.setCategory(this.name); // ensure consistency for the helper string
		questions.add(question);
	}

	public void initQuestions(ArrayList<Question> questions) {
		this.questions = FXCollections.observableArrayList(questions);
	}

	public ObservableList<Question> getQuestions() {
		return questions;
	}

	public void increaseScore() {
		this.score++;
	}

}
