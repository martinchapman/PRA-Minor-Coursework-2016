package Coursework4.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import Coursework4.controller.Organiser;

/**
 * @author Martin
 *
 */
public class FileView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Organiser organiser;
	
	/**
	 * @param organiser
	 */
	public void setOrganiser(Organiser organiser) {
		
		this.organiser = organiser;
		
	}
	
	/**
	 * 
	 */
	public void setupGUI() {
		
		setPreferredSize(new Dimension(1000, 1000));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setBackground(new Color(31, 31, 31));
		
		setLayout(new BorderLayout());
		
		mediaPanel();
		
		pack();
		
	}
	
	/**
	 * 
	 */
	private JPanel filmScroll;
	
	/**
	 * 
	 */
	private JPanel musicScroll;
	
	/**
	 * 
	 */
	private JPanel unclassifiedScroll;
	
	/**
	 * @param text
	 * @param centre
	 * @return
	 */
	private JLabel titleLabel( String text, boolean centre ) {
		
		JLabel titleLabel = new JLabel();
		
		titleLabel.setForeground(new Color(234, 234, 234));
		
		titleLabel.setFont(new Font("Helvetica Nue", Font.BOLD,14));
		
		if ( centre ) titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		titleLabel.setText( text );
		
		return titleLabel;
		
	}
	
	/**
	 * @return
	 */
	private DefaultComboBoxModel<String> filmOptions() {
		
		return new DefaultComboBoxModel<String>(new String[] {"Sort", "Title", "Release Year", "Quality"});
	
	}
	
	/**
	 * @return
	 */
	private DefaultComboBoxModel<String> trackOptions() {
		
		return new DefaultComboBoxModel<String>(new String[] {"Sort", "Track Name", "Artist"});
	
	}
	
	/**
	 * 
	 */
	private void mediaPanel() {
		
		JPanel mediaPanel = new JPanel();
		
		mediaPanel.setLayout(new GridLayout(0, 1));
		
		mediaPanel.setBorder(BorderFactory.createLineBorder(new Color(31, 31, 31), 10));
		
		filmSection(mediaPanel);
		
		trackSection(mediaPanel);
		
		unclassifiedSection(mediaPanel);
		
		add(mediaPanel, BorderLayout.CENTER);
		
	}
	
	/**
	 * @param mediaPanel
	 */
	private void filmSection( JPanel mediaPanel ) {
		
		JPanel filmPanel = new JPanel();
		
		filmPanel.setBackground(new Color(31, 31, 31));
		
		filmPanel.setLayout(new BorderLayout());
	
		filmPanel.add(titleLabel("Films", false), BorderLayout.NORTH);
		
		//
		
		JComboBox<String> filmOrdering = new JComboBox<String>();
		
		filmOrdering.setModel(filmOptions());
		
		filmOrdering.setActionCommand("sortFilms");
		
		filmOrdering.addActionListener(organiser);
		
		JPanel comboPanel = new JPanel();
		
		comboPanel.setBackground(new Color(31, 31, 31));
		
		comboPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		comboPanel.add(filmOrdering);
		
		filmPanel.add(comboPanel, BorderLayout.SOUTH);
		
		mediaPanel.add(filmPanel);
		
		//
		
		filmScroll = new JPanel();
		
		JScrollPane filmScrollPane = new JScrollPane(filmScroll);
		
		filmScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		filmScrollPane.setBorder(BorderFactory.createEmptyBorder());
		
		filmScroll.setLayout(new GridLayout(1, 0));
		
		//
		
		filmPanel.add(filmScrollPane, BorderLayout.CENTER);
		
		//
		
	}
	
	/**
	 * @param mediaPanel
	 */
	private void trackSection( JPanel mediaPanel ) {
		
		JPanel musicPanel = new JPanel();
		
		musicPanel.setBackground(new Color(31, 31, 31));
		
		musicPanel.setLayout(new BorderLayout());
		
		musicPanel.add(titleLabel("Music", false), BorderLayout.NORTH);
		
		mediaPanel.add(musicPanel);
		
		//
		
		JComboBox<String> trackOrdering = new JComboBox<String>();
		
		trackOrdering.setModel(trackOptions());
		
		trackOrdering.setActionCommand("sortTracks");
		
		trackOrdering.addActionListener(organiser);
		
		JPanel comboPanel = new JPanel();
		
		comboPanel.setBackground(new Color(31, 31, 31));
		
		comboPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		comboPanel.add(trackOrdering);
		
		musicPanel.add(comboPanel, BorderLayout.SOUTH);
		
		mediaPanel.add(musicPanel);
		
		//
		
		musicScroll = new JPanel();
		
		JScrollPane musicScrollPanel = new JScrollPane(musicScroll);
		
		musicScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		musicScrollPanel.setBorder(BorderFactory.createEmptyBorder());
		
		musicScroll.setLayout(new GridLayout(1, 0));
		
		//
		
		musicPanel.add(musicScrollPanel, BorderLayout.CENTER);
		
		//
		
	}
	
	/**
	 * @param mediaPanel
	 */
	private void unclassifiedSection( JPanel mediaPanel ) {
		
		JPanel unclassifiedPanel = new JPanel();
		
		unclassifiedPanel.setBackground(new Color(31, 31, 31));
		
		unclassifiedPanel.setLayout(new BorderLayout());
		
		unclassifiedPanel.add(titleLabel("Unclassified", false), BorderLayout.NORTH);
		
		mediaPanel.add(unclassifiedPanel);
		
		//
		
		unclassifiedScroll = new JPanel();
		
		JScrollPane unclassifiedScrollPanel = new JScrollPane(unclassifiedScroll);
		
		unclassifiedScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		
		unclassifiedScrollPanel.setBorder(BorderFactory.createEmptyBorder());
		
		unclassifiedScroll.setBackground(new Color(31, 31, 31));
		
		unclassifiedScroll.setLayout(new GridLayout(1, 0));
		
		//
		
		unclassifiedPanel.add(unclassifiedScrollPanel);
		
		//
		
	}
	
	/**
	 * @param image
	 * @param name
	 * @param subheading
	 */
	public void addToFilms( JLabel image, String name, String subheading ) {
		
		filmScroll.add(mediaPanel(image, name, subheading));
		
		revalidate();
		
	}
	
	/**
	 * @param image
	 * @param name
	 * @param subheading
	 */
	public void addToMusic( JLabel image, String name, String subheading ) {
		
		musicScroll.add(mediaPanel(image, name, subheading));
		
		revalidate();
		
	}
	
	/**
	 * @param image
	 * @param name
	 */
	public void addToUnclassified( JLabel image, String name ) {
		
		unclassifiedScroll.add(mediaPanel(image, name, "Unclassified"));
		
		revalidate();
		
	}
	
	/**
	 * 
	 */
	public void clearPanels() {
		
		filmScroll.removeAll();
		
		musicScroll.removeAll();
		
		unclassifiedScroll.removeAll();
		
		repaint();
		
	}
	
	/**
	 * @param image
	 * @param title
	 * @param subtitle
	 * @return
	 */
	private JPanel mediaPanel( JLabel image, String title, String subtitle ) {
		
		JPanel mediaPanel = new JPanel();
		
		mediaPanel.setBackground(new Color(31, 31, 31));
		
		mediaPanel.setLayout(new BorderLayout());
		
		//
		
		JPanel imagePanel = new JPanel();
		
		imagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		imagePanel.add(image);
		
		imagePanel.setOpaque(false);
		
		mediaPanel.add(imagePanel, BorderLayout.CENTER);
		
		//
		
		JPanel southPanel = new JPanel();
		
		southPanel.setBackground(new Color(31, 31, 31));
		
		southPanel.setLayout(new GridLayout(0, 1));
		
		//
		
		southPanel.add(titleLabel(title, true));
		
		//
		
		JLabel subtitleLabel = new JLabel();
		
		subtitleLabel.setForeground(new Color(234, 234, 234));
		
		subtitleLabel.setFont(new Font("Helvetica Nue", Font.PLAIN, 12));
		
		subtitleLabel.setText(subtitle);
		
		subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		southPanel.add(subtitleLabel);
		
		//
		
		mediaPanel.add(southPanel, BorderLayout.SOUTH);
	
		return mediaPanel;
		
	}

}
