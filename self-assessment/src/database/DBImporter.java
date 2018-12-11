package database;

import java.util.ArrayList;

import model.Category;
import model.Question;

public abstract class DBImporter {
	public abstract ArrayList<Category> getCategories();

	public abstract ArrayList<Question> getQuestions(Category category);
}
