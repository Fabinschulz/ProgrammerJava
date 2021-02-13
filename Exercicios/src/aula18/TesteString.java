package aula18;

public class TesteString {
	
	public static void main(String[] args) {
		//testeString();
		//testeMetodos();
		testeConcat();
	}
	
	
	private static void testeConcat() {
		
		long tempo = 0;
		int qtde = 1_000_000;

		String str = "";
		tempo = System.currentTimeMillis();
		for (int i=0 ; i<qtde ; i++) {
			str = str.concat("x");
		}
		tempo = System.currentTimeMillis() - tempo;
		//System.out.println(str);
		System.out.println("String.concat = " + tempo);
		
		StringBuilder sb = new StringBuilder();
		tempo = System.currentTimeMillis();
		for (int i=0 ; i<qtde ; i++) {
			sb.append("o");
		}
		//System.out.println(sb);
		tempo = System.currentTimeMillis() - tempo;
		System.out.println("StringBuilder.append = " + tempo);
		
	}
	
	private static void testeMetodos() {
		String s = "JavaProgrammer";
		System.out.println("Métodos da classe String");
		System.out.println("String de base = " + s);
		System.out.println("o tamanho dessa string é".length());
		System.out.println("charAt(3) = " + s.charAt(3));
		System.out.println("concat = " + s.concat(" é bem legal!"));
		System.out.println("indexOf(g) = " + s.indexOf("g"));		
		System.out.println("replaceAll(a,i) = " + s.replaceAll("a","i"));
		System.out.println("split(a)");
		String[] s2 = s.split("a");
		for (String s3: s2) {
			System.out.println(s3);
		}
	}
	
	private static void testeString() {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = s1;
		s1 = "jvm";
		
		System.out.println("s1 == s2 : " + (s1==s2)); //false
		System.out.println("s1 == s3 : " + (s1==s3)); //false
		System.out.println("s1 == s4 : " + (s1==s4)); //false
		System.out.println("s2 == s3 : " + (s2==s3)); //false
		System.out.println("s2 == s4 : " + (s2==s4)); //true
		System.out.println("s3 == s4 : " + (s3==s4)); //false
		
		System.out.println("s2.equals(s3) : " + s2.equals(s3));
		
	}

}