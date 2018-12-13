package controller;

import java.util.ArrayList;

import database.DBImporter;
import database.TXTImporter;
import model.Category;
import model.Question;
import model.Subcategory;

public class DbController {
	
	private DBImporter importer = new TXTImporter(); 

	public ArrayList<Category> getCategories() {
		return importer.getCategories();
	}
	
	public ArrayList<Question> getQuestions(Category c) {
		return importer.getQuestions(c);
	}

	public void storeCategories() {
		// TODO Auto-generated method stub
	}
}
