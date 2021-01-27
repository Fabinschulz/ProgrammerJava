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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import aula6.Mat;

/*
 * criar calculadora de 4 operações:
 *  - soma / subtração / multiplicação / divisão
 *  solicitar dois doubles e criar botões para as operações
 *  mostrar o resultado em um textArea
 *  
 *  Otimizações:
 *  1) fazer rotinas para subtração / multiplicação / divisão
 *  2) utilizar ícones para as operações
 *  3) incluir botões para cálculo de MMC e MDC
 *  4) incluir botão para cálculo de potência (n1^n2)
 *  5) incluir botão para o cálculo do fatorial (n1)
 *  
 */
public class TelaCalculadora extends JFrame {

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JPanel pnCentral;
	private JLabel lbValor1;
	private JLabel lbValor2;
	private JTextField tfValor1;
	private JTextField tfValor2;
	private JButton btSoma;
	private JButton btSub;
	private JButton btMult;
	private JButton btDiv;
	private JTextArea txSaida;
	private JButton btMMC;
	private JButton btMDC;
	private JButton btPot;
	private JButton btFat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCalculadora frame = new TelaCalculadora();
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
	public TelaCalculadora() {
		initComponents();
		setTitle("Calculadora Java");
		txSaida.setText("");
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnTitulo = new JPanel();
		pnTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnTitulo.setBackground(SystemColor.activeCaption);
		pnTitulo.setPreferredSize(new Dimension(10, 40));
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		pnTitulo.setLayout(null);
		
		lbTitulo = new JLabel("Calculadora Java");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setFont(new Font("Dialog", Font.PLAIN, 26));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setBounds(12, 5, 508, 28);
		pnTitulo.add(lbTitulo);
		
		pnCentral = new JPanel();
		contentPane.add(pnCentral, BorderLayout.CENTER);
		SpringLayout sl_pnCentral = new SpringLayout();
		pnCentral.setLayout(sl_pnCentral);
		
		lbValor1 = new JLabel("Valor 1");
		sl_pnCentral.putConstraint(SpringLayout.NORTH, lbValor1, 36, SpringLayout.NORTH, pnCentral);
		sl_pnCentral.putConstraint(SpringLayout.WEST, lbValor1, 27, SpringLayout.WEST, pnCentral);
		pnCentral.add(lbValor1);
		
		lbValor2 = new JLabel("Valor 2");
		sl_pnCentral.putConstraint(SpringLayout.NORTH, lbValor2, 50, SpringLayout.SOUTH, lbValor1);
		sl_pnCentral.putConstraint(SpringLayout.WEST, lbValor2, 0, SpringLayout.WEST, lbValor1);
		pnCentral.add(lbValor2);
		
		tfValor1 = new JTextField();
		sl_pnCentral.putConstraint(SpringLayout.NORTH, tfValor1, 6, SpringLayout.SOUTH, lbValor1);
		sl_pnCentral.putConstraint(SpringLayout.WEST, tfValor1, 0, SpringLayout.WEST, lbValor1);
		pnCentral.add(tfValor1);
		tfValor1.setColumns(10);
		
		tfValor2 = new JTextField();
		sl_pnCentral.putConstraint(SpringLayout.NORTH, tfValor2, 6, SpringLayout.SOUTH, lbValor2);
		sl_pnCentral.putConstraint(SpringLayout.WEST, tfValor2, 0, SpringLayout.WEST, lbValor1);
		pnCentral.add(tfValor2);
		tfValor2.setColumns(10);
		
		btSoma = new JButton("");
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btSoma, 24, SpringLayout.NORTH, pnCentral);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btSoma, 58, SpringLayout.EAST, tfValor1);
		btSoma.setIcon(new ImageIcon(TelaCalculadora.class.getResource("/aula14/btSoma.png")));
		btSoma.setPreferredSize(new Dimension(52, 52));
		btSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				soma();
			}
		});
		pnCentral.add(btSoma);
		
		btSub = new JButton("");
		btSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sub();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.EAST, btSoma, -18, SpringLayout.WEST, btSub);
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btSub, 0, SpringLayout.NORTH, btSoma);
		btSub.setIcon(new ImageIcon(TelaCalculadora.class.getResource("/aula14/btSub.png")));
		btSub.setPreferredSize(new Dimension(52, 52));
		pnCentral.add(btSub);
		
		btMult = new JButton("");
		btMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mult();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btSoma, -6, SpringLayout.NORTH, btMult);
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btMult, -52, SpringLayout.SOUTH, tfValor2);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btMult, 10, SpringLayout.WEST, btSoma);
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btMult, 0, SpringLayout.SOUTH, tfValor2);
		btMult.setIcon(new ImageIcon(TelaCalculadora.class.getResource("/aula14/btMult.png")));
		btMult.setPreferredSize(new Dimension(52, 52));
		pnCentral.add(btMult);
		
		btDiv = new JButton("");
		btDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				div();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btSub, -13, SpringLayout.NORTH, btDiv);
		sl_pnCentral.putConstraint(SpringLayout.EAST, btSub, 0, SpringLayout.EAST, btDiv);
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btDiv, 0, SpringLayout.SOUTH, tfValor2);
		btDiv.setIcon(new ImageIcon(TelaCalculadora.class.getResource("/aula14/btDiv.png")));
		btDiv.setPreferredSize(new Dimension(52, 52));
		pnCentral.add(btDiv);
		
		btMMC = new JButton("MMC");
		btMMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mmc();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.WEST, btMMC, 0, SpringLayout.WEST, lbValor1);
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btMMC, -23, SpringLayout.SOUTH, pnCentral);
		pnCentral.add(btMMC);
		
		btMDC = new JButton("MDC");
		btMDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mdc();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btMDC, 0, SpringLayout.NORTH, btMMC);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btMDC, 21, SpringLayout.EAST, btMMC);
		pnCentral.add(btMDC);
		
		btPot = new JButton("X^Y");
		btPot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pot();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.EAST, btMult, 0, SpringLayout.EAST, btPot);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btPot, 19, SpringLayout.EAST, btMDC);
		sl_pnCentral.putConstraint(SpringLayout.SOUTH, btPot, 0, SpringLayout.SOUTH, btMMC);
		pnCentral.add(btPot);
		
		btFat = new JButton("X!");
		btFat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fat();
			}
		});
		sl_pnCentral.putConstraint(SpringLayout.EAST, btDiv, 0, SpringLayout.EAST, btFat);
		sl_pnCentral.putConstraint(SpringLayout.NORTH, btFat, 0, SpringLayout.NORTH, btMMC);
		sl_pnCentral.putConstraint(SpringLayout.WEST, btFat, 22, SpringLayout.EAST, btPot);
		pnCentral.add(btFat);
		
		txSaida = new JTextArea();
		txSaida.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 16));
		txSaida.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txSaida.setPreferredSize(new Dimension(200, 15));
		txSaida.setText("Saída");
		contentPane.add(txSaida, BorderLayout.EAST);
	}
	
	private void soma() {
		double n1 = Double.parseDouble(tfValor1.getText());
		double n2 = Double.parseDouble(tfValor2.getText());
		double resp = n1 + n2;
		txSaida.append(n1 + " + " + n2 + " = " + resp + "\n");
	}

	private void sub() {
		double n1 = Double.parseDouble(tfValor1.getText());
		double n2 = Double.parseDouble(tfValor2.getText());
		double resp = n1 - n2;
		txSaida.append(n1 + " - " + n2 + " = " + resp + "\n");
	}
	
	private void mult() {
		double n1 = Double.parseDouble(tfValor1.getText());
		double n2 = Double.parseDouble(tfValor2.getText());
		double resp = n1 * n2;
		txSaida.append(n1 + " * " + n2 + " = " + resp + "\n");
	}
	
	private void div() {
		double n1 = Double.parseDouble(tfValor1.getText());
		double n2 = Double.parseDouble(tfValor2.getText());
		double resp = n1 / n2;
		txSaida.append(n1 + " / " + n2 + " = " + resp + "\n");
	}
	
	private void mmc() {
		long n1 = Long.parseLong(tfValor1.getText());
		long n2 = Long.parseLong(tfValor2.getText());
		long resp = Mat.mmc(n1, n2);
		txSaida.append("MMC(" + n1 + "," + n2 + ") = " + resp + "\n");
	}

	private void mdc() {
		long n1 = Long.parseLong(tfValor1.getText());
		long n2 = Long.parseLong(tfValor2.getText());
		long resp = Mat.mdc(n1, n2);
		txSaida.append("MDC(" + n1 + "," + n2 + ") = " + resp + "\n");
	}	

	private void pot() {
		double n1 = Double.parseDouble(tfValor1.getText());
		int n2 = Integer.parseInt(tfValor2.getText());
		double resp = Mat.pow(n1, n2);
		txSaida.append(n1 + "^" + n2 + " = " + resp + "\n");
	}

	private void fat() {
		int n1 = Integer.parseInt(tfValor1.getText());
		double resp = Mat.fat(n1);
		txSaida.append(n1 + "! = " + resp + "\n");
	}
	
}