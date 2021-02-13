package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import model.Produto;

public class TelaListagem extends JFrame {

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbLogo;
	private JLabel lbTitulo;
	private JPanel pnCentral;
	private JScrollPane scrollPane;
	private JTable tabela;

	/**
	 * Create the frame.
	 */
	public TelaListagem(Paineis painel) {
		initComponents();
		setTitle("Sistema de Controle de Estoque");
		if (painel == Paineis.PRODUTOS) {
			lbTitulo.setText("Listagem de Produtos");
			atualizaTabelaProdutos();
		} else if (painel == Paineis.FORNECEDORES) {
			lbTitulo.setText("Listagem de Fornecedores");
			atualizaTabelaFornecedores();
		}
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 670, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnTitulo = new JPanel();
		pnTitulo.setPreferredSize(new Dimension(10, 70));
		pnTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnTitulo.setBackground(SystemColor.activeCaption);
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		pnTitulo.setLayout(null);
		
		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(TelaListagem.class.getResource("/images/Logo3.png")));
		lbLogo.setBounds(10, 11, 64, 59);
		pnTitulo.add(lbLogo);
		
		lbTitulo = new JLabel("Sistema de Controle de Estoque");
		lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitulo.setBounds(21, 11, 613, 39);
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		pnTitulo.add(lbTitulo);
		
		pnCentral = new JPanel();
		contentPane.add(pnCentral, BorderLayout.CENTER);
		pnCentral.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 644, 280);
		pnCentral.add(scrollPane);
		
		tabela = new JTable();
		tabela.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tabela);
	}

	private void atualizaTabelaProdutos() {
		tabela.setModel(Produto.getTableModel());

		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
		direita.setHorizontalAlignment(SwingConstants.RIGHT);

		tabela.getTableHeader().setDefaultRenderer(centro);
		tabela.getColumnModel().getColumn(0).setCellRenderer(centro);
		tabela.getColumnModel().getColumn(3).setCellRenderer(direita);
		tabela.getColumnModel().getColumn(4).setCellRenderer(direita);
		tabela.getColumnModel().getColumn(5).setCellRenderer(direita);

		tabela.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(50);
		tabela.getTableHeader().getColumnModel().getColumn(1).setMinWidth(200);
		tabela.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(60);
		tabela.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(60);
		tabela.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(60);
	}
	
	private void atualizaTabelaFornecedores() {
		
	}
}