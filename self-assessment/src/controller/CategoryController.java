package controller;

import java.io.FileNotFoundException;
import database.FileManager;
import model.Category;
import model.CategoryList;

public class CategoryController {
	
	private CategoryList categoryList = new CategoryList();

	public void showCategories(String fileName) throws FileNotFoundException {
		
		String categories = FileManager.readEntireFile(fileName);
		String name = "";
		String description = "";
		Boolean isName = true;
		String savedName = "";
		
		for (int i = 0; i < categories.length(); i++) {
			
			if (!(categories.charAt(i) == ';')) {
				if (isName) name += categories.charAt(i);
				else description += categories.charAt(i);
			}
			else if (categories.charAt(i) == ';') {
				if (isName) {
					savedName = name;
					name = "";
					isName = false;
				} else {
					Category category = new Category(savedName, description);
					categoryList.addCategory(category);
					isName = true;
					description = "";
				}
			}
		}
		
		
		
	}

}
