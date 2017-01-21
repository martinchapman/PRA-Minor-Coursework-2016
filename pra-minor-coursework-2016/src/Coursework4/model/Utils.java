package Coursework4.model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Martin
 *
 */
public class Utils {
	
	/**
	 * @param start
	 * @param end
	 * @return
	 */
	public static int randomBetween( int start, int end ) {
	     
		return start + (int)Math.round( Math.random() * (end - start) );
    
	}
	
	/**
	 * @param line
	 * @param pattern
	 * @return
	 */
	public static String matchRegexAll( String line, String pattern ) {
		
		return matchRegex( line, pattern, 0 );
		
	}
	
	/**
	 * @param line
	 * @param pattern
	 * @param index
	 * @return
	 */
	public static String matchRegex( String line, String pattern, int index ) {
		
		ArrayList<String> matches = matchRegex( line, pattern );
		
		if ( matches != null ) {
		
			return matchRegex( line, pattern ).get( index );
		
		} else {
			
			return "";
			
		}
	
	}
	
	/**
	 * @param line
	 * @param pattern
	 * @return
	 */
	public static ArrayList<String> matchRegex( String line, String pattern ) {
		
		ArrayList<String> matches = new ArrayList<String>();
		
		if (line.equals("") || pattern.equals("")) return null;
	
		Pattern r = Pattern.compile(pattern);

	    Matcher m = r.matcher(line);
	    
	    ArrayList<String> groups = new ArrayList<String>();
	    
	    if ( m.groupCount() > 0 ) {
	    	
	    	m.find();
	    	
	    	for ( int i = 1; i < m.groupCount() + 1; i++ ) {
	    		
	    		groups.add( m.group(i) );
	    		
	    	}

    		return groups;
    		
	    }
 
	    m.reset();
	    
	    if ( m.matches() ) {
	    	
	    	groups.add(m.group());
	    	
	    	return groups;
	    
	    }
	    
	    m.reset();
	    
	    if ( m.find() ) {
	    	
            groups.add(m.group());
            
            return groups;
            
	    }
	    
	    return null;
     
	}
	
}