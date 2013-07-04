import java.io.File;

import javax.swing.JFrame;


public class NoteAppDriver {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new NoteApp();
        
        (new File("src/NoteApp")).mkdirs();
        
	}

}
