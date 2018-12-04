package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import database.FileManager;
import model.Category;

public class DbController {

	private FileManager fileManager = new FileManager();
	private Controller categoryC = new Controller();
	
	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public Controller getCategoryC() {
		return categoryC;
	}

	public void setCategoryC(Controller categoryC) {
		this.categoryC = categoryC;
	}
	
	public void getCategories(ArrayList<Category> list) {
		try {
			ArrayList<String> text = FileManager.readEntireFile("testdatabase/groep.txt");
			for (int i = 0; i < text.size() / 2; i++) {
				list.add(new Category(text.get(i * 2), text.get(i * 2 + 1)));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
