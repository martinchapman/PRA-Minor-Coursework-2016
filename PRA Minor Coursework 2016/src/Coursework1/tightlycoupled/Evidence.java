package Coursework1.tightlycoupled;

/**
 * Represents a piece of Evidence found at a crime scene,
 * with a type, getters and setters and a toString().
 * 
 * Arguably just a wrapper for a string at the moment, but
 * important when considering extensibility.
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return type;
		
	}
	
	public boolean equals( Evidence otherEvidence ) {
		
		return type.equals(otherEvidence.type);
		
	}

}