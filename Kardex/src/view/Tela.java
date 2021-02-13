package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;

import model.Entrada;
import model.Fornecedor;
import model.Kardex;
import model.Produto;
import util.Configura;
import util.Converter;
import util.LinhasZebradasRenderer;
import util.Mascara;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private Paineis painel;  // informa o painel atual em foco
	private ArrayList<Produto> produtos = new ArrayList<>();

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JPanel pnMenu;
	private JButton btProdutos;
	private JButton btClientes;
	private JButton btFornecedores;
	private JButton btEntradas;
	private JButton btSaidas;
	private JButton btMovimentacao;
	private JPanel pnRodape;
	private JButton btListar;
	private JButton btCancelar;
	private JButton btGravar;
	private JButton btLimpar;
	private JPanel panel;
	private JLabel lbLogo;
	private JComboBox cbTema;
	private JLabel lbTema;
	private JPanel pnCentral;
	private JPanel pnProdutos;
	private JLabel lbProdutos;
	private JPanel pnClientes;
	private JLabel lbClientes;
	private JPanel pnFornecedores;
	private JLabel lbFornecedores;
	private JLabel lbProdutoID;
	private JTextField tfProdutoID;
	private JLabel lbProdutoNome;
	private JTextField tfProdutoNome;
	private JLabel lbProdutoLocalizacao;
	private JTextField tfProdutoLocalizacao;
	private JPanel pnQtde;
	private JLabel lbProdutoQtdeMinima;
	private JTextField tfProdutoQtdeMinima;
	private JLabel lbProdutoQtdeMaxima;
	private JTextField tfProdutoQtdeMaxima;
	private JLabel lbProdutoQtdeEstoque;
	private JTextField tfProdutoQtdeEstoque;
	private JLabel lbFornecedorID;
	private JTextField tfFornecedorID;
	private JLabel lbFornecedorCNPJ;
	private JFormattedTextField tfFornecedorCNPJ;
	private JLabel lbFornecedorNome;
	private JTextField tfFornecedorNome;
	private JLabel lbFornecedorTelefone;
	private JLabel lbFornecedorEmail;
	private JTextField tfFornecedorEmail;
	private JFormattedTextField tfFornecedorTelefone;
	private JPanel pnEntradas;
	private JPanel pnSaidas;
	private JPanel pnEntradaTitulo;
	private JLabel lbEntradas;
	private JScrollPane pnTabelaEntrada;
	private JTable tbEntrada;
	private JLabel lbAlterar;
	private JLabel lbIncluir;
	private JLabel lbExcluir;
	private JLabel lbSaidas;
	private JPanel pnKardex;
	private JPanel pnKardexTitulo;
	private JLabel lbKardex;
	private JScrollPane pnTabelaKardex;
	private JTable tbKardex;
	private JLabel lbKardexProduto;
	private JComboBox cbKardexProduto;

	/**
	 * Create the frame.
	 */
	public Tela() {
		initComponents();
		setTitle("Sistema de Controle de Estoque");
		setLocationRelativeTo(null);
		setTemas();
		setPainel(Paineis.PRODUTOS);
		setMascaras();
		limpaTelaProduto();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 507);
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
		lbLogo.setBounds(30, 7, 64, 59);
		lbLogo.setIcon(new ImageIcon(Tela.class.getResource("/images/Logo3.png")));
		pnTitulo.add(lbLogo);

		lbTitulo = new JLabel("Sistema de Controle de Estoque");
		lbTitulo.setBounds(150, 15, 452, 39);
		lbTitulo.setForeground(Color.WHITE);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		pnTitulo.add(lbTitulo);

		pnMenu = new JPanel();
		pnMenu.setBackground(new Color(25, 25, 112));
		pnMenu.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(pnMenu, BorderLayout.WEST);
		pnMenu.setLayout(new GridLayout(0, 1, 0, 0));

		btProdutos = new JButton("Produtos");
		btProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPainel(Paineis.PRODUTOS);
			}
		});
		btProdutos.setForeground(Color.WHITE);
		btProdutos.setContentAreaFilled(false);
		btProdutos.setBorderPainted(false);
		btProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnMenu.add(btProdutos);

		btClientes = new JButton("Clientes");
		btClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPainel(Paineis.CLIENTES);
			}
		});
		btClientes.setForeground(Color.WHITE);
		btClientes.setContentAreaFilled(false);
		btClientes.setBorderPainted(false);
		btClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnMenu.add(btClientes);

		btFornecedores = new JButton("Fornecedores");
		btFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPainel(Paineis.FORNECEDORES);
			}
		});
		btFornecedores.setForeground(Color.WHITE);
		btFornecedores.setContentAreaFilled(false);
		btFornecedores.setBorderPainted(false);
		btFornecedores.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnMenu.add(btFornecedores);

		btEntradas = new JButton("Entradas");
		btEntradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPainel(Paineis.ENTRADAS);
			}
		});
		btEntradas.setForeground(Color.WHITE);
		btEntradas.setContentAreaFilled(false);
		btEntradas.setBorderPainted(false);
		btEntradas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnMenu.add(btEntradas);

		btSaidas = new JButton("Sa\u00EDdas");
		btSaidas.setForeground(Color.WHITE);
		btSaidas.setContentAreaFilled(false);
		btSaidas.setBorderPainted(false);
		btSaidas.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnMenu.add(btSaidas);

		btMovimentacao = new JButton("Movimenta\u00E7\u00E3o");
		btMovimentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPainel(Paineis.MOVIMENTACAO);
			}
		});
		btMovimentacao.setForeground(Color.WHITE);
		btMovimentacao.setContentAreaFilled(false);
		btMovimentacao.setBorderPainted(false);
		btMovimentacao.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		pnMenu.add(btMovimentacao);

		pnRodape = new JPanel();
		pnRodape.setBackground(Color.DARK_GRAY);
		contentPane.add(pnRodape, BorderLayout.SOUTH);
		FlowLayout fl_pnRodape = new FlowLayout(FlowLayout.RIGHT, 20, 5);
		fl_pnRodape.setAlignOnBaseline(true);
		pnRodape.setLayout(fl_pnRodape);

		lbTema = new JLabel("Tema:");
		lbTema.setForeground(Color.WHITE);
		pnRodape.add(lbTema);

		cbTema = new JComboBox();
		cbTema.setPreferredSize(new Dimension(180, 24));
		cbTema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel();
			}
		});
		cbTema.setModel(new DefaultComboBoxModel(
				new String[] { "Metal", "Nimbus", "CDE/Motif", "Windows", "Windows Classic" }));
		pnRodape.add(cbTema);

		btListar = new JButton("Listar");
		btListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painel == Paineis.PRODUTOS) listaProduto();
				else if (painel == Paineis.FORNECEDORES) listaFornecedor();
			}
		});
		btListar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnRodape.add(btListar);

		btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painel == Paineis.PRODUTOS) limpaTelaProduto();
				else if (painel == Paineis.FORNECEDORES) limpaTelaFornecedor();
			}
		});
		btLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnRodape.add(btLimpar);

		btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painel == Paineis.PRODUTOS) limpaTelaProduto();
				else if (painel == Paineis.FORNECEDORES) limpaTelaFornecedor();
			}
		});
		btCancelar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnRodape.add(btCancelar);

		btGravar = new JButton("Gravar");
		btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (painel == Paineis.PRODUTOS) gravaProduto();
				else if (painel == Paineis.FORNECEDORES) gravaFornecedor();
			}
		});
		btGravar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		pnRodape.add(btGravar);

		pnCentral = new JPanel();
		contentPane.add(pnCentral, BorderLayout.CENTER);
		pnCentral.setLayout(new CardLayout(0, 0));

		pnProdutos = new JPanel();
		pnCentral.add(pnProdutos,Paineis.PRODUTOS.toString());

		lbProdutos = new JLabel("Produtos");
		lbProdutos.setFont(new Font("Tahoma", Font.PLAIN, 32));

		lbProdutoID = new JLabel("C\u00F3digo:");

		tfProdutoID = new JTextField();
		tfProdutoID.setColumns(10);

		lbProdutoNome = new JLabel("Nome:");

		tfProdutoNome = new JTextField();
		tfProdutoNome.setColumns(10);

		lbProdutoLocalizacao = new JLabel("Localiza\u00E7\u00E3o:");

		tfProdutoLocalizacao = new JTextField();
		tfProdutoLocalizacao.setColumns(10);

		pnQtde = new JPanel();
		pnQtde.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Quantidades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout Produtos = new GroupLayout(pnProdutos);
		Produtos.setHorizontalGroup(Produtos.createParallelGroup(Alignment.LEADING).addGroup(Produtos
				.createSequentialGroup().addGap(28)
				.addGroup(Produtos.createParallelGroup(Alignment.TRAILING).addComponent(lbProdutoLocalizacao)
						.addComponent(lbProdutoID).addComponent(lbProdutoNome))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(Produtos.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(tfProdutoID, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfProdutoNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
						.addComponent(tfProdutoLocalizacao, Alignment.LEADING).addComponent(pnQtde, Alignment.LEADING,
								GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, Produtos.createSequentialGroup().addContainerGap(233, Short.MAX_VALUE)
						.addComponent(lbProdutos).addGap(206)));
		Produtos.setVerticalGroup(Produtos.createParallelGroup(Alignment.LEADING).addGroup(Produtos
				.createSequentialGroup().addGap(22).addComponent(lbProdutos).addGap(18)
				.addGroup(Produtos.createParallelGroup(Alignment.BASELINE).addComponent(lbProdutoID).addComponent(
						tfProdutoID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(Produtos.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfProdutoNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lbProdutoNome))
				.addGap(18)
				.addGroup(Produtos.createParallelGroup(Alignment.BASELINE).addComponent(lbProdutoLocalizacao)
						.addComponent(tfProdutoLocalizacao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(pnQtde, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(31, Short.MAX_VALUE)));

		lbProdutoQtdeMinima = new JLabel("M\u00EDnima");

		tfProdutoQtdeMinima = new JTextField();
		tfProdutoQtdeMinima.setPreferredSize(new Dimension(60, 20));
		tfProdutoQtdeMinima.setColumns(10);

		lbProdutoQtdeMaxima = new JLabel("M\u00E1xima");

		tfProdutoQtdeMaxima = new JTextField();
		tfProdutoQtdeMaxima.setPreferredSize(new Dimension(60, 20));
		tfProdutoQtdeMaxima.setColumns(10);

		lbProdutoQtdeEstoque = new JLabel("Estoque");

		tfProdutoQtdeEstoque = new JTextField();
		tfProdutoQtdeEstoque.setPreferredSize(new Dimension(60, 20));
		tfProdutoQtdeEstoque.setColumns(10);
		GroupLayout gl_pnQtde = new GroupLayout(pnQtde);
		gl_pnQtde.setHorizontalGroup(gl_pnQtde.createParallelGroup(Alignment.LEADING).addGroup(gl_pnQtde
				.createSequentialGroup().addGap(27)
				.addGroup(gl_pnQtde.createParallelGroup(Alignment.LEADING).addComponent(lbProdutoQtdeMinima)
						.addComponent(tfProdutoQtdeMinima, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addGap(45)
				.addGroup(
						gl_pnQtde.createParallelGroup(Alignment.LEADING)
								.addComponent(tfProdutoQtdeMaxima, GroupLayout.PREFERRED_SIZE, 78,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbProdutoQtdeMaxima))
				.addGap(41)
				.addGroup(gl_pnQtde.createParallelGroup(Alignment.LEADING).addComponent(lbProdutoQtdeEstoque)
						.addComponent(tfProdutoQtdeEstoque, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(48, Short.MAX_VALUE)));
		gl_pnQtde.setVerticalGroup(gl_pnQtde.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnQtde.createSequentialGroup().addGap(21)
						.addGroup(gl_pnQtde.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnQtde.createSequentialGroup().addComponent(lbProdutoQtdeMinima).addGap(6)
										.addComponent(tfProdutoQtdeMinima, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnQtde.createSequentialGroup()
										.addGroup(gl_pnQtde.createParallelGroup(Alignment.BASELINE)
												.addComponent(lbProdutoQtdeMaxima).addComponent(lbProdutoQtdeEstoque))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_pnQtde.createParallelGroup(Alignment.BASELINE)
												.addComponent(tfProdutoQtdeMaxima, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfProdutoQtdeEstoque, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(42, Short.MAX_VALUE)));
		pnQtde.setLayout(gl_pnQtde);
		pnProdutos.setLayout(Produtos);

		pnClientes = new JPanel();
		pnCentral.add(pnClientes,Paineis.CLIENTES.toString());

		lbClientes = new JLabel("Clientes");
		lbClientes.setFont(new Font("Tahoma", Font.PLAIN, 32));
		GroupLayout gl_pnClientes = new GroupLayout(pnClientes);
		gl_pnClientes.setHorizontalGroup(
			gl_pnClientes.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_pnClientes.createSequentialGroup()
					.addGap(201)
					.addComponent(lbClientes)
					.addContainerGap(213, Short.MAX_VALUE))
		);
		gl_pnClientes.setVerticalGroup(
			gl_pnClientes.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnClientes.createSequentialGroup()
					.addGap(26)
					.addComponent(lbClientes)
					.addContainerGap(284, Short.MAX_VALUE))
		);
		pnClientes.setLayout(gl_pnClientes);

		pnFornecedores = new JPanel();
		pnCentral.add(pnFornecedores,Paineis.FORNECEDORES.toString());

		lbFornecedores = new JLabel("Fornecedores");
		lbFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		lbFornecedorID = new JLabel("C\u00F3digo:");
		
		tfFornecedorID = new JTextField();
		tfFornecedorID.setColumns(10);
		tfFornecedorID.setEnabled(false);
		
		lbFornecedorCNPJ = new JLabel("CNPJ:");
		
		tfFornecedorCNPJ = new JFormattedTextField();
		tfFornecedorCNPJ.setColumns(10);
		
		lbFornecedorNome = new JLabel("Nome:");
		
		tfFornecedorNome = new JTextField();
		tfFornecedorNome.setColumns(10);
		
		lbFornecedorTelefone = new JLabel("Telefone:");
		
		lbFornecedorEmail = new JLabel("Email:");
		
		tfFornecedorEmail = new JTextField();
		tfFornecedorEmail.setColumns(10);
		
		tfFornecedorTelefone = new JFormattedTextField();
		GroupLayout gl_pnFornecedores = new GroupLayout(pnFornecedores);
		gl_pnFornecedores.setHorizontalGroup(
			gl_pnFornecedores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnFornecedores.createSequentialGroup()
					.addContainerGap(52, Short.MAX_VALUE)
					.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnFornecedores.createSequentialGroup()
							.addComponent(lbFornecedores)
							.addGap(152))
						.addGroup(gl_pnFornecedores.createSequentialGroup()
							.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbFornecedorEmail)
								.addComponent(lbFornecedorTelefone)
								.addComponent(lbFornecedorNome)
								.addComponent(lbFornecedorCNPJ)
								.addComponent(lbFornecedorID))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.LEADING, false)
									.addComponent(tfFornecedorEmail)
									.addComponent(tfFornecedorID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(tfFornecedorNome, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
									.addComponent(tfFornecedorCNPJ, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addComponent(tfFornecedorTelefone, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
							.addGap(35))))
		);
		gl_pnFornecedores.setVerticalGroup(
			gl_pnFornecedores.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnFornecedores.createSequentialGroup()
					.addGap(22)
					.addComponent(lbFornecedores)
					.addGap(39)
					.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFornecedorID)
						.addComponent(tfFornecedorID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFornecedorCNPJ)
						.addComponent(tfFornecedorCNPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFornecedorNome)
						.addComponent(tfFornecedorNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFornecedorTelefone)
						.addComponent(tfFornecedorTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnFornecedores.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfFornecedorEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbFornecedorEmail))
					.addContainerGap(77, Short.MAX_VALUE))
		);
		pnFornecedores.setLayout(gl_pnFornecedores);
		
		pnEntradas = new JPanel();
		pnCentral.add(pnEntradas, Paineis.ENTRADAS.toString());
		pnEntradas.setLayout(new BorderLayout(0, 0));
		
		pnEntradaTitulo = new JPanel();
		pnEntradaTitulo.setPreferredSize(new Dimension(10, 40));
		pnEntradas.add(pnEntradaTitulo, BorderLayout.NORTH);
		
		lbEntradas = new JLabel("Entradas");
		lbEntradas.setBounds(164, 1, 133, 39);
		lbEntradas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		lbIncluir = new JLabel("<html><font color=blue>Incluir</font></html>");
		lbIncluir.setHorizontalAlignment(SwingConstants.CENTER);
		lbIncluir.setBounds(347, 20, 57, 18);
		lbIncluir.setPreferredSize(new Dimension(50, 0));
		lbIncluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entradaIncluir();
			}
		});
		lbIncluir.setIcon(new ImageIcon(Tela.class.getResource("/images/btAdiciona.png")));
		lbIncluir.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));

		lbAlterar = new JLabel("<html><font color=green>Alterar</font></html>");
		lbAlterar.setHorizontalAlignment(SwingConstants.CENTER);
		lbAlterar.setBounds(410, 20, 53, 18);
		lbAlterar.setPreferredSize(new Dimension(50, 0));
		lbAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entradaAlterar();
			}
		});
		lbAlterar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lbAlterar.setIcon(new ImageIcon(Tela.class.getResource("/images/btAltera.png")));
		
		lbExcluir = new JLabel("<html><font color=red>Excluir</font></html>");
		lbExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lbExcluir.setBounds(469, 20, 52, 18);
		lbExcluir.setPreferredSize(new Dimension(50, 0));
		lbExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				entradaExcluir();
			}
		});
		lbExcluir.setIcon(new ImageIcon(Tela.class.getResource("/images/btExclui.png")));
		lbExcluir.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		pnEntradaTitulo.setLayout(null);
		pnEntradaTitulo.add(lbEntradas);
		pnEntradaTitulo.add(lbIncluir);
		pnEntradaTitulo.add(lbAlterar);
		pnEntradaTitulo.add(lbExcluir);
		
		pnTabelaEntrada = new JScrollPane();
		pnEntradas.add(pnTabelaEntrada, BorderLayout.CENTER);
		
		tbEntrada = new JTable();
		tbEntrada.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		tbEntrada.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTabelaEntrada.setViewportView(tbEntrada);
		
		pnSaidas = new JPanel();
		pnCentral.add(pnSaidas, Paineis.SAIDAS.toString());
		pnSaidas.setLayout(new BorderLayout(0, 0));
		
		lbSaidas = new JLabel("Sa\u00EDdas");
		lbSaidas.setHorizontalAlignment(SwingConstants.CENTER);
		lbSaidas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		pnSaidas.add(lbSaidas, BorderLayout.NORTH);
		
		pnKardex = new JPanel();
		pnCentral.add(pnKardex, Paineis.MOVIMENTACAO.toString());
		pnKardex.setLayout(new BorderLayout(0, 0));
		
		pnKardexTitulo = new JPanel();
		pnKardexTitulo.setLayout(null);
		pnKardexTitulo.setPreferredSize(new Dimension(10, 40));
		pnKardex.add(pnKardexTitulo, BorderLayout.NORTH);
		
		lbKardex = new JLabel("Ficha de Kardex");
		lbKardex.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lbKardex.setBounds(10, 0, 237, 39);
		pnKardexTitulo.add(lbKardex);
		
		lbKardexProduto = new JLabel("Produto");
		lbKardexProduto.setBounds(253, 2, 46, 14);
		pnKardexTitulo.add(lbKardexProduto);
		
		cbKardexProduto = new JComboBox();
		cbKardexProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaTabelaKardex();
			}
		});
		cbKardexProduto.setModel(new DefaultComboBoxModel(new String[] {"listagem de produto do estoque"}));
		cbKardexProduto.setBounds(253, 15, 257, 22);
		pnKardexTitulo.add(cbKardexProduto);
		
		pnTabelaKardex = new JScrollPane();
		pnKardex.add(pnTabelaKardex, BorderLayout.CENTER);
		
		tbKardex = new JTable();
		tbKardex.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		tbKardex.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnTabelaKardex.setViewportView(tbKardex);
	}

	/*
	 * Inclua métodos somente após este comentário Pendências: - unificar selector
	 * - bloquear acesso ao código e qtdeEstoque
	 * 
	 */

	private void listaFornecedor() {
		for (Fornecedor f: Fornecedor.getLista()) {
			System.out.println(f);
		}
	}
	
	private void listaProduto() {
		/*
		 * lista produto na console
		 * 		for (Produto p : Produto.getLista()) {
		 * 			System.out.println(p);
		 * 		}
		 */
		new TelaListagem(Paineis.PRODUTOS).setVisible(true);
	}

	private void limpaTelaFornecedor() {
		tfFornecedorID.setText("");
		tfFornecedorCNPJ.setText("");
		tfFornecedorNome.setText("");
		tfFornecedorTelefone.setText("");
		tfFornecedorEmail.setText("");
		tfFornecedorCNPJ.requestFocus();
	}
	
	private void limpaTelaProduto() {
		tfProdutoID.setText("");
		tfProdutoNome.setText("");
		tfProdutoLocalizacao.setText("");
		tfProdutoQtdeMaxima.setText("");
		tfProdutoQtdeMinima.setText("");
		tfProdutoQtdeEstoque.setText("");
		tfProdutoNome.requestFocus();
	}

	private void gravaFornecedor() {
		int id = Converter.toInt(tfFornecedorID.getText());
		String cnpj = tfFornecedorCNPJ.getText();
		String nome = tfFornecedorNome.getText();
		String telefone = tfFornecedorTelefone.getText();
		String email = tfFornecedorEmail.getText();
		new Fornecedor(cnpj,nome,telefone,email);
		limpaTelaFornecedor();
	}
	
	private void gravaProduto() {
		int id = Converter.toInt(tfProdutoID.getText());
		String nome = tfProdutoNome.getText();
		String localizacao = tfProdutoLocalizacao.getText();
		int qtdeMaxima = Integer.parseInt(tfProdutoQtdeMaxima.getText());
		int qtdeMinima = Integer.parseInt(tfProdutoQtdeMinima.getText());
		int qtdeEstoque = Integer.parseInt(tfProdutoQtdeEstoque.getText());
		Produto p = new Produto(id, nome, localizacao, qtdeMaxima, qtdeMinima, qtdeEstoque);
		//Principal.produtos.add(p);
		limpaTelaProduto();
	}

	private void setPainel(Paineis pn) {
		CardLayout cl = (CardLayout) pnCentral.getLayout();
		cl.show(pnCentral,pn.toString());
		painel = pn;
		if (painel == Paineis.ENTRADAS) {
			atualizaTabelaEntradas();
		} else if (painel == Paineis.MOVIMENTACAO) {
			atualizaTabelaKardex();
		}
	}
	
	private void setComboboxKardexProduto() {
		produtos =  Produto.getLista();
		cbKardexProduto.removeAllItems();
		for (Produto p: produtos) {
			cbKardexProduto.addItem(p.getNome());
		}
		cbKardexProduto.setSelectedIndex(0);
	}

	private void atualizaTabelaKardex() {
		if (produtos.size() == 0) setComboboxKardexProduto();
		int idx = cbKardexProduto.getSelectedIndex();
		if (idx >= 0) {
			Produto p = produtos.get(idx);
			tbKardex.setModel(Kardex.getTableModel(p));
			configuraTabelaKardex();
		}
	}
	
	private void configuraTabelaKardex() {
		tbKardex.setDefaultRenderer(Object.class,new LinhasZebradasRenderer());		
		DefaultTableCellRenderer centro = new LinhasZebradasRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer direita = new LinhasZebradasRenderer();
		direita.setHorizontalAlignment(SwingConstants.RIGHT);

		tbKardex.getTableHeader().setDefaultRenderer(centro);
		tbKardex.getColumnModel().getColumn(0).setCellRenderer(centro);
		tbKardex.getColumnModel().getColumn(1).setCellRenderer(centro);
		tbKardex.getColumnModel().getColumn(4).setCellRenderer(direita);
		tbKardex.getColumnModel().getColumn(5).setCellRenderer(direita);
		
		tbKardex.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(40);
		tbKardex.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(90);
		tbKardex.getTableHeader().getColumnModel().getColumn(2).setMinWidth(120);
		tbKardex.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(60);
		tbKardex.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(50);
		tbKardex.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(60);
		
	}
	
	private void atualizaTabelaEntradas() {
		tbEntrada.setModel(Entrada.getTableModel());

		DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
		centro.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer direita = new DefaultTableCellRenderer();
		direita.setHorizontalAlignment(SwingConstants.RIGHT);

		tbEntrada.getTableHeader().setDefaultRenderer(centro);
		tbEntrada.getColumnModel().getColumn(0).setCellRenderer(centro);
		tbEntrada.getColumnModel().getColumn(3).setCellRenderer(centro);
		tbEntrada.getColumnModel().getColumn(5).setCellRenderer(direita);
		tbEntrada.getColumnModel().getColumn(6).setCellRenderer(direita);

		tbEntrada.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(30);
		tbEntrada.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(70);
		tbEntrada.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(60);
		tbEntrada.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(40);
		tbEntrada.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(50);
	}
	
	private void setLookAndFeel() {
		String laf = (String) cbTema.getSelectedItem();
		Configura.lookAndFeel(laf);
		SwingUtilities.updateComponentTreeUI(this);
		this.repaint();
	}

	private void setTemas() {
		// limpar o combobox de temas
		cbTema.removeAllItems();
		// pegar os look and feel disponíveis no sistema operacional
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			// preencher o combobox com os look and feel disponíveis
			cbTema.addItem(info.getName());
		}
		// ajusta Look and Feel Windows como padrão
		cbTema.setSelectedItem("Windows");
	}
	
	private void setMascaras() {
		tfFornecedorCNPJ.setFormatterFactory(
				new DefaultFormatterFactory(
				Mascara.cnpj()));
		tfFornecedorTelefone.setFormatterFactory(
				new DefaultFormatterFactory(
				Mascara.telefone()));
	}
	
	private Entrada getEntrada() {
		Entrada e = null;
		int linha = tbEntrada.getSelectedRow();
		int id = Converter.toInt(tbEntrada.getModel().getValueAt(linha,0).toString());
		e = Entrada.getEntrada(id);
		return e;
	}
	
	private void entradaIncluir() {
		new TelaEntradas().setVisible(true);
	}
	
	private void entradaAlterar() {
		Entrada e = getEntrada();
		new TelaEntradas(e).setVisible(true);
	}
	
	private void entradaExcluir() {
		int resp = JOptionPane.showConfirmDialog(null, "Confirma exclusão do item?", "Exclusão de Entrada", JOptionPane.YES_NO_OPTION);
		if (resp == JOptionPane.YES_OPTION) {
			Entrada e = getEntrada();
			e.delete();
			atualizaTabelaEntradas();
		}
	}
}