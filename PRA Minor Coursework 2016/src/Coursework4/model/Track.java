package Coursework4.model;

import javax.swing.JLabel;

import Coursework4.generator.Media;

public class Track extends Media {

	private String trackName;
	
	private String artist;

	public Track( JLabel image, String name, String trackName, String artist ) {

		super(name, image);
		
		this.trackName = trackName;
	
		this.artist = artist;

	}

	public String getTrackName() {
		
		return trackName;
		
	}

	public String getArtist() {
		
		return artist;
	
	}

}