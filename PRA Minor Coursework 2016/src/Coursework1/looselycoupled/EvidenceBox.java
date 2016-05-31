package Coursework1.looselycoupled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

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
public class EvidenceBox {

	/**
	 * 
	 */
	private int caseNumber;
	
	/**
	 * 
	 */
	private String caseName;
	
	/**
	 * 
	 */
	private ArrayList<Evidence> evidence;
	
	/**
	 * @param caseNumber
	 * @param caseName
	 */
	public EvidenceBox( int caseNumber, String caseName ) {
		
		this.caseNumber = caseNumber;
		
		this.caseName = caseName;
		
		evidence = new ArrayList<Evidence>();
		
	}
	
	/**
	 * @param evidence
	 */
	/**
	 * @param evidence
	 */
	public void addEvidence(Evidence evidence) {
		
		this.evidence.add(evidence);
		
	}
	
	// This should be removed in the loosely coupled version:
	/*public ArrayList<Evidence> extractEvidence() {
		
		return evidence;
		
	}*/
	
	/**
	 * 
	 */
	public void display() {
		
		HashSet<String> output = new HashSet<String>();
		
		for ( Evidence evidence : evidence ) {
			
			// Rely on toString(), now effect of tight coupling has been illustrated
			output.add(Collections.frequency(this.evidence, evidence) + "x " + evidence);
			
		}
		
		for ( String line : output ) {
			
			System.out.println(line);
			
		}
		
	}
	
	/**
	 * @return
	 */
	public int getCaseNumber() {
		
		return caseNumber;
		
	}

	/**
	 * This has been moved from Policeman in the tightly coupled version
	 * and placed inside its own encapsulated method.
	 * 
	 * @param evidenceType
	 * @return
	 */
	public ArrayList<Evidence> getEvidenceByType( String evidenceType ) {
		
		ArrayList<Evidence> evidenceOfType = new ArrayList<Evidence>();
		
		for ( Evidence evidence : this.evidence ) {
			
			if ( evidence.getEvidenceType().equals( evidenceType )) {
				
				evidenceOfType.add(evidence);
				
			}
			
		}
		
		// Could do check for empty list and return null
		return evidenceOfType;
		
	}

}

