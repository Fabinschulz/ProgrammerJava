package aula22;

import java.text.ParseException;

import javax.swing.text.MaskFormatter;


public class Mascara {
	
	public static MaskFormatter data() {
		MaskFormatter mf = null;
		try {
        mf = new MaskFormatter("##/##/####");
        mf.setPlaceholderCharacter('*');
	}catch (ParseException e) {
		e.printStackTrace();
		}
		return mf;
	}
	public static MaskFormatter celular() {
		MaskFormatter mf = null;
		try {
        mf = new MaskFormatter("(##) #-####-####");
        mf.setPlaceholderCharacter('_');
	}catch (ParseException e) {
		e.printStackTrace();
		}
		return mf;
	}

	public static MaskFormatter telefone() {
		MaskFormatter mf = null;
		try {
        mf = new MaskFormatter("(#) ####-####");
        mf.setPlaceholderCharacter('*');
	}catch (ParseException e) {
		e.printStackTrace();
		}
		return mf;
	}
}
