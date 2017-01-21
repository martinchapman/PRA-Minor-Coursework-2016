package Coursework4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Nice little regex tester class :-)
 * 
 * @author Martin
 *
 */
public class RegexTester {

	public RegexTester( String pattern, String input ) {
		
	    Pattern r = Pattern.compile(pattern);

	    Matcher m = r.matcher(input);
	    
	    System.out.println(m.groupCount());
	    
	    if ( m.groupCount() > 0 ) {
	    	
	    	m.find();
	    	
	    	for ( int i = 1; i < m.groupCount() + 1; i++ ) {
	    		
	    		System.out.println( m.group(i) );
	    		
	    	}
	    	
	    }
 
	    m.reset();
	    
	    if ( m.matches() ) {
	    	
	    	System.out.println( m.group() );
	    	
	    }
	    
	    m.reset();
	    
	    if ( m.find() ) {
	    	
            System.out.println( m.group() + " (" + m.start(0) + "-" + m.end(0) + ")" );
        
	    }
	    
	    m.reset();
	    
	    while ( m.find() ) {
	    	
	    	System.out.println(m.group());
	    	
	    }
	    
	}
	
	public static void main(String[] args) {
		
		new RegexTester("", "");
		
	}
	
}