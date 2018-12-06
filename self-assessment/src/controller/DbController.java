package controller;

import java.util.ArrayList;

import database.TXTImporter;
import model.Category;
import model.Subcategory;

public class DbController {
	
	public void getCategories(ArrayList<Category> list) {
		list.addAll((new TXTImporter()).getCategories());
	}
	
	public void getQuestions() {
		
	}
}
