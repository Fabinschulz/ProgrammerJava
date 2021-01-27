package aula03;


import javax.swing.JOptionPane;

public class entradaComJanelas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        entradaTexto();
	}

	public static void entradaTexto() {
		
		String nome = JOptionPane.showInputDialog("Nome: ");
		String idade = JOptionPane.showInputDialog("Idade: ");
		JOptionPane.showMessageDialog(null, "Nome: "+nome+" Idade: "+idade);
		
	}
	
}
  