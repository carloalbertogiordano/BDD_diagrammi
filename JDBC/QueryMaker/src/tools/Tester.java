package tools;

import java.text.ParseException;

public class Tester {
	public static void main(String[] args) throws ParseException {
		
		System.out.println("TESTER DATE:\n");
		
		String dataOra1 = "2022-02-03 12:00:00";
		String dataOra2 = "2022-04-05 13:00:00";

		String dataOra3 = "2022-02-02 12:00:00";
		String dataOra4 = "2021-02-02 12:00:00";

		String dataOra5 = "1733463";
		String dataOra6 = "24356547586";
		
		if(Tools.checkDate(dataOra1, dataOra2))
			System.out.println("test1-OK");
		else {
			System.out.println("test1-FAILURE");
		}
		System.out.println("\n\n");
		if(Tools.checkDate(dataOra3, dataOra4))
			System.out.println("test2-OK");
		else {
			System.out.println("test2-FAILURE");
		}
		System.out.println("\n\n");
		if(Tools.checkDate(dataOra5, dataOra6))
			System.out.println("test3-OK");
		else {
			System.out.println("test4-FAILURE");
		}
		

	}

}
