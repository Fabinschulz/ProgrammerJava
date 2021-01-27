package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JPanel pnMenu;
	private JButton btProdutos;
	private JButton btClientes;
	private JButton btFornecedor;
	private JPanel pnRodape;
	private JButton btListar;
	private JButton btEntradas;
	private JButton btSaida;
	private JButton btLimpar;
	private JButton btMov;
	private JButton btCancelar;
	private JButton btGravar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 372);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setPreferredSize(new Dimension(28, 28));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnTitulo = new JPanel();
		pnTitulo.setBackground(Color.BLUE);
		pnTitulo.setForeground(Color.WHITE);
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		
		lbTitulo = new JLabel("Sistema de Controle de Estoque");
		lbTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setBackground(Color.WHITE);
		lbTitulo.setSize(new Dimension(50, 50));
		pnTitulo.add(lbTitulo);
		
		pnMenu = new JPanel();
		contentPane.add(pnMenu, BorderLayout.WEST);
		pnMenu.setLayout(new GridLayout(6, 1, 0, 0));
		
		btProdutos = new JButton("Produtos\r\n");
		btProdutos.setContentAreaFilled(false);
		btProdutos.setBorderPainted(false);
		pnMenu.add(btProdutos);
		
		btClientes = new JButton("Clientes\r\n");
		btClientes.setBorderPainted(false);
		btClientes.setContentAreaFilled(false);
		pnMenu.add(btClientes);
		
		btFornecedor = new JButton("Fornecedores\r\n");
		btFornecedor.setContentAreaFilled(false);
		btFornecedor.setBorderPainted(false);
		pnMenu.add(btFornecedor);
		
		btEntradas = new JButton("Entradas");
		btEntradas.setBorderPainted(false);
		btEntradas.setContentAreaFilled(false);
		pnMenu.add(btEntradas);
		
		btSaida = new JButton("Sa\u00EDdas\r\n");
		btSaida.setContentAreaFilled(false);
		btSaida.setBorderPainted(false);
		pnMenu.add(btSaida);
		
		btMov = new JButton("Movimenta\u00E7\u00E3o");
		btMov.setBorderPainted(false);
		btMov.setContentAreaFilled(false);
		pnMenu.add(btMov);
		
		pnRodape = new JPanel();
		pnRodape.setBackground(Color.BLACK);
		pnRodape.setForeground(Color.BLACK);
		contentPane.add(pnRodape, BorderLayout.SOUTH);
		pnRodape.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));
		
		btListar = new JButton("Listar\r\n");
		pnRodape.add(btListar);
		
		btLimpar = new JButton("Limpar");
		pnRodape.add(btLimpar);
		
		btCancelar = new JButton("Cancelar\r\n");
		pnRodape.add(btCancelar);
		
		btGravar = new JButton("Gravar\r\n");
		pnRodape.add(btGravar);
	}

}
