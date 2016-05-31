package Coursework1;

import java.util.ArrayList;

import Coursework1.tightlycoupled.*;

/**
 * @author Martin
 *
 */
public class Main {

	/**
	 * 
	 */
	public Main() {
		
		// 1.
		
		Evidence dna = new Evidence( "DNA" );
		
		Evidence fingerprint = new Evidence( "fingerprint" );
		
		System.out.println(dna);
		
		System.out.println(fingerprint);
		
		// 2.
		
		EvidenceBox evidenceBox = new EvidenceBox( 2005000381, "Steven Avery" );
		
		evidenceBox.addEvidence(dna);
		
		evidenceBox.addEvidence(fingerprint);
		
		evidenceBox.display();
		
		// 3.
		
		Policeman james = new Policeman( "James Lenk" );
		
		Policeman andrew = new Policeman( "Andrew Colborn" );
		
		james.takeEvidenceBox(evidenceBox);
		
		System.out.print("Pieces of DNA Evidence in Evidence Box number 2005000381 found by James Lenk: "); 
		
		ArrayList<Evidence> evidenceFound = james.getEvidence(2005000381, "DNA");
		
		if ( evidenceFound.size() == 0 ) {
			
			System.out.println("None");
			
		} else {
			
			System.out.println(evidenceFound);
			
		}
		
	}
	
	public static void main( String[] args ) {
		
		new Main();
		
	}

}