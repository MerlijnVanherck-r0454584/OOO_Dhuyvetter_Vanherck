package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileManager {
	
	public static String readEntireFile(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileName));
		String fileText = "";	
		
		while(fileReader.hasNextLine())
		{
			  fileText = fileReader.nextLine();
		}
			
		fileReader.close();
		
		return fileText;
	}
	
	public static void writeToFile(String fileName, String textToWrite) throws IOException {
		Writer fileWriter = new FileWriter(fileName, true);
		
		fileWriter.write(textToWrite);
		
		fileWriter.close();
	}
}
