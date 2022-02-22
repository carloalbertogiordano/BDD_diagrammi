package tools;

import java.util.GregorianCalendar;

public class Tools {    
    public static String normalizeString (String s) {
    	if(s!=null)
    	s = s.replace("\t", "");    	
    	return s;
    }
}
