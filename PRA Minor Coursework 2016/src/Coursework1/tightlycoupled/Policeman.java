package Coursework1.tightlycoupled;

import java.util.ArrayList;

/**
 * @author Martin
 *
 */
public class Policeman {

	/**
	 * 
	 */
	private String name;
	
	/**
	 * The evidence boxes in the policeman's possession.
	 */
	private ArrayList<EvidenceBox> evidenceBoxes;
	
	/**
	 * @param name
	 */
	public Policeman( String name ) {
		
		this.name = name;
		
		evidenceBoxes = new ArrayList<EvidenceBox>();
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return name;
		
	}
		
	/**
	 * `Taking' and evidence box, is just a fancy way of saying
	 * that we add an object of EvidenceBox type to a list inside
	 * a class
	 * 
	 * @param evidenceBox
	 */
	public void takeEvidenceBox( EvidenceBox evidenceBox ) {
		
		evidenceBoxes.add(evidenceBox);
		
	}

	/**
	 * I'd rather the students returned a list from this method that corresponds to the 
	 * evidence found, rather than printing the matching evidence inside this method.
	 * Remind the students that returning objects from methods, rather than printing those
	 * objects, should be favoured for extensibility.
	 *  
	 * @param caseNumber
	 * @param evidenceType
	 * @return
	 */
	public ArrayList<Evidence> getEvidence( int caseNumber, String evidenceType ) {
		
		ArrayList<Evidence> evidenceOfType = new ArrayList<Evidence>();
		
		for ( EvidenceBox evidenceBox : evidenceBoxes ) {
			
			if ( evidenceBox.getCaseNumber() == caseNumber ) {
			
				/* 
				 * This will be moved in the loosely coupled version in order 
				 * to decouple Policeman from Evidence
				 */
				for ( Evidence evidence : evidenceBox.extractEvidence() ) {
				
					if ( evidence.getEvidenceType().equals( evidenceType )) {
					
						evidenceOfType.add(evidence);
					
					}
				
				}
			
			}
			
		}
		
		// Could also return null here
		return evidenceOfType;
		
	}
	
}