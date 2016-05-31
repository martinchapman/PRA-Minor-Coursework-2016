package Coursework1.looselycoupled;

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
public class Evidence {

	/**
	 * 
	 */
	private String type;
	
	/**
	 * @param type
	 */
	public Evidence( String type ) {
		
		this.type = type;
		
	}
	
	/**
	 * @return
	 */
	public String getEvidenceType() {
		
		return type;
		
	}
	
	public String toString() {
		
		return type;
		
	}
	
	public boolean equals( Evidence otherEvidence ) {
		
		return type.equals(otherEvidence.type);
		
	}

}