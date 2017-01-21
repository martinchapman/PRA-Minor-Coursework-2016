package Coursework3.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import Coursework3.model.Defender;
import Coursework3.model.Goalkeeper;
import Coursework3.model.Midfielder;
import Coursework3.model.Player;
import Coursework3.model.Squad;
import Coursework3.model.Striker;
import Coursework3.view.Fantasy;

/**
 * Ask the students to comment on how they have connected the View and the Model.
 * 
 * @author Martin
 *
 */
public class Controller implements ActionListener, CaretListener {

	/**
	 * Students may choose to go down an observer-observable route, in which
	 * case they won't have a reference to the view here (instead, the model will
	 * talk directly to the view, rather than going through the controller).
	 */
	private Fantasy view;
	
	/**
	 * 
	 */
	private Squad model;
	
	/**
	 * @param view
	 * @param model
	 */
	public Controller(Fantasy view, Squad model) {
		
		this.view = view;
		
		this.model = model;

		model.generateSquad();
		
	}

	/**
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( !(e.getSource() instanceof Component) ) return;
		
		if ( ((Component)e.getSource()) instanceof JComboBox  ) {
			
			view.clearAllPlayers();
			
			// Suppress this warning -- I'm happy with the cast risk due to the if statement above.
			@SuppressWarnings("unchecked") 
			String selection = ((String)((JComboBox<String>)e.getSource()).getSelectedItem());
			
			if ( selection.equals("Select formation")) return;
			
			ArrayList<Goalkeeper> goalkeepers = model.goalkeepers();
			
			view.addToGoal(goalkeepers.get(0).getID(), goalkeepers.get(0).getName(), goalkeepers.remove(0).getImagePath());
			
			view.addToBench(goalkeepers.get(0).getID(), goalkeepers.get(0).getName(), goalkeepers.remove(0).getImagePath());
			
			//
			
			ArrayList<String> positions = new ArrayList<String>(Arrays.asList("Defence", "Midfield", "Attack"));
			
			for ( String part : selection.split("-") ) {
				
				String position = positions.remove(0);
				
				ArrayList<Defender> defenders = model.defenders();

				ArrayList<Midfielder> midfielders = model.midfielders();
				
				ArrayList<Striker> strikers = model.strikers();
				
				ArrayList<Player> leftoverPlayers = new ArrayList<Player>();

				for ( int player = 0; player < Integer.parseInt(part); player++ ) {
				
					if ( position.contains("Defence") ) {
						
						leftoverPlayers.clear();
					
						view.addToDefence(defenders.get(0).getID(), defenders.get(0).getName(), defenders.remove(0).getImagePath());
						
						leftoverPlayers.addAll(defenders);
								
					} else if ( position.contains("Midfield")  ) {
						
						leftoverPlayers.clear();
									
						view.addToMidfield(midfielders.get(0).getID(), midfielders.get(0).getName(), midfielders.remove(0).getImagePath());
						
						leftoverPlayers.addAll(midfielders);
									
					} else if ( position.contains("Attack") ){
							
						leftoverPlayers.clear();
									
						view.addToAttack(strikers.get(0).getID(), strikers.get(0).getName(), strikers.remove(0).getImagePath());
						
						leftoverPlayers.addAll(strikers);
							
					}
					
				}
				
				for ( Player player : leftoverPlayers ) {
					
					view.addToBench(player.getID(), player.getName(), player.getImagePath());
					
				}
					
			}
			
		} else if ( ((Component)e.getSource()) instanceof JButton  ) {
			
			JFileChooser fc = new JFileChooser();
            
        	int result = fc.showOpenDialog(null);
            
        	if (result == JFileChooser.APPROVE_OPTION) {
            
        		File file = fc.getSelectedFile();
                
        		view.updatePlayerImage(Integer.parseInt(((Component)e.getSource()).getName()), file);
        		
        		// Must see an update to the model here for the *RIGHT* player (e.g. `hidden' ID field is used to index player in model).
        		model.getPlayerByID(Integer.parseInt(((JButton)e.getSource()).getName())).setImagePath(file.getAbsolutePath());
        		
        		String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
        				
        		name = name.substring(0, 1).toUpperCase() + name.substring(1);
        		
        		view.updatePlayerName(Integer.parseInt(((Component)e.getSource()).getName()), name);
        		
        		model.getPlayerByID(Integer.parseInt(((JButton)e.getSource()).getName())).setName(name);
        		
        	}
        
		}
		
	}

	/**
	 * @param e
	 */
	@Override
	public void caretUpdate(CaretEvent e) {
		
		// Must see an update to the model here for the *RIGHT* player (e.g. `hidden' ID field is used to index player in model).
		model.getPlayerByID(Integer.parseInt(((JTextField)e.getSource()).getName())).setName(((JTextField)e.getSource()).getText());
		
	}

}