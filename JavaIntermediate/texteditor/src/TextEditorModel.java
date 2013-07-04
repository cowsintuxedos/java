import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TextEditorModel {
	
	/**
	 * The constructor for our applet.
	 */
	public TextEditorModel() {
		// any initialization for your model
	}

	public void inputText(String text) {
		System.out.println("The model just got: " + text);
	}
	
	public String openFile(String fileName) { 
		File f = new File(fileName); 
		try {
			Scanner s = new Scanner (f);
			//StringBuilder sb = new StringBuilder();
			String contents = "";
			while(s.hasNextLine()) {
				//sb.append(s.nextLine());
				//sb.append("\n");
				String line = s.nextLine();
				String[] parts = line.split("=");
				map.put(parts[0], parts[1]);
				contents = contents + s.nextLine() + "\n";
				
			//}return sb.toString();
			}return contents;
			}
		
		 catch (FileNotFoundException e) {
			return "File not found";
		}
	}
	
	public void saveFile(String fileName, String text) {
		// Created a buffered writer
		FileWriter writer = null;
		try {
			writer = new FileWriter(fileName + ".txt");
			BufferedWriter bw = new BufferedWriter(writer);
			// use the buffered writer
			bw.write(text);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
