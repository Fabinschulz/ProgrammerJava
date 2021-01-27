package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import util.Configura;

import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JLabel lblLogo;
	private JComboBox cbTema;
	private JLabel lbTema;

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
		setTitle("Sistema de Controle de Estoque");
		setLocationRelativeTo(null);
		setTemas();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 394);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setPreferredSize(new Dimension(28, 28));
		contentPane.setBorder(new CompoundBorder());
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnTitulo = new JPanel();
		pnTitulo.setPreferredSize(new Dimension(10, 70));
		pnTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnTitulo.setBackground(SystemColor.inactiveCaption);
		pnTitulo.setForeground(Color.WHITE);
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		pnTitulo.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(20, 8, 64, 59);
		lblLogo.setIcon(new ImageIcon(Tela.class.getResource("/images/Logo3.png")));
		pnTitulo.add(lblLogo);
		
		lbTitulo = new JLabel("Sistema de Controle de Estoque");
		lbTitulo.setBounds(133, 22, 369, 28);
		lbTitulo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 24));
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setBackground(Color.WHITE);
		pnTitulo.add(lbTitulo);
		
		pnMenu = new JPanel();
		pnMenu.setBackground(new Color(0, 51, 255));
		pnMenu.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(pnMenu, BorderLayout.WEST);
		pnMenu.setLayout(new GridLayout(6, 1, 0, 0));
		
		btProdutos = new JButton("Produtos\r\n");
		btProdutos.setForeground(Color.WHITE);
		btProdutos.setContentAreaFilled(false);
		btProdutos.setBorderPainted(false);
		pnMenu.add(btProdutos);
		
		btClientes = new JButton("Clientes\r\n");
		btClientes.setForeground(Color.WHITE);
		btClientes.setBorderPainted(false);
		btClientes.setContentAreaFilled(false);
		pnMenu.add(btClientes);
		
		btFornecedor = new JButton("Fornecedores\r\n");
		btFornecedor.setForeground(Color.WHITE);
		btFornecedor.setContentAreaFilled(false);
		btFornecedor.setBorderPainted(false);
		pnMenu.add(btFornecedor);
		
		btEntradas = new JButton("Entradas");
		btEntradas.setForeground(Color.WHITE);
		btEntradas.setBorderPainted(false);
		btEntradas.setContentAreaFilled(false);
		pnMenu.add(btEntradas);
		
		btSaida = new JButton("Sa\u00EDdas\r\n");
		btSaida.setForeground(Color.WHITE);
		btSaida.setContentAreaFilled(false);
		btSaida.setBorderPainted(false);
		pnMenu.add(btSaida);
		
		btMov = new JButton("Movimenta\u00E7\u00E3o");
		btMov.setForeground(Color.WHITE);
		btMov.setBorderPainted(false);
		btMov.setContentAreaFilled(false);
		pnMenu.add(btMov);
		
		pnRodape = new JPanel();
		pnRodape.setBackground(Color.DARK_GRAY);
		pnRodape.setForeground(Color.BLACK);
		contentPane.add(pnRodape, BorderLayout.SOUTH);
		pnRodape.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));
		
		lbTema = new JLabel("Tema:");
		lbTema.setForeground(SystemColor.text);
		pnRodape.add(lbTema);
		
		cbTema = new JComboBox();
		cbTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel(); 
			}
		});
		cbTema.setModel(new DefaultComboBoxModel(new String[] {"Metal", "Nimbus", "CDE/Motif", "Windows", "Windows Classic"}));
		pnRodape.add(cbTema);
		
		btListar = new JButton("Listar\r\n");
		pnRodape.add(btListar);
		
		btLimpar = new JButton("Limpar");
		pnRodape.add(btLimpar);
		
		btCancelar = new JButton("Cancelar\r\n");
		pnRodape.add(btCancelar);
		
		btGravar = new JButton("Gravar\r\n");
		pnRodape.add(btGravar);
	}
	private void setLookAndFeel() {
		String laf = (String) cbTema.getSelectedItem();
		Configura.lookAndFeel(laf);
		SwingUtilities.updateComponentTreeUI(this);
		this.repaint();
	}
	private void setTemas() {
		cbTema.removeAllItems();
		for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {
			cbTema.addItem(info.getName());
			
		}
		
	}
	
	
	
	
	
}
