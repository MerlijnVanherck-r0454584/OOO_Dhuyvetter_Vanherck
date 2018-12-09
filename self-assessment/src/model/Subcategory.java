package model;

import java.util.ArrayList;

public class Subcategory extends Category {
	
	private Category mainCategory;

	public Subcategory(String name, String description, Category mainCategory) {
		super(name, description);
		this.setMainCategory(mainCategory);
	}

	public Category getMainCategory() {
		return mainCategory;
	}

	public void setMainCategory(Category mainCategory) {
		this.mainCategory = mainCategory;
	}

}
