package Coursework1.tightlycoupled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

/**
 * @author Martin
 *
 */
public class EvidenceBox {

	/**
	 * 
	 */
	private int caseNumber;
	
	/**
	 * Case name is not actually used in the functionality,
	 * but this information should be stored as part of the modelling
	 * problem.
	 */
	private String caseName;
	
	/**
	 * 
	 */
	private ArrayList<Evidence> evidence;
	
	/**
	 * Students may have implemented a HashMap to help them 
	 * print the frequency of evidence, which is fine.
	 */
	//private HashMap<Evidence, Integer> evidenceFrequency;
	
	/**
	 * @param caseNumber
	 * @param caseName
	 */
	public EvidenceBox( int caseNumber, String caseName ) {
		
		this.caseNumber = caseNumber;
		
		this.caseName = caseName;
		
		evidence = new ArrayList<Evidence>();
		
		// HashMap implementation:
		//evidenceFrequency = new HashMap<Evidence, Integer>();
		
	}
	
	/**
	 * @param evidence
	 */
	public void addEvidence(Evidence evidence) {
		
		this.evidence.add(evidence);
		
		// HashMap implementation:
		/*if (evidenceFrequency.containsKey(evidence)) {
			
			evidenceFrequency.put(evidence, evidenceFrequency.get(evidence) + 1);
			
		} else {
			
			evidenceFrequency.put(evidence, 1);
		}*/
		
	}
	
	/**
	 * This method should only be present in the tightlycoupled version
	 * @return
	 */
	public ArrayList<Evidence> extractEvidence() {
		
		return evidence;
		
	}
	
	/**
	 * 
	 */
	public void display() {
		
		/* 
		 * I cheat here, a bit, by employing both Collections.frequency
		 * and a HashSet to avoid duplicate output.
		 * 
		 * Using a Hashmap to do this (below) is also a reasonable implementation,
		 * but does require some storage overhead.
		 */
		
		HashSet<String> output = new HashSet<String>();
		
		for ( Evidence evidence : evidence ) {
			
			// I avoid toString here for pedagogic purposes, and to illustrate the effects of tight coupling
			output.add(Collections.frequency(this.evidence, evidence) + "x " + evidence.getEvidenceType());
			
		}
		
		for ( String line : output ) {
			
			System.out.println(line);
			
		}
		
		/*for ( Entry<Evidence, Integer> evidenceFrequencyEntry : evidenceFrequency.entrySet() ) {
			
			System.out.println(evidenceFrequencyEntry.getValue() + "x " + evidenceFrequencyEntry.getKey());
			
		}*/
		
	}
	
	/**
	 * @return
	 */
	public int getCaseNumber() {
		
		return caseNumber;
		
	}

}