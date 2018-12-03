package controller;

import database.FileManager;

public class DbController {

	private FileManager fileManager = new FileManager();
	private CategoryController categoryC = new CategoryController();
	
	public FileManager getFileManager() {
		return fileManager;
	}

	public void setFileManager(FileManager fileManager) {
		this.fileManager = fileManager;
	}

	public CategoryController getCategoryC() {
		return categoryC;
	}

	public void setCategoryC(CategoryController categoryC) {
		this.categoryC = categoryC;
	}
	
}
