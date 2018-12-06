package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import database.TXTImporter;
import model.Category;
import model.Subcategory;

public class DbController {
	
	public void getCategories(ArrayList<Category> list) {
		try {
			ArrayList<String> text = TXTImporter.readEntireFile("testdatabase/groep.txt");
			for (int i = 0; i < text.size() / 2; i++) {
				if (text.get(i * 3 + 2) == "")
					list.add(new Category(text.get(i * 3), text.get(i * 3 + 1)));
				else
					for (Category c : list)
						if (c.getName() == text.get(i * 3 + 2))
							list.add(new Subcategory(text.get(i * 3), text.get(i * 3 + 1), c));

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
