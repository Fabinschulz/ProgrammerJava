package aula14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import aula04.ClasseIMC;
import aula06.Mat;

public class TelaIMC extends JFrame {

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JPanel pnCenter;
	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbPeso;
	private JSpinner spPeso;
	private JLabel lbAltura;
	private JTextField tfAltura;
	private JButton btCalculaIMC;
	private JLabel lbLogo;
	private JTextArea txSaida;
	private JLabel lbResposta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIMC frame = new TelaIMC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaIMC() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnTitulo = new JPanel();
		pnTitulo.setPreferredSize(new Dimension(10, 40));
		pnTitulo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTitulo.setBackground(Color.ORANGE);
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		pnTitulo.setLayout(null);
		
		lbLogo = new JLabel("");
		lbLogo.setBounds(12, 7, 32, 25);
		lbLogo.setIcon(new ImageIcon(TelaIMC.class.getResource("/aula14/CalcIMC.png")));
		pnTitulo.add(lbLogo);
		
		lbTitulo = new JLabel("Calculadora de IMC");
		lbTitulo.setBounds(83, 7, 258, 29);
		lbTitulo.setFont(new Font("Dialog", Font.BOLD, 24));
		pnTitulo.add(lbTitulo);
		
		pnCenter = new JPanel();
		contentPane.add(pnCenter, BorderLayout.CENTER);
		SpringLayout sl_pnCenter = new SpringLayout();
		pnCenter.setLayout(sl_pnCenter);
		
		lbNome = new JLabel("Nome:");
		sl_pnCenter.putConstraint(SpringLayout.NORTH, lbNome, 40, SpringLayout.NORTH, pnCenter);
		sl_pnCenter.putConstraint(SpringLayout.WEST, lbNome, 30, SpringLayout.WEST, pnCenter);
		pnCenter.add(lbNome);
		
		tfNome = new JTextField();
		sl_pnCenter.putConstraint(SpringLayout.WEST, tfNome, 30, SpringLayout.EAST, lbNome);
		pnCenter.add(tfNome);
		tfNome.setColumns(10);
		
		lbPeso = new JLabel("Peso:");
		sl_pnCenter.putConstraint(SpringLayout.NORTH, lbPeso, 28, SpringLayout.SOUTH, lbNome);
		sl_pnCenter.putConstraint(SpringLayout.EAST, lbPeso, 0, SpringLayout.EAST, lbNome);
		pnCenter.add(lbPeso);
		
		spPeso = new JSpinner();
		sl_pnCenter.putConstraint(SpringLayout.NORTH, spPeso, 78, SpringLayout.NORTH, pnCenter);
		sl_pnCenter.putConstraint(SpringLayout.SOUTH, tfNome, -19, SpringLayout.NORTH, spPeso);
		sl_pnCenter.putConstraint(SpringLayout.WEST, spPeso, 30, SpringLayout.EAST, lbPeso);
		sl_pnCenter.putConstraint(SpringLayout.EAST, spPeso, 83, SpringLayout.EAST, lbPeso);
		pnCenter.add(spPeso);
		
		lbAltura = new JLabel("Altura:");
		sl_pnCenter.putConstraint(SpringLayout.NORTH, lbAltura, 0, SpringLayout.NORTH, lbPeso);
		sl_pnCenter.putConstraint(SpringLayout.EAST, lbAltura, -120, SpringLayout.EAST, pnCenter);
		pnCenter.add(lbAltura);
		
		tfAltura = new JTextField();
		sl_pnCenter.putConstraint(SpringLayout.NORTH, tfAltura, 22, SpringLayout.SOUTH, tfNome);
		sl_pnCenter.putConstraint(SpringLayout.EAST, tfNome, 0, SpringLayout.EAST, tfAltura);
		sl_pnCenter.putConstraint(SpringLayout.WEST, tfAltura, 6, SpringLayout.EAST, lbAltura);
		sl_pnCenter.putConstraint(SpringLayout.EAST, tfAltura, -66, SpringLayout.EAST, pnCenter);
		pnCenter.add(tfAltura);
		tfAltura.setColumns(10);
		
		btCalculaIMC = new JButton("Calcula IMC");
		sl_pnCenter.putConstraint(SpringLayout.NORTH, btCalculaIMC, 24, SpringLayout.SOUTH, tfAltura);
		sl_pnCenter.putConstraint(SpringLayout.EAST, btCalculaIMC, 0, SpringLayout.EAST, tfNome);
		btCalculaIMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculaIMC();
			}
		});
		pnCenter.add(btCalculaIMC);
		
		lbResposta = new JLabel("Resposta:");
		sl_pnCenter.putConstraint(SpringLayout.WEST, lbResposta, 10, SpringLayout.WEST, pnCenter);
		sl_pnCenter.putConstraint(SpringLayout.SOUTH, lbResposta, 0, SpringLayout.SOUTH, pnCenter);
		pnCenter.add(lbResposta);
		
		txSaida = new JTextArea();
		txSaida.setPreferredSize(new Dimension(1, 60));
		txSaida.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txSaida.setBackground(SystemColor.window);
		contentPane.add(txSaida, BorderLayout.SOUTH);
	}
	
	private void calculaIMC() {
		String nome = tfNome.getText();
		int peso = Integer.parseInt(spPeso.getValue().toString());
		double altura = Double.parseDouble(tfAltura.getText());
		double imc = peso / Mat.pow(altura,2);
		String classe = ClasseIMC.classeIMC(imc);
		txSaida.setText("");
		txSaida.append(nome + "\n" +
						   "Índice IMC = " + imc + "\n" +
						   "Classificação IMC = " + classe);
//		System.out.println(nome + "\n" +
//						   "Índice IMC = " + imc + "\n" +
//						   "Classificação IMC = " + classe);		
	}
}
