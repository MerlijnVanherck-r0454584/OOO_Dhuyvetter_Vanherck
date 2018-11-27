package model;

import java.util.ArrayList;

public class CategoryList {
	private ArrayList<Category> categories;
	
	public void addCategory(Category newCategory) {
		if (categories.contains(newCategory)) throw new IllegalArgumentException(newCategory + " is already in the list");
		
		categories.add(newCategory);
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
