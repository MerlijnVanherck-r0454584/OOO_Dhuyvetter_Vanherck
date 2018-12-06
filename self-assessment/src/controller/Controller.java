package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Category;
import model.Subcategory;
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
	
	public ObservableList<Category> getMainCategories() {
		ObservableList<Category> list = FXCollections.observableArrayList(this.categoryList.getCategories());
		for (Category c : this.categories)
			if (c instanceof Subcategory)
				list.remove(c);
		
		return list;
	}

	public ObservableList<Question> getQuestions() {
		ArrayList<Question> questions = new ArrayList<>();
		for (Category c : this.categoryList.getCategories())
			for (Question q : c.getQuestions())
				questions.add(q);
		
		ObservableList<Question> list = FXCollections.observableArrayList(questions);
		
		return list;
	}
}
