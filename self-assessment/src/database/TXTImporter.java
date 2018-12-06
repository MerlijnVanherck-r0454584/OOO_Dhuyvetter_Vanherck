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
		for (String s : readLines("testdatabase/groep.txt"))
			;
		return null;
	}

	@Override
	public ArrayList<Question> getQuestions() {
		// TODO Auto-generated method stub
		return null;
	}
}
