package Coursework1.looselycoupled;

import java.util.ArrayList;

/**
 * You should look at this version *after* looking at the tightly coupled version.
 * 
 * The only difference in this version is the removal of extractEvidence() in EvidenceBox 
 * (i.e. the removal of anyway to get the evidence list from outside EvidenceBox) and
 * the encapsulation of finding evidence of a certain type inside EvidenceBox (getEvidenceByType).
 * 
 * Ensure you know the difference between the loosely and tightly coupled versions
 * so that you can reward the students accordingly.
 * 
 * @author Martin
 *
 */
public class Policeman {

	/**
	 * 
	 */
	private String name;
	
	/**
	 * 
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
	 * @param evidenceBox
	 */
	public void takeEvidenceBox( EvidenceBox evidenceBox ) {
		
		evidenceBoxes.add(evidenceBox);
		
	}

	/**
	 * This method is now shorter, and doesn't interact directly with the Evidence 
	 * objects. Instead, it calls this functionality inside the EvidenceBox class.
	 * Thus, there is looser coupling. 
	 * 
	 * @param caseNumber
	 * @param evidenceType
	 * @return
	 */
	public ArrayList<Evidence> getEvidence( int caseNumber, String evidenceType ) {
		
		for ( EvidenceBox evidenceBox : evidenceBoxes ) {
			
			if ( evidenceBox.getCaseNumber() == caseNumber ) {
				
				return evidenceBox.getEvidenceByType( evidenceType );
				
			}
			
		}
		
		// Could also return null here
		return new ArrayList<Evidence>();
		
	}
	
}