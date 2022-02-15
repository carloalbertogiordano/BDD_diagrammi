package GUI;

import java.io.IOException;

public class BadDateTimeExcetion extends IOException {

	private static final long serialVersionUID = -5099520271793090870L;

	public BadDateTimeExcetion() {
		System.out.println("Inserire dataOra in questo formato: AAAA:MM:GG HH:MM:SS");
		printStackTrace();
	}

}
