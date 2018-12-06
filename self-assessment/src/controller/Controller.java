package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.CategoryList;
import model.Question;
import model.Test;

public class Controller {
	private ObservableList<Category> categories;
	private DbController dbController = new DbController();
	private CategoryList categoryList = new CategoryList();
	private ArrayList<Question> questions = new ArrayList<Question>();
	private Test test = new Test(categoryList);

	public ObservableList<Category> getCategories() {
		return categories;
	}
	
	public Controller() {
		update(test.getCategories());
	}

	public void update(CategoryList categoryList) {
		dbController.getCategories(categoryList.getCategories());
		this.categories = FXCollections.observableArrayList(test.getCategories().getCategories());
	}
	
}
