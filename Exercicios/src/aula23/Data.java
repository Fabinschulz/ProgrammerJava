package aula23;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Data {
	
	public static void main(String[] args) {
		testeDate();
		testeSDF();
	}
	
	private static void testeSDF() {
		Date agora = new Date();

		SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yy");
		SimpleDateFormat ymd = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("dd/mm/yy = " + dmy.format(agora));
		System.out.println("yyyy/mm/dd = " + ymd.format(agora));
	}
	
	private static void testeDate() {
		Date agora = new Date();  // data atual do sistema
		Date inicio = new Date(0);   // data inicial GMT
		Date inicioBR = new Date(1000*60*60*3); // data inicial Brasil
		Date d1 = new Date("05/02/2021");
		Date d2 = Date.from(Instant.parse("2021-02-05T20:00:00Z"));
		
		System.out.println("Data atual = " + agora);
		System.out.println("Data inicial GMT = " + inicio);
		System.out.println("Data inicial Brasil = " + inicioBR);
		System.out.println("Data new Date = " + d1);
		System.out.println("Data.from Instant = " + d2);
		
	}

}