package Coursework3.model;

import java.util.ArrayList;
import java.util.Arrays;

//! Must not import anything from the view package e.g. steffenmartin.view.X. If students do, max mark should be 50% (2.5 / 5).

/**
 * `Database' of 15 players
 * 
 * @author Martin
 *
 */
public class Squad {

	/**
	 * 
	 */
	private ArrayList<Player> players;
	
	/**
	 * 
	 */
	private ArrayList<Goalkeeper> goalkeepers;
	
	/**
	 * 
	 */
	private ArrayList<Defender> defenders;
	
	/**
	 * 
	 */
	private ArrayList<Midfielder> midfielders;
	
	/**
	 * 
	 */
	private ArrayList<Striker> strikers;
	
	/**
	 * 
	 */
	public Squad() {
		
		players = new ArrayList<Player>();
		
		goalkeepers = new ArrayList<Goalkeeper>();
		
		defenders = new ArrayList<Defender>();
		
		midfielders = new ArrayList<Midfielder>();
		
		strikers = new ArrayList<Striker>();
		
	}
	
	/**
	 * 
	 */
	public void generateSquad() {
		
		this.goalkeepers.addAll(Arrays.asList(new Goalkeeper[]{new Goalkeeper(), new Goalkeeper()}));
		
		for ( int defenders = 0; defenders < 5; defenders++ ) {
			
			this.defenders.add(new Defender());
			
		}
		
		for ( int midfielders = 0; midfielders < 5; midfielders++ ) {
			
			this.midfielders.add(new Midfielder());
			
		}
		
		for ( int strikers = 0; strikers < 3; strikers++ ) {
			
			this.strikers.add(new Striker());
			
		}
		
		players.addAll(goalkeepers); players.addAll(defenders); players.addAll(midfielders); players.addAll(strikers);
		
	}
	
	/**
	 * @param player
	 */
	public void addPlayer(Player player) {
		
		players.add(player);
		
	}
	
	/**
	 * @return
	 */
	public ArrayList<Goalkeeper> goalkeepers() {
		
		return new ArrayList<Goalkeeper>(goalkeepers);
	
	}
	
	/**
	 * @return
	 */
	public ArrayList<Defender> defenders() {
		
		return new ArrayList<Defender>(defenders);
	
	}
	
	/**
	 * @return
	 */
	public ArrayList<Midfielder> midfielders() {
		
		return new ArrayList<Midfielder>(midfielders);
	
	}
	
	/**
	 * @return
	 */
	public ArrayList<Striker> strikers() {
		
		return new ArrayList<Striker>(strikers);
	
	}
	
	/**
	 * To search for the right player to update from the model in the controller
	 * 
	 * @param ID
	 * @return
	 */
	public Player getPlayerByID( int ID ) {
		
		for ( Player player : players ) {
			
			if ( player.getID() == ID ) {
				
				return player;
				
			}
			
		}
		
		return null;
		
	}

}