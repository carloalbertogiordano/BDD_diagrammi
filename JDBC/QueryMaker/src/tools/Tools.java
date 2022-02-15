package tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.zip.DataFormatException;

import GUI.BadDateTimeExcetion;

public class Tools {
    static public boolean checkDate(String date1, String date2) {
//    	String[] campo1 = date1.split(" ");
//    	String[] campo2 = date2.split(" ");
//    	
//    	String[] d1 = campo1[0].split("-");
//    	String[] d2 = campo2[0].split("-");
//    	
//    	String[] ora1 = campo1[1].split(":");
//    	String[] ora2 = campo2[1].split(":");
//    	
//    	int month1 = Integer.parseInt(d1[1]);
//    	int month2 = Integer.parseInt(d2[1]);
//    	
//    	int hour1 = Integer.parseInt(ora1[0]);
//    	int hour2 = Integer.parseInt(ora2[0]);
//    	    	
//    	int minute1 = Integer.parseInt(ora1[1]);
//    	int minute2 = Integer.parseInt(ora2[1]);
//    	
//    	int second1 = Integer.parseInt(ora1[2]);
//    	int second2 = Integer.parseInt(ora2[2]);
//    	
//    	if(!d1[0].matches("\\d\\d\\d\\d") || !d1[1].matches("\\d\\d") || !d1[0].matches("\\d\\d") || !(month1<13) || !(month1>0)) {
//    		return false;
//    	}
//    	
//    	if(!d2[0].matches("\\d\\d\\d\\d") || !d2[1].matches("\\d\\d") || !d2[0].matches("\\d\\d") || !(month2<13) || !(month2>0)) {
//    		return false;
//    	}
//    	
//    	GregorianCalendar da1 = new GregorianCalendar(Integer.parseInt(d1[0]), month1-1, Integer.parseInt(d1[2]), hour1, minute1, second1);
//    	GregorianCalendar da2 = new GregorianCalendar(Integer.parseInt(d2[0]), month2-1, Integer.parseInt(d2[2]), hour2, minute2, second2);
//    	
//    	if(da2.before(da1)) {
//    		return false;
//    	}
//    	
//    	return true;
    	
    	if(date1.length() != 17 || date2.length() != 17)
    		return false;
    	String data1 = getDate(date1);
    	String ora1 = getTime(date1);
    	String data2 = getDate(date2);
    	String ora2 = getTime(date2);
    	
    	if (!dateValidation(data1) || !dateValidation(data2))
    		return false;
    	 
    	
    	if(!hourValidation(ora1) || !hourValidation(ora2))
    		return false;
    	
    	
    	
    }
    
    private static boolean hourValidation(String T) {
    	String oraS = getHour(T);
    	
    	if(ora < 0 || ora > "23") {
    		
    	}
    }

    private static boolean dateValidation(String date)
    {
      boolean status = false;
    if (checkDate(date)) {
      DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
      dateFormat.setLenient(false);
      try {
        dateFormat.parse(date);
        status = true;
      } catch (Exception e) {
        status = false;
      }
    }
    return status;
    }
    
    static boolean checkDate(String date) {
    String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
    boolean flag = false;
    if (date.matches(pattern)) {
      flag = true;
    }
    return flag;
  }
    
    private static String getTime(String d) {
    	String ora = getHour(d);
    	String minuto = getMinute(d);
    	String secondo = getSecond(d);
    	return ora+":"+minuto+":"+secondo;
    }
    private static String getHour(String h) {
    	return h.substring(11, 13);
    }
    private static String getMinute (String m) {
    	return m.substring(14, 16);
    }
    private static String getSecond (String s) {
    	return s.substring(17);
    }
    
    private static String getDate(String d) {
    	String anno = getYear(d);
    	String mese = getMonth(d);
    	String giorno = getDay(d);
    	return anno+"-"+mese+"-"+giorno; 
    }
    private static String getYear(String a) {
    	return a.substring(0,4);
    }
    private static String getMonth(String m) {
    	return m.substring(5, 7);
    }
    private static String getDay(String g) {
    	return g.substring(9);
    }

    public static String normalizeString (String s) {
    	s = s.replace("\t", "");    	
    	return s;
    }
    
}
