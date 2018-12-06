package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.CategoryList;

public class Controller {
	private ObservableList<Category> categories;
	private DbController dbController = new DbController();
	private CategoryList categoryList = new CategoryList();

	public ObservableList<Category> getCategories() {
		return categories;
	}
	
	public Controller() {
		update(this.categoryList);
	}

	public void update(CategoryList categoryList) {
		dbController.getCategories(categoryList.getCategories());
		this.categories = FXCollections.observableArrayList(this.categoryList.getCategories());
	}
	
}
