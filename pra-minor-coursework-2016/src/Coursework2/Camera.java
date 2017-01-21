package Coursework2;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * MAXIMUM MARK OF 2 for submissions, IF:
 * 
 * (A) Translation is hard-coded using IF statements (bar the translation back from hex to int, which is permissible)
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
public class Camera extends JSlider {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Camera() {
		
		setPreferredSize(new Dimension(500, 50));
		
		setMinimum(0);
		
		setMaximum(15);
		
		setValue(0);
		
		cameraAlphabet();
		
	}

	/**
	 * Could be encapsulated as model for MVC design.
	 * 
	 * @param points
	 */
	public void sendMovementPoints( ArrayList<Integer> points ) {
		
		for ( Integer point : points ) {
			
			try {
				
				Thread.sleep(2000);
				
			} catch (InterruptedException e) { }

			setValue(point);
			
		}
		
	}
	
	/**
	 * Could be encapsulated as model for MVC design.
	 */
	public void cameraAlphabet() {
		
		Hashtable<Integer, JLabel> cameraAlphabet = new Hashtable<Integer, JLabel>();
		
		for ( int i = 0; i < 10; i++ ) {
			
			cameraAlphabet.put( new Integer( i ), new JLabel(i + "") );
			
		}
		
		cameraAlphabet.put( new Integer( 10 ), new JLabel("A"));
		
		cameraAlphabet.put( new Integer( 11 ), new JLabel("B"));
		
		cameraAlphabet.put( new Integer( 12 ), new JLabel("C"));
		
		cameraAlphabet.put( new Integer( 13 ), new JLabel("D"));
		
		cameraAlphabet.put( new Integer( 14 ), new JLabel("E"));
		
		cameraAlphabet.put( new Integer( 15 ), new JLabel("F"));
	
		setLabelTable( cameraAlphabet );
		
		setPaintLabels(true);
	
	}

}
