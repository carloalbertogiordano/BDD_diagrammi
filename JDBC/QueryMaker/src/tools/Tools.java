package Tools;

import java.util.GregorianCalendar;

public class Tools {
    static public boolean checkDate(String date1, String date2) {
    	String[] s1 = date1.split("-");
    	String[] s2 = date2.split("-");
    	
    	int month1 = Integer.parseInt(s1[1]);
    	int month2 = Integer.parseInt(s2[1]);
    	
    	if(s1[0].matches("\\d\\d\\d\\d") && s1[1].matches("\\d\\d") && s1[0].matches("\\d\\d") && month1<13 && month1>0) {
    		return false;
    	}
    	
    	if(s2[0].matches("\\d\\d\\d\\d") && s2[1].matches("\\d\\d") && s2[0].matches("\\d\\d") && month2<13 && month2>0) {
    		return false;
    	}
    	
    	GregorianCalendar d = new GregorianCalendar(Integer.parseInt(s1[0]), month1, Integer.parseInt(s1[2]));
    	GregorianCalendar d2 = new GregorianCalendar(Integer.parseInt(s2[0]), month2, Integer.parseInt(s2[2]));
    	
    	if(d2.before(d))
    		return false;
    	
    	return true;
    }
    
    public static String normalizeString (String s) {
    	s = s.replace("\t", "");    	
    	return s;
    }
    
}
