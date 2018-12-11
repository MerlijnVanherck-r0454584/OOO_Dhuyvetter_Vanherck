package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Category {
	private String name;
	private String description;
	private ObservableList<Question> questions;

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

	public Category(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void addQuestion (Question question) {
		questions.add(question);
	}
	
	public void initQuestions(ArrayList<Question> questions) {
		this.questions = FXCollections.observableArrayList(questions);
	}

	public ObservableList<Question> getQuestions() {
		return questions;
	}

	
}
