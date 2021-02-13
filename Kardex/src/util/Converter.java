package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Converter {
	
	public static int toInt(String s) {
		int num = 0;
		try {
			num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
		}
		return num;
	}
	
	/**
	 * Converte uma String no formato dd/mm/yyyy
	 * para um objeto do tipo Date.
	 * 
	 * @param str String a ser convertido.
	 * @return O objeto Date.
	 */
	public static Date str2date(String str) {
		SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = dmy.parse(str);
		} catch (ParseException e) {
		}
		return data;
	}
	
	
	/**
	 * Converte um objeto tipo Date para uma String 
	 * no format dd/mm/yyyy.
	 * 
	 * @param data Objeto Date a ser convertido.
	 * @return A string no formato dd/mm/yyyy
	 */
	public static String date2dmy(Date data) {
		SimpleDateFormat dmy = new SimpleDateFormat("dd/MM/yyyy");
		String str = dmy.format(data);
		return str;
	}

	/**
	 * Converte um objeto tipo Date para uma String 
	 * no format yyyy-mm-dd.
	 * 
	 * @param data Objeto Date a ser convertido.
	 * @return A string no formato yyyy-mm-dd
	 */
	public static String date2ymd(Date data) {
		SimpleDateFormat dmy = new SimpleDateFormat("yyyy-MM-dd");
		String str = dmy.format(data);
		return str;
	}
	
	/**
	 * Converte um objeto tipo Date para uma String 
	 * no format yyyy-mm-dd.
	 * 
	 * @param data Objeto Date a ser convertido.
	 * @return A string no formato yyyy-mm-dd
	 */
	public static String date2bd(Date data) {
		return date2dmy(data);
	}
	
}
