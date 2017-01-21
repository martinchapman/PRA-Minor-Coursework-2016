package Coursework4.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JComboBox;

import Coursework4.generator.Media;
import Coursework4.generator.MediaGenerator;
import Coursework4.model.Film;
import Coursework4.model.Track;
import Coursework4.model.Utils;
import Coursework4.view.FileView;

/**
 * @author Martin
 *
 */
public class Organiser implements ActionListener {

	/**
	 * 
	 */
	private ArrayList<Media> films;
	
	/**
	 * 
	 */
	private ArrayList<Media> tracks;
	
	/**
	 * 
	 */
	private ArrayList<Media> unclassified;
	
	/**
	 * 
	 */
	private FileView window;
	
	/**
	 * @param window
	 */
	public Organiser( FileView window ) {
		
		films = new ArrayList<Media>();
		
		tracks = new ArrayList<Media>();
		
		unclassified = new ArrayList<Media>();
		
		this.window = window;
	
	}
	
	/**
	 * 
	 */
	public void getMedia() {
		
		for ( Media media : MediaGenerator.getMedia("src/steffenmartin/resources") ) {
			
			System.out.println(media.getName());
			
			if ( !Utils.matchRegexAll(media.getName(), ".*\\.[f|g|m].*").equals("") ) {
			
				films.add(new Film(media.getImage(), media.getName(), Utils.matchRegexAll(media.getName(), "[A-Za-z\\-\\s]{3,}+"), Utils.matchRegexAll(media.getName(), "198\\d|199\\d|200\\d|201\\d"), Utils.matchRegexAll(media.getName(), "HD|SD"), Integer.parseInt(Utils.matchRegexAll(media.getName(), "1080|720|480"))));
				
			} else if ( !Utils.matchRegexAll(media.getName(), ".*\\.[a|o|w].*").equals("") ) {
				
				tracks.add(new Track(media.getImage(), media.getName(), Utils.matchRegex(media.getName(), "([A-Za-z\\s']*)\\-([A-Za-z\\s'\\-]*\\s[feat\\.\\s]*[A-Za-z\\s']*)", 0), Utils.matchRegex(media.getName(), "([A-Za-z\\s']*)\\-([A-Za-z\\s'\\-]*\\s[feat\\.\\s]*[A-Za-z\\s']*)", 1)));
				
			} else {
				
				unclassified.add(media);
				
			}
			
		}
		
		updateAll();
		
	}
	
	/**
	 * 
	 */
	private void updateAll() {
		
		window.clearPanels();
		
		updateFilms();
		
		updateTracks();
		
		updateUnclassified();
		
	}
	
	/**
	 * 
	 */
	private void updateFilms() {
		
		for ( Media film : films ) {
			
			window.addToFilms(film.getImage(), ((Film)film).getFilmName(), ((Film)film).getYearOfRelease() + " - " + ((Film)film).getQuality());
		
		}
		
	}
	
	/**
	 * 
	 */
	private void updateTracks() {
		
		for ( Media track : tracks ) {
			
			window.addToMusic(track.getImage(), ((Track)track).getTrackName(), ((Track)track).getArtist());
		
		}
		
	}
	
	/**
	 * 
	 */
	private void updateUnclassified() {
		
		for ( Media media : unclassified ) {

			window.addToUnclassified(media.getImage(), media.getName());
					
		}
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() instanceof JComboBox ) {
			
			@SuppressWarnings("unchecked")
			JComboBox<String> trigger = ((JComboBox<String>)e.getSource());
			
			ArrayList<Media> toSort = null;
			
			if (trigger.getActionCommand().equals("sortFilms")) {
				
				toSort = films;
				
			} else if ( trigger.getActionCommand().equals("sortTracks") ) {
				
				toSort = tracks;
				
			}
			
			if ( trigger.getSelectedItem().equals("Release Year") ) {
				
				Collections.sort(toSort, new Comparator<Media>() {

					@Override
					public int compare(Media y1, Media y2) {
					
						return ((Film)y2).getYearOfRelease() - ((Film)y1).getYearOfRelease();
						
					}
					
				});
				
			} else if ( trigger.getSelectedItem().equals("Title") ) {
				
				Collections.sort(toSort, new Comparator<Media>() {

					@Override
					public int compare(Media y1, Media y2) {
					
						String pattern = "[^\\s*The][a-zA-Z\\s]*";
						
						return Utils.matchRegexAll(((Film)y1).getFilmName(), pattern).compareTo(Utils.matchRegexAll(((Film)y2).getFilmName(), pattern));
						
					}
					
				});
			
			} else if ( trigger.getSelectedItem().equals("Quality") ) {
				
				Collections.sort(toSort, new Comparator<Media>() {

					@Override
					public int compare(Media y1, Media y2) {
					
						return ((Film)y1).getPixels() - ((Film)y2).getPixels();
						
					}
					
				});
				
			} else if ( trigger.getSelectedItem().equals("Track Name") ) {
				
				Collections.sort(toSort, new Comparator<Media>() {

					@Override
					public int compare(Media y1, Media y2) {
					
						String pattern = "[^\\s*The][a-zA-Z\\s]*";
						
						return Utils.matchRegexAll(((Track)y1).getTrackName(), pattern).compareTo(Utils.matchRegexAll(((Track)y2).getTrackName(), pattern));
						
					}
					
				});
				
			} else if  ( trigger.getSelectedItem().equals("Artist") ) {
				
				Collections.sort(toSort, new Comparator<Media>() {

					@Override
					public int compare(Media y1, Media y2) {
					
						String pattern = "[^\\s*The][a-zA-Z\\s]*";
						
						return Utils.matchRegexAll(((Track)y1).getArtist(), pattern).compareTo(Utils.matchRegexAll(((Track)y2).getArtist(), pattern));
						
					}
					
				});
				
			}
			
			updateAll();
			
		}
		
	}
	
}