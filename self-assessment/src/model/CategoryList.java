package model;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class CategoryList {
	private ArrayList<Category> categories = new ArrayList<>();
	
	public void addCategory(Category category) {
		if (categories.contains(category)) throw new IllegalArgumentException(category + " is already in the list");
		
		categories.add(category);
	}
	
	public void removeCategory(Category category) {
		if (!categories.contains(category)) throw new IllegalArgumentException(category + " is not in the list");
		
		categories.remove(category);
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}
}
