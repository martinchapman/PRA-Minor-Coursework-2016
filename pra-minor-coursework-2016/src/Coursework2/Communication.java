package Coursework2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * MAXIMUM MARK OF 2 for submissions, IF:
 * 
 * (A) Translation is hard-coded using IF statements (bar the translation back from hex to int, which is permissable)
 * (B) Inbuilt functions are used to convert TO HEX (from latin alphabet) or TO INT (from hex)
 * 
 * Three potential questions to ask the students as part of the oral assessment (choose one at random for each pair):
 * 
 * 1. Ask the students to run their code, and show the communication occurring.
 * 2. Ask the students to comment on how they have used methods to logically separate the creation of the GUI objects.
 * 3. Ask the students how they would change their program to better accommodate MVC.
 * 
 * Use this to judge the marks you give them on their oral assessment.
 * 
 * @author Martin
 *
 */
public class Communication extends JFrame {

	/**
	 * 
	 */
	public Camera camera;
	
	/**
	 * 
	 */
	private Hashtable<String, String> asciiTable;
	
	/**
	 * 
	 */
	private static final String frameTitle = "The Martian starring Matthew Damon";
	
	/**
	 * @throws FileNotFoundException
	 */
	public Communication() throws FileNotFoundException {
		
		super(frameTitle);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setPreferredSize(new Dimension(500, 800));
		
		setupAscii();
		
		setupCamera();
		
		setupInput();
		
		pack();
		
	}
	
	/**
	 * 
	 */
	public void setupCamera() {
		
		camera = new Camera();
		
		add(camera, BorderLayout.NORTH);
		
	}
	
	/**
	 * @param character
	 * @return
	 */
	private ArrayList<Integer> toCameraPoints( String hexCode ) {
		
		if (hexCode == null || hexCode.equals("")) return new ArrayList<Integer>();
		
		// Setup temporary map for alphabetic hex characters
		Hashtable<String, Integer> hexToCameraPoint = new Hashtable<String, Integer>();
		
		// This is the only place I'm happy to see hard-coding
		hexToCameraPoint.put("A", 10);
		
		hexToCameraPoint.put("B", 11);
		
		hexToCameraPoint.put("C", 12);
		
		hexToCameraPoint.put("D", 13);
		
		hexToCameraPoint.put("E", 14);
		
		hexToCameraPoint.put("F", 15);
		
		ArrayList<Integer> characters = new ArrayList<Integer>();
		
		for ( String character : hexCode.split("") ) {
			
			if ( hexToCameraPoint.containsKey(character) ) {
				
				characters.add(hexToCameraPoint.get(character));
				
			} else {
				
				try {
					
					characters.add(Integer.parseInt(character));
					
				} catch ( Exception e ) {
					
					System.err.println("Cannot parse " + character + " to camera point.");
					
					characters.add(-1);
					
				}
			}
		
		}
		
		return characters;
		
		// Must not include this! Maximum mark of 2 if this is done.
		//yourNumber = parseInt(hexString, 16);
		
	}
	
	/**
	 * Putting GUI code in a separate method is a good example of logical separation
	 */
	public void setupInput() {
		
		JTextArea input = new JTextArea();
		
		add(input, BorderLayout.CENTER);
		
		JButton send = new JButton("Send");
		
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				camera.sendMovementPoints(new ArrayList<Integer>());
				
				ArrayList<Integer> movementPoints = new ArrayList<Integer>();
				
				setTitle("Sending: " + input.getText());
				
				String storedInput = input.getText();
				
				input.setText("");

				for ( String character : storedInput.split("")) {
					
					movementPoints.addAll(toCameraPoints(asciiTable.get(character)));
					
					// Must not include this! Maximum mark of 2 if this is done.
					// hexString = yourNumber.toString(16);
					
				}
				
				/* Lots of different options here, but a technique similar to 
				 * this must be used to stop the slider jumping.
				 */
				Thread cameraMovement = new Thread() {
				
					public void run() {
					
						camera.sendMovementPoints(movementPoints);
						
						setTitle(frameTitle);
				
					}
					
				};
				
				cameraMovement.start();
			
				
			}
			
		});
		
		add(send, BorderLayout.SOUTH);
		
	}
	
	/**
	 * @throws FileNotFoundException
	 */
	private void setupAscii() throws FileNotFoundException {
		
		asciiTable = new Hashtable<String, String>();
		
		Scanner in = new Scanner(new File("lib/ascii_table.csv"));
		
		while ( in.hasNextLine() ) {
			
			String line = in.nextLine();
			
			/* I'm only dealing with uppercase and lowercase. Students should also try and deal with the space character, 
			 * at least, but this is not essential.
			 * 
			 * In addition if students are reading in too MUCH of the file, such that there is a data overhead that is
			 * superfluous to our needs, inform them of this.
			 */
			if ( line.split(",")[6].contains("Uppercase") ||  line.split(",")[6].contains("Lowercase") ) {
				
				asciiTable.put(line.split(",")[6].split(" ")[1], line.split(",")[2]);
				
			}
			
		}
		
		setLayout(new BorderLayout());
		
		in.close();
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Communication frame = new Communication();
		
		frame.setVisible(true);
		
	}
	
}