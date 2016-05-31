package Coursework3;

import Coursework3.controller.Controller;
import Coursework3.model.Squad;
import Coursework3.view.Fantasy;

/**
 * @author Martin
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		
		// View
		Fantasy fantasy = new Fantasy();
		
		// Model (or backend / `database')
		Squad team = new Squad();
		
		// Controller knows about both the model and the view (or only the model if used observer-observable)
		Controller controller = new Controller( fantasy, team );
		
		// View knows about the controller, so it can apply it as an action listener to the components
		fantasy.registerController(controller);
		
		// Possible alternative: team.addObserver(fantasy);
		
		fantasy.setVisible(true);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Main();

	}

}