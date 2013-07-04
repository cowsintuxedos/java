import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;


public class NoteApp extends JFrame implements ActionListener {
	
	static Map<JFrame, BufferedImage> frameMap = new HashMap<JFrame, BufferedImage>();
	
	JTextField field;
	JTextPane area;
	NoteAppModel model;
	
	
	
	public NoteApp() {
		
		super("NoteApp");
		init();
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
		
		
	public void init () {
		this.setSize(new Dimension(500,500));
		//this.setLayout(new FlowLayout());
		JScrollBar scroll = new JScrollBar(JScrollBar.VERTICAL, 0, 40, 0, 300);
		scroll.addAdjustmentListener(new Adjuster());
		add(scroll, BorderLayout.EAST);
		
		
		
		initializeComponents();
	}
	class Adjuster implements AdjustmentListener {
	    public void adjustmentValueChanged(AdjustmentEvent e) {
	      
	      repaint();
	    }
	  }
	
	private static void openImage(BufferedImage img) {
		JFrame frame = new JFrame();
		frame.setVisible(true); // display it
	}


	
	private void initializeComponents() {
		/*JButton button = new JButton("wat");
		button.setActionCommand("new");
		button.addActionListener(this);
		add(button);
		
		field = new JTextField(20);
		add(field);
		
		JLabel label = new JLabel("This is label");
		add(label);*/
		
		model = new NoteAppModel();
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date date = new Date();
		String initDate = ("Note created " + dateFormat.format(date));
		
		
        JMenuBar menubar = new JMenuBar();
        JMenu formatbar = new JMenu("Format");
        
		JMenu noteMenu = new JMenu("Menu");
		
        JMenuItem newFile = new JMenuItem("New");
		newFile.setActionCommand("new");
		newFile.addActionListener(this);
		
		
		JMenuItem openFile = new JMenuItem("Open");
		openFile.setActionCommand("open");
		openFile.addActionListener(this);
		
		JMenuItem saveFile = new JMenuItem("Save");
		saveFile.setActionCommand("save");
		saveFile.addActionListener(this);
		
		JMenuItem clearFile = new JMenuItem("Clear");
		clearFile.setActionCommand("cleartext");
		clearFile.addActionListener(this);
		
		JMenu photoMenu = new JMenu("Images");
		
		JMenuItem newPhoto = new JMenuItem("Import");
		newPhoto.setActionCommand("import");
		newPhoto.addActionListener(this);
		
		JMenuItem selectPhoto = new JMenuItem("Select");
		selectPhoto.setActionCommand("select");
		selectPhoto.addActionListener(this);
		
		JMenuItem leftAlign = new JMenuItem("Left");
		leftAlign.setActionCommand("leftalign");
		leftAlign.addActionListener(this);
		
		JMenuItem centerAlign = new JMenuItem("Center");
		centerAlign.setActionCommand("midalign");
		centerAlign.addActionListener(this);
		
		JMenuItem rightAlign = new JMenuItem("Right");
		rightAlign.setActionCommand("rightalign");
		rightAlign.addActionListener(this);
		JLabel datetext = new JLabel((dateFormat.format(date)));
		
		field = new JTextField(20);
		
		photoMenu.add(newPhoto);
		photoMenu.add(selectPhoto);
		
		noteMenu.add(newFile);
		noteMenu.add(openFile);
		noteMenu.add(saveFile);
		noteMenu.add(clearFile);
		
		menubar.add(new JLabel(" "));
		menubar.add(noteMenu);
		menubar.add(new JLabel(" "));
		menubar.add(photoMenu);
		menubar.add(new JLabel(" "));
		menubar.add(formatbar);
		menubar.add(new JLabel(" "));
		
		menubar.add(new JLabel("                                                         Andrew Lai"));
		
		formatbar.add(leftAlign);
		formatbar.add(centerAlign);
		formatbar.add(rightAlign);
		
		setJMenuBar(menubar);
		
		
		
		// Initializing a text area.
		area = new JTextPane();
		add(area);
		
		
		menubar.setBackground(Color.gray);
		photoMenu.setBackground(Color.lightGray);
		noteMenu.setBackground(Color.lightGray);
		formatbar.setBackground(Color.lightGray);
		SimpleAttributeSet set = new SimpleAttributeSet();  
		StyleConstants.setFontSize(set, 12);
		StyleConstants.setFontFamily(set, "Helvetica");
		area.setText(initDate);
		area.setParagraphAttributes(set,true);
	}

	public boolean accept(String fileName) {
        return fileName.endsWith(".html");
	}
	/*
	  public void WriteImage()
	    {
	    	BufferedImage image = null;
	        try {
	            image = ImageIO.read(url);
	            
	            ImageIO.write(image, new File("roflcopter\" + filename + ".jpeg" ));
	 
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	    }*/
	

	@Override
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == field) {
			// Then our text field is sending us data.
		}
		else {
			String action = a.getActionCommand();
			
			if (action.equals("import")) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					
						File file = fc.getSelectedFile();
						/*JFrame frame = new JFrame();
						if (!file.exists())
							NoteAppModel.importImage(frameMap.get(frame), file);
						else
							JOptionPane.showMessageDialog(frame, "File already exists");
					} catch (IOException e) {

						e.printStackTrace();
					}*/
					area.insertIcon(new ImageIcon(file.getAbsolutePath()));
					BufferedImage image = null;
			        
			            try {
			            	
							image = ImageIO.read(file);
							ImageIO.write(image, "png",new File("src/NoteApp/" + file.getName()));
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			if (action.equals("select")) {
				
						JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File image = fc.getSelectedFile();
					area.insertIcon(new ImageIcon(image.getAbsolutePath()));
					}
				}
				
			
			if (action.equals("open")) {
				
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					 
					try {
						area.setPage("file:///" + file.getAbsoluteFile());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			}
			if (action.equals("new")) {
			new NoteApp();
			}
			if (action.equals("save")) 
			if (area.getText().length() > 0){

	            JFileChooser chooser = new JFileChooser();
	            chooser.setMultiSelectionEnabled(false);
	            int option = chooser.showSaveDialog(this);
	            
	            if (option == JFileChooser.APPROVE_OPTION) {
	            	System.out.println(area.getPage());
	                StyledDocument doc = (StyledDocument)area.getDocument();
	                HTMLEditorKit kit = new HTMLEditorKit();
	                BufferedOutputStream out;

	                try {
	                    out = new BufferedOutputStream(new FileOutputStream(chooser.getSelectedFile().getAbsoluteFile()));
	                    kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
	                } catch (FileNotFoundException e) {
	                } catch (IOException e){
	                } catch (BadLocationException e){
	                }
	            }
			}
	        
	            
			
			if (action.equals("leftalign")) {
				SimpleAttributeSet set = new SimpleAttributeSet();  
				
				StyleConstants.setAlignment(set , StyleConstants.ALIGN_LEFT);  
				StyleConstants.setFontSize(set, 12);
				StyleConstants.setFontFamily(set, "Helvetica");
				area.setParagraphAttributes(set,true); 
				}
			if (action.equals("midalign")) {
				SimpleAttributeSet set = new SimpleAttributeSet();  
				 
				StyleConstants.setAlignment(set , StyleConstants.ALIGN_CENTER);  
				StyleConstants.setFontSize(set, 12);
				StyleConstants.setFontFamily(set, "Helvetica");
				area.setParagraphAttributes(set,true);
				}
			if (action.equals("rightalign")) {
				SimpleAttributeSet set = new SimpleAttributeSet();  
				
				StyleConstants.setAlignment(set , StyleConstants.ALIGN_RIGHT); 
				StyleConstants.setFontSize(set, 12);
				StyleConstants.setFontFamily(set, "Helvetica");
				area.setParagraphAttributes(set,true);
				
				}
			if (action.equals("cleartext")) {
						area.setText("");
						
						}
				}
		}
		
	}
	
	
	

		

	






