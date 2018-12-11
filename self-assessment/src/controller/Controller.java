package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

public class Controller {
	private DbController dbController = new DbController();
	private Test test;


	public Controller() {
		test = new Test(dbController.getCategories());
		for (Category c : test.getCategories()) {
			c.initQuestions(dbController.getQuestions(c));
		}
	}
	
	public ObservableList<Category> getCategories() {
		return test.getCategories();
	}
	
	public ObservableList<Question> getQuestions() {
		ArrayList<Question> list =  new ArrayList<Question>();
		for (Category c : test.getCategories()) {
			list.addAll(c.getQuestions());
		}
		return FXCollections.observableArrayList(list);
	}
	

	
/*
	public ObservableList<Category> getMainCategories() {
		ObservableList<Category> list = FXCollections.observableArrayList(this.categoryList.getCategories());
		for (Category c : this.categories)
			if (c instanceof Subcategory)
				list.remove(c);

		return list;
	}
*/
}
