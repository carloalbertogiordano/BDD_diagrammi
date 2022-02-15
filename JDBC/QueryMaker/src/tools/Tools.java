package Tools;

import java.util.GregorianCalendar;

public class Tools {
    static public boolean checkDate(String date1, String date2) {
    	String[] dataOra1 = date1.split(" ");
    	String[] dataOra2 = date2.split(" ");
    	
    	String[] data1 = dataOra1[0].split("-");
    	String[] data2 = dataOra2[0].split("-");
    	
    	String[] ora1 = dataOra1[1].split(":");
    	String[] ora2 = dataOra2[1].split(":");
    	
    	int month1 = Integer.parseInt(data1[1]);
    	int month2 = Integer.parseInt(data2[1]);
    	
    	int hour1 = Integer.parseInt(ora1[0]);
    	int hour2 = Integer.parseInt(ora2[0]);
    	    	
    	int minute1 = Integer.parseInt(ora1[1]);
    	int minute2 = Integer.parseInt(ora2[1]);
    	
    	int second1 = Integer.parseInt(ora1[2]);
    	int second2 = Integer.parseInt(ora2[2]);
    	
    	if(data1[0].matches("\\d\\d\\d\\d") && data1[1].matches("\\d\\d") && data1[0].matches("\\d\\d") && month1<13 && month1>0) {
    		return false;
    	}
    	
    	if(data2[0].matches("\\d\\d\\d\\d") && data2[1].matches("\\d\\d") && data2[0].matches("\\d\\d") && month2<13 && month2>0) {
    		return false;
    	}
    	
    	GregorianCalendar d = new GregorianCalendar(Integer.parseInt(data1[0]), month1-1, Integer.parseInt(data1[2]), hour1, minute1, second1);
    	GregorianCalendar d2 = new GregorianCalendar(Integer.parseInt(data2[0]), month2-1, Integer.parseInt(data2[2]), hour2, minute2, second2);
    	
    	if(d2.before(d))
    		return false;
    	
    	return true;
    }
    
    public static String normalizeString (String s) {
    	s = s.replace("\t", "");    	
    	return s;
    }
    
}
