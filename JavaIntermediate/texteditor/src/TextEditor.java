/**
 Provided in 2013 TechLab Education
 
 The MIT License (MIT)
 
 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:
 
 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.*;

@SuppressWarnings("serial")
/**
 * A simple text editor view.
 * @author (your name) 
 */
public class TextEditor extends JApplet 
	implements ActionListener {
	private TextEditorModel model;

	// add components here
	private JTextField field;
	private JTextArea area;
	
	// Remember whether or not we have saved our work.
	private boolean saved = false;
	private String saveFile;

	/**
	 * Called by the browser or applet viewer to inform this JApplet that it has
	 * been loaded into the system. It is always called before the first time
	 * that the start method is called.
	 */
	public void init() {
		// Create a model and view object.
		model = new TextEditorModel();
		// Set the size of this applet to the size that the view wants.
		this.setSize(new Dimension(500, 500));
		// Make a new content pane to organize what we put into the applet.
		this.setLayout(new FlowLayout());
		
		initializeComponents();
	}

	/**
	 * Initializes the components of this applet.
	 */
	public void initializeComponents() {
		// Initialize the buttons.
		JMenuBar menubar = new JMenuBar();
        
		JMenu fileMenu = new JMenu("file");
		
        JMenuItem newFile = new JMenuItem("new");
		newFile.setActionCommand("new");
		newFile.addActionListener(this);
		
		
		JMenuItem openFile = new JMenuItem("open");
		openFile.setActionCommand("open");
		openFile.addActionListener(this);
		
		JMenuItem Save = new JMenuItem("save");
		Save.setActionCommand("save");
		Save.addActionListener(this);
		
		JMenuItem saveAs = new JMenuItem("save as");
		saveAs.setActionCommand("save as");
		saveAs.addActionListener(this);
		
		JMenuItem Close = new JMenuItem("clear");
		Close.setActionCommand("clear");
		Close.addActionListener(this);
		
		JMenu editMenu = new JMenu("edit");
		
		JMenuItem undo = new JMenuItem("undo");
		undo.setActionCommand("undo");
		undo.addActionListener(this);
		
		JMenuItem redo = new JMenuItem("redo");
		redo.setActionCommand("redo");
		redo.addActionListener(this);
		
		fileMenu.add(newFile);
		fileMenu.add(openFile);
		fileMenu.add(Save);
		fileMenu.add(saveAs);
		fileMenu.add(Close);
		
		editMenu.add(undo);
		editMenu.add(redo);
		
		menubar.add(fileMenu);
		menubar.add(editMenu);
		setJMenuBar(menubar);
		
		// Initializing a text area.
		area = new JTextArea(30, 30);
		add(area);
	}

	/**
	 * This method is called whenever a component with an action value is
	 * activated.
	 */
	public void actionPerformed(ActionEvent a) {
		if (a.getSource() == field) {
			// Then our text field is sending us data.
		}
		else {
			// Otherwise, some other component is sending us data.
			String action = a.getActionCommand();
			if (action.equals("new")) {
				
			}
			// Get the file name to open, then set the text area to the contents.
			if (action.equals("open")) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					area.setText(model.openFile(file.getAbsolutePath()));
				} else {
				
				}
				}
				// Your code here.
			
			// Save the contents of the text area to a file, making a new file if necessary.
			if (action.equals("save")) {
				
				if (saved==true) {
					
					model.saveFile(saveFile,  area.getText());
					
				}
					}else{
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(this);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					   File file = fc.getSelectedFile();
					   model.saveFile(file.getAbsolutePath(),  area.getText());
					   saved = true;
				
			}
			// Saves the contents of the text area to a new file, even if it has already been saved.
			if (action.equals("save as")) {
				int returnVal1 = fc.showSaveDialog(this);
				
				if (returnVal1 == JFileChooser.APPROVE_OPTION) {
					   File file = fc.getSelectedFile();
					   model.saveFile(file.getAbsolutePath(),  area.getText());
				}else{
			}
			// Clears the text editor.
			if (action.equals("clear")) {
				// Your code here.
			}
	
			}}
	}
}}

//WUBWUBWUBWUBWUBWUBWUBWUBWUBWUBWUBWUBWUBWUBUBWUBWUBWUBWUBWUBWU

/* wubwubwubwubwuwbuwbuwbuwububwubwubwubwuwubwubwubwuwbuwbuwbubwubwuwuwubwuw
 * 
 * no one can read this
 * ever
 * eervera
 * araraavva
 * muahahahahahhahahahahhahahah
 * ahaah
 * h
 * a
 */
 

