package util;


import java.text.ParseException;

import javax.swing.text.MaskFormatter;

public class Mascara {
	
	public static MaskFormatter cnpj() {
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##.###.###/####-##");
			mf.setPlaceholderCharacter('_');
		} catch (ParseException e) {
		}
		return mf;
	}

	public static MaskFormatter telefone() {
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("(##) ####-####");
			mf.setPlaceholderCharacter('_');
		} catch (ParseException e) {
		}
		return mf;
	}

	public static MaskFormatter data() {
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("##/##/####");
			mf.setPlaceholderCharacter('_');
		} catch (ParseException e) {
		}
		return mf;
	}
	
}