package Coursework3.model;

//! Must not import anything from the view package e.g. steffenmartin.view.X. If students do, max mark should be 50% (2.5 / 5).

/**
 * Ask the students to comment on how they have differentiated between different
 * types of players
 * 
 * Or what then default type of a player is
 * 
 * @author Martin
 *
 */
public class Player {

	private static int players;
	
	private int playerID;
	
	private String name;
	
	private String imagePath;
	
	public Player() {
		
		this("Player");
		
	}
	
	public Player( String name ) {
		
		this.name = name;
		
		this.imagePath = "None";
		
		playerID = players;
		
		players++;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public void setName(String name ) {
		
		this.name = name;
		
	}
	
	public String getImagePath() {
		
		return imagePath;
		
	}
	
	public void setImagePath(String imagePath) {
		
		this.imagePath = imagePath;
		
	}
	
	public int getID() {
		
		return playerID;
		
	}

	public String toString() {
		
		return getClass().getSimpleName() + ": " + name + " " + playerID;
		
	}

}