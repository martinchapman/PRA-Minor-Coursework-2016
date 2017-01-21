package Coursework4.model;

import javax.swing.JLabel;

import Coursework4.generator.Media;

public class Film extends Media {

	private String filmName;
	
	private int yearOfRelease;
	
	private String quality;
	
	private int pixels;
	
	public Film(JLabel image, String name, String filmName, String yearOfRelease, String quality, int pixels) {

		super(name, image);
		
		this.filmName = filmName;
		
		this.yearOfRelease = Integer.parseInt(yearOfRelease);
		
		this.quality = quality;
		
		this.pixels = pixels;
		
	}

	public String getFilmName() {
	
		return filmName;
	
	}

	public int getYearOfRelease() {
	
		return yearOfRelease;
	
	}

	public String getQuality() {
	
		return quality;
	
	}
	
	public int getPixels() {
		
		return pixels;
		
	}
	
}