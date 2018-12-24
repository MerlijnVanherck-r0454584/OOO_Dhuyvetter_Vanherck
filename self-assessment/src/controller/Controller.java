package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

public class Controller {
	private DbController dbController = new DbController();
	private Test test;

	public Test getTest() {
		return test;
	}

	public Controller() {
		test = new Test(dbController.getCategories());
		for (Category c : test.getCategories()) {
			c.initQuestions(dbController.getQuestions(c));
		}
		if (dbController.checkUseFeedback())
			test.toggleUseFeedback();
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
	
	public ObservableList<String> getCategoryNames() {
		ArrayList<String> list = new ArrayList<String>();
		
		for (Category c : getCategories())
			list.add(c.getName());
		
		return FXCollections.observableArrayList(list);
	}
	
	public ObservableList<String> getMainCategoryNames() {
		ArrayList<String> list = new ArrayList<String>();
		
		for (Category c : getCategories()) {
			if (!(c instanceof Subcategory)) {
				list.add(c.getName());
			}
		}
		
		return FXCollections.observableArrayList(list);
	}
	

	public Category getCategoryFromName(String text) {
		for (Category c : getCategories()) {
			if (c.getName().equals(text))
				return c;
		}
		return null;
	}
	
	public DbController getDbController() {
		return dbController;
	}
}
