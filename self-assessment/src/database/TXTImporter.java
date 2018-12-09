package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import model.Category;
import model.Question;
import model.Subcategory;

public class TXTImporter extends DBImporter {
	
	public static ArrayList<String> readLines(String fileName) {
		ArrayList<String> fileText = new ArrayList<>();
		
		try {
			Scanner fileReader = new Scanner(new File(fileName));
			
			while(fileReader.hasNextLine())
			{
			   fileText.add(fileReader.nextLine());
			}
				
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileText;
	}
	
	public static void writeToFile(String fileName, String textToWrite) throws IOException {
		Writer fileWriter = new FileWriter(fileName, true);
		
		fileWriter.write(textToWrite);
		
		fileWriter.close();
	}

	@Override
	public ArrayList<Category> getCategories() {
		ArrayList<Category> result = new ArrayList<>();
		String[] temp;
		for (String s : readLines("testdatabase/groep.txt")) {
			temp = s.split(";");
			if (temp.length == 2)
				result.add(new Category(temp[0], temp[1]));
			else if (temp.length == 3)
				result.add(new Subcategory(temp[0], temp[1], this.getCategoryFromText(temp[2], result)));
			else throw new IllegalArgumentException("Invalid category text database.");
		}
		return result;
	}

	@Override
	public ArrayList<Question> getQuestions(ArrayList<Category> list) {
		ArrayList<Question> result = new ArrayList<>();
		String[] temp;
		for (String s : readLines("testdatabase/vraag.txt")) {
			temp = s.split(";");
			//if (temp.length >= 2)
				//result.add(new Question(temp[0], new ArrayList<Question>().toArray(a)));
			//else throw new IllegalArgumentException("Invalid question text database.");
		}
		return result;
	}
	
	private Category getCategoryFromText(String text, ArrayList<Category> list) {
		for (Category c : list) {
			if (c.getName().equals(text))
				return c;
		}
		return null;
	}
	
	private Question getQuestionFromText(String text, ArrayList<Question> list) {
		for (Question q : list) {
			if (q.getQuestion().equals(text))
				return q;
		}
		return null;
	}
}
