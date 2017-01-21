package Coursework3.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Coursework3.controller.Controller;

// ! Must not import anything from the model package e.g. steffenmartin.model.X. If students do, max mark should be 50% (2.5 / 5).

/**
 * View just presents methods for adding, removing and updating, all logic
 * should be inside controller.
 * 
 * @author Martin
 *
 */
public class Fantasy extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ArrayList<JPanel> playerPanels;
	
	/**
	 * 
	 */
	public Fantasy() {
		
		super("Fantasy Football");
		
		playerPanels = new ArrayList<JPanel>();
		
		setPreferredSize(new Dimension(500, 800));
		
		setupGUI();
		
		pack();
	
	}
	
	/**
	 * 
	 */
	private void setupGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		header();
		
		pitch();
		
		bench();
		
	}
	
	/**
	 * 
	 */
	private JComboBox<String> formation;
	
	/**
	 * 
	 */
	private void header() {
		
		formation = new JComboBox<String>();
		
		formation.setName("formation");
		
		DefaultComboBoxModel<String> formationModel = new DefaultComboBoxModel<String>();
		
		formation.setModel(formationModel);
		
		formationModel.addElement("Select formation");
		
		formationModel.addElement("4-4-2");
		
		formationModel.addElement("4-3-3");
		
		formationModel.addElement("3-5-2");
		
		formationModel.addElement("5-3-2");
		
		formationModel.addElement("3-4-3");
		
		formationModel.addElement("4-5-1");
		
		add(formation, BorderLayout.NORTH);
		
	}
	
	/**
	 * 
	 */
	private JPanel pitch;
	
	/**
	 * 
	 */
	private void pitch() {
		
		pitch = new JPanel();
		
		add(pitch, BorderLayout.CENTER);
		
		pitch.setLayout(new GridLayout(4, 1));
		
		for ( String position : new String[]{"Goal", "Defence", "Midfield", "Up front"}) {
			
			JPanel positionPanel = new JPanel();
			
			positionPanel.setName(position);
			
			pitch.add(positionPanel);
			
		}
		
	}
	
	/**
	 * 
	 */
	private JPanel bench;
	
	/**
	 * 
	 */
	private void bench() {
		
		bench = new JPanel();
		
		add(bench, BorderLayout.SOUTH);
		
	}
	
	//
	
	/**
	 * 
	 */
	private Controller controller;
	
	/**
	 * @param controller
	 */
	public void registerController ( Controller controller ) {
		
		formation.addActionListener(controller);
		
		this.controller = controller;
		
	}
	
	// All should be manipulated from controller //
	
	/**
	 * @param ID
	 * @param player
	 * @param imagePath
	 */
	public void addToBench( int ID, String player, String imagePath) {
		
		bench.add(playerPanel(ID, player, imagePath));
		
		revalidate();
		
	}
	/**
	 * @param goalkeeper
	 */
	public void addToGoal( int ID, String goalkeeper, String imagePath ) {
		
		getPitchPanelByName("Goal").removeAll();
		
		getPitchPanelByName("Goal").add(playerPanel(ID, goalkeeper, imagePath));
		
		revalidate(); // For add
		
	}
	
	/**
	 * @param defender
	 */
	public void addToDefence( int ID, String defender, String imagePath ) {
		
		getPitchPanelByName("Defence").add(playerPanel(ID, defender, imagePath));
	
		revalidate();
		
	}
	
	/**
	 * @param midfielder
	 */
	public void addToMidfield( int ID, String midfielder, String imagePath ) {
		
		getPitchPanelByName("Midfield").add(playerPanel(ID, midfielder, imagePath));
	
		revalidate();
		
	}
	
	/**
	 * @param striker
	 */
	public void addToAttack( int ID, String striker, String imagePath ) {
		
		getPitchPanelByName("Up front").add(playerPanel(ID, striker, imagePath));
		
		revalidate();
	
	}
	
	/**
	 * @param ID
	 * @param path
	 */
	public void updatePlayerImage(int ID, File file) {
		
		for ( JPanel playerPanel : playerPanels ) {
			
			if ( playerPanel.getName().equals(ID + "")) {
				
				JLabel picture = new JLabel();
				
				try {
	                
        			picture.setIcon( new ImageIcon( ImageIO.read ( file ) ) );
                
        		} catch (IOException e) {
                    
        			e.printStackTrace();
                
        		}
				
				for ( Component component : playerPanel.getComponents() ) {
					
					if ( component instanceof JButton ) {
						
						playerPanel.remove(component);
						
					}
					
				}
				
				playerPanel.add(picture, BorderLayout.CENTER);
				
				repaint();
				
				revalidate();
				
			}
			
		}
		
	}
	
	/**
	 * @param ID
	 * @param name
	 */
	public void updatePlayerName(int ID, String name) {
		
		for ( JPanel playerPanel : playerPanels ) {
			
			if ( playerPanel.getName().equals(ID + "")) {
				
				for ( Component component : playerPanel.getComponents() ) {
					
					if ( component instanceof JTextField ) {
						
						((JTextField)component).setText(name);
						
						repaint();
						
						revalidate();
						
					}
					
				}
				
			}
			
		}

	}
	
	/**
	 * 
	 */
	public void clearAllPlayers() {
		
		playerPanels.clear();
		
		for ( Component panel : pitch.getComponents() ) {
			
			if ( panel instanceof JPanel ) {
				
				((JPanel) panel).removeAll();
				
			}
		
		}
		
		bench.removeAll();
		
		repaint(); // For remove
		
	}
	
	// Util
	
	/**
	 * @param name
	 * @return
	 */
	private JPanel getPitchPanelByName(String name) {
		
		for ( Component panel : pitch.getComponents() ) {
			
			if ( panel instanceof JPanel && panel.getName().equals(name) ) {
				
				return (JPanel)panel;
				
			}
			
		}
		
		return null;

	}
	
	/**
	 * @param player
	 * @return
	 */
	private JPanel playerPanel(int ID, String name, String imagePath) {
		
		JPanel playerPanel = new JPanel();
		
		playerPanel.setLayout(new BorderLayout());
		
		if ( imagePath != "None" ) {
			
			JLabel picture = new JLabel();
			
			try {
			
				picture.setIcon(new ImageIcon(ImageIO.read(new File(imagePath))));
			
			} catch (IOException e) {

				e.printStackTrace();

			}
			
			playerPanel.add(picture, BorderLayout.CENTER);
			
		} else {
			
			JButton addPicture = new JButton("+");
			
			// Set name = invisible field for ID;
			addPicture.setName(ID + "");
			
			// Add the controller as the listener for the button
			addPicture.addActionListener(controller);
			
			playerPanel.add(addPicture, BorderLayout.CENTER);
			
		}
		
		JTextField playerText = new JTextField(name);
		
		playerText.setName(ID + "");
		
		playerText.addCaretListener(controller);
		
		playerPanel.add(playerText, BorderLayout.SOUTH);
		
		playerPanel.setName(ID + "");
		
		playerPanels.add(playerPanel);
		
		return playerPanel;
		
	}	

}