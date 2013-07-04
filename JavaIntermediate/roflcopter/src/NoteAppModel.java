import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;


public class NoteAppModel {
	
	public String saveImage (String imageName) { 
		File f = new File(imageName); 
		Scanner s;
		try {
			s = new Scanner (f);
			//StringBuilder sb = new StringBuilder();
			String contents = "";
			while(s.hasNextLine()) {
				//sb.append(s.nextLine());
				//sb.append("\n");
				contents = contents + s.nextLine() + "\n";
				
			//}return sb.toString();
			}return contents;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageName;
	}
	public static void importImage(BufferedImage img, File file)
			throws IOException {
		if (img == null)
			return;
		File newfile = new File("src/NoteApp/" + file.getName());
		String format = newfile.getPath().toLowerCase();
		int lastIndex = format.lastIndexOf('.');
		if (lastIndex >= 0)
			format = format.substring(lastIndex + 1);
		if (format.equals("jpg"))
			format = "jpeg";
		ImageIO.write(img, format, newfile);
	}
		
		/*public void openFile (String fileName) throws IOException {
		    area.setEditorKit(new HTMLEditorKit());
		    HTMLDocument doc = (HTMLDocument)area.getDocument();
		    try {
		        area.getEditorKit().read(new FileReader(fileName), doc, 0);
		    }
		    catch (BadLocationException b) {
		        throw new IOException("Could not fill data into editor.", b);
		    }
		}*/
			
			
			

		
		
	
	
	protected ImageIcon createImageIcon(String path) {
java.net.URL imgURL = getClass().getResource(path);
if (imgURL != null) {
return new ImageIcon(imgURL);
} else {
System.err.println("Couldn't find file: " + path);
return null;
}

	}
}

