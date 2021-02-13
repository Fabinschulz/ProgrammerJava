package aula18;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoTexto {

	private static final String ARQUIVO = 
			"C:\\Users\\Fabinschulz\\Desktop\\Programmer.js\\Arquivo.TXT";
	private static final String TEXTO = 
			"Um fator importante que deve ser\n" +
			"levando em conta ao se trabalhar\n" +
			"com as classes de Data Stream do\n" +
			"Java é que a leitura e a gravação\n" +
			"se dão por sequências de bytes, e\n" +
			"não por conteúdo de variáveis, ou\n" +
			"seja, cada entrada/saída conterá 1\n" +
			"byte = 8 bits.\n";
	
	public static void main(String[] args) {
		//gravaArquivo();
		//leArquivo();
		//leByteAByte();
		leComBufferedReader();
	}

	public static void leComBufferedReader() {
		try {
			FileReader arqEntrada = new FileReader(ARQUIVO);
			BufferedReader dados = new BufferedReader(arqEntrada);
			String linha = "";
			while (linha != null) {
				linha = dados.readLine();
				if (linha != null) System.out.println(linha);
			}
			dados.close();
			arqEntrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void leByteAByte() {
		FileInputStream arqEntrada = null;
		DataInputStream dados = null;
		try {
			arqEntrada = new FileInputStream(ARQUIVO);
			dados = new DataInputStream(arqEntrada);
			while (true) {
				char c = (char) dados.readByte();
				System.out.print(c);
			}
		} catch (IOException e) {
			try {
				dados.close();
				arqEntrada.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("\n**********   Fim do arquivo   *********\n");
		}
	}
	
	public static void leArquivo() {		
		try {
			FileInputStream arqEntrada = new FileInputStream(ARQUIVO);
			DataInputStream dados = new DataInputStream(arqEntrada);
			String texto = dados.readLine();
			System.out.println(texto);
			dados.close();
			arqEntrada.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void gravaArquivo() {
		try {
			FileOutputStream arqSaida = new FileOutputStream(ARQUIVO);
			DataOutputStream dados = new DataOutputStream(arqSaida);
			dados.writeBytes(TEXTO);
			dados.close();
			arqSaida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Texto gravado!");
	}

}