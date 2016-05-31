package Coursework4;

import Coursework4.controller.Organiser;
import Coursework4.view.FileView;

public class Main {

	public Main() {
		
		FileView window = new FileView();
		
		Organiser organiser = new Organiser( window );
		
		window.setOrganiser(organiser);
		
		window.setupGUI();
		
		organiser.getMedia();
		
		window.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		new Main();
		
	}

}
