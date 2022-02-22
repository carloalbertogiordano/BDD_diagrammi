package tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Tools {
    static public boolean checkDate(String d1, String d2) throws ParseException {

    	//A A A A : M M : G G || H  H  :  M  M   :   S   S
    	//0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15  16  17  18
    	
    	if(d1.length() != 19 || d2.length() != 19) {
    		System.out.println("L1 corrente= "+d1.length()+"L2 corrente= "+d2.length()+"LunghezzaAttesa= 19");
    		return false;
    	}
    	
    	String data1 = getDate(d1);
    	System.out.println("data1: "+data1);
    	String tempo1 = getTime(d1);
    	System.out.println("ora1: "+tempo1);
    	String data2 = getDate(d2);
    	System.out.println("data2: "+data2);
    	String tempo2 = getTime(d2);
    	System.out.println("ora2: "+tempo2);

    	
    	if(!timeValidation(tempo1)) {
    		System.out.println("Date format is not valid");
    		return false;
    	}
    	
    	if(!timeValidation(tempo2)) {
    		System.out.println("Date format is not valid");
    		return false;
    	}
    	
    	if(dateValidation(data1)) {
    		return false;
    	}
    	
    	if(dateValidation(data2)) {
    		return false;
    	}
    	
    	System.out.println("DateTime Valid");
    	
    	if(!dateOrderIsCorrect(data1, data2)) {
    		System.out.println("Invalid dateTimeOrder, second in lower than first");
    		return false;
    	}
    	System.out.println("dateOrder Valid");

    	return true;
    	
    }
    
    private static boolean timeValidation (String time) {
    	if(hourValidation(time) && minuteValidation(time) && secondValidation(time))
    		return true;
    	return false;
    }

    private static boolean dateOrderIsCorrect (String dat1, String dat2) throws ParseException {
    	String data1 = getDate(dat1);
    	String data2 = getDate(dat2);
        GregorianCalendar cal1 = new GregorianCalendar(Integer.parseInt(data1.substring(0, 4)), Integer.parseInt(data1.substring(5, 7)), Integer.parseInt(data1.substring(8, 10))); 
        GregorianCalendar cal2 = new GregorianCalendar(Integer.parseInt(data2.substring(0, 4)), Integer.parseInt(data2.substring(5, 7)), Integer.parseInt(data2.substring(8, 10))); 
    	
    	if( cal1.after(cal2) )
    		return false;
    	return true;
    }
    
    private static boolean hourValidation(String o) {
    	int ora = Integer.parseInt(o.substring(0,2));
    	if(ora < 0 || ora > 23) {
    		return false;
    	}
    	return true;
    }
    
    private static boolean minuteValidation(String time) {
    	String mS = time.substring(3, 5);
    	int m = Integer.parseInt(mS);
    	if(m < 0 || m > 59) {
    		return false;
    	}
    	return true;
    }
    
    private static boolean secondValidation(String time) {
    	String sS = time.substring(6);
    	int s = Integer.parseInt(sS);
    	if(s < 0 || s > 59)
    		return false;
    	return true;
    }

    public static boolean dateValidation(String date)
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
    	String s = h.substring(11, 13);
    	System.out.println("getHour: "+s+ " PrecString: "+h);
    	return s;
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
    	return g.substring(8, 10);
    }

    public static String normalizeString (String s) {
    	s = s.replace("\t", "");    	
    	return s;
    }
    
}

