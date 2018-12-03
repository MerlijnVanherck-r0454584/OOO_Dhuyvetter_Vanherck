package model;

import javafx.collections.ObservableList;

public class CategoryList {
	private ObservableList<Category> categories;
	
	public void addCategory(Category category) {
		if (categories.contains(category)) throw new IllegalArgumentException(category + " is already in the list");
		
		categories.add(category);
	}
	
	public void removeCategory(Category category) {
		if (!categories.contains(category)) throw new IllegalArgumentException(category + " is not in the list");
		
		categories.remove(category);
	}

	public ObservableList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ObservableList<Category> categories) {
		this.categories = categories;
	}
}
