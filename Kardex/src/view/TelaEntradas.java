package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import model.Entrada;
import model.Fornecedor;
import model.Produto;
import util.Converter;
import util.Mascara;
public class TelaEntradas extends JFrame {

	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbLogo;
	private JLabel lblEntradas;
	private JPanel pnCentral;
	private JLabel lbProduto;
	private JComboBox cbProduto;
	private JLabel lbFornecedor;
	private JComboBox cbFornecedor;
	private JLabel lbData;
	private JLabel lbDoc;
	private JTextField tfDoc;
	private JLabel lbQtde;
	private JTextField tfQtde;
	private JLabel lbValor;
	private JTextField tfValor;
	private JFormattedTextField tfData;
	private JButton btGravar;
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Fornecedor> fornecedores = new ArrayList<>();
	private Entrada reg = null;
	

	/**
	 * Create the frame.
	 */
	public TelaEntradas() {
		this(null);
	}
	public TelaEntradas(Entrada e) {
		initComponents();
		setCombobox();
		if (e != null) { // alteração
			reg = e;
			preencheDados();
		} else {         // inclusão
			reg = null;
			limpaTela();
		}
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		pnTitulo = new JPanel();
		pnTitulo.setLayout(null);
		pnTitulo.setPreferredSize(new Dimension(10, 70));
		pnTitulo.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnTitulo.setBackground(SystemColor.activeCaption);
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		
		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(TelaEntradas.class.getResource("/images/Logo3.png")));
		lbLogo.setBounds(10, 11, 64, 59);
		pnTitulo.add(lbLogo);
		
		lblEntradas = new JLabel("Entradas");
		lblEntradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntradas.setForeground(Color.WHITE);
		lblEntradas.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblEntradas.setBounds(21, 11, 441, 39);
		pnTitulo.add(lblEntradas);
		
		pnCentral = new JPanel();
		contentPane.add(pnCentral, BorderLayout.CENTER);
		
		lbProduto = new JLabel("Produto:");
		
		cbProduto = new JComboBox();
		
		lbFornecedor = new JLabel("Fornecedor:");
		
		cbFornecedor = new JComboBox();
		
		lbData = new JLabel("Data:");
		
		lbDoc = new JLabel("Docto:");
		
		tfDoc = new JTextField();
		tfDoc.setColumns(10);
		
		lbQtde = new JLabel("Quantidade:");
		
		tfQtde = new JTextField();
		tfQtde.setColumns(10);
		
		lbValor = new JLabel("Valor:");
		
		tfValor = new JTextField();
		tfValor.setColumns(10);
		
		tfData = new JFormattedTextField(Mascara.data());
		
		btGravar = new JButton("Gravar");
		btGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravaEntrada();
			}
		});
		GroupLayout gl_pnCentral = new GroupLayout(pnCentral);
		gl_pnCentral.setHorizontalGroup(
			gl_pnCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnCentral.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_pnCentral.createParallelGroup(Alignment.TRAILING)
						.addComponent(btGravar)
						.addGroup(gl_pnCentral.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_pnCentral.createSequentialGroup()
								.addGap(42)
								.addComponent(lbProduto)
								.addGap(18)
								.addComponent(cbProduto, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_pnCentral.createSequentialGroup()
								.addGap(26)
								.addGroup(gl_pnCentral.createParallelGroup(Alignment.TRAILING)
									.addComponent(lbFornecedor)
									.addComponent(lbData)
									.addComponent(lbQtde))
								.addGap(18)
								.addGroup(gl_pnCentral.createParallelGroup(Alignment.LEADING)
									.addComponent(cbFornecedor, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_pnCentral.createSequentialGroup()
										.addGroup(gl_pnCentral.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(gl_pnCentral.createSequentialGroup()
												.addComponent(tfQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lbValor))
											.addGroup(Alignment.LEADING, gl_pnCentral.createSequentialGroup()
												.addComponent(tfData, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
												.addGap(47)
												.addComponent(lbDoc)))
										.addGap(18)
										.addGroup(gl_pnCentral.createParallelGroup(Alignment.LEADING, false)
											.addComponent(tfValor)
											.addComponent(tfDoc, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_pnCentral.setVerticalGroup(
			gl_pnCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnCentral.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_pnCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbProduto)
						.addComponent(cbProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbFornecedor)
						.addComponent(cbFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbData)
						.addComponent(tfData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbDoc)
						.addComponent(tfDoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_pnCentral.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbQtde)
						.addComponent(tfQtde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbValor)
						.addComponent(tfValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btGravar)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		pnCentral.setLayout(gl_pnCentral);
	}
	
	private void setCombobox() {
		produtos =  Produto.getLista();
		cbProduto.removeAllItems();
		for (Produto p: produtos) {
			cbProduto.addItem(p.getId() + ":  " + p.getNome());
		}
		fornecedores = Fornecedor.getLista();
		cbFornecedor.removeAllItems();
		for (Fornecedor f: fornecedores) {
			cbFornecedor.addItem(f.getNome());
		}
	}

	private void gravaEntrada() {
		Produto p = produtos.get(cbProduto.getSelectedIndex());
		Fornecedor f = fornecedores.get(cbFornecedor.getSelectedIndex());
		Date data = (Date) Converter.str2date(tfData.getText());
		String doc = tfDoc.getText();
		int qtde = Converter.toInt(tfQtde.getText());
		double valor = Double.parseDouble(tfValor.getText());
		if (reg == null) {  // inclusão
			new Entrada(p,f,data,doc,qtde,valor);
		} else {    // alteração
			reg.setProduto(p);
			reg.setFornecedor(f);
			reg.setData(data);
			reg.setDoc(doc);
			reg.setQtde(qtde);
			reg.setValor(valor);
			reg.update();
		}
		limpaTela();
	}
	
	private void limpaTela() {
		tfData.setText("");
		tfDoc.setText("");
		tfQtde.setText("");
		tfValor.setText("");
		cbProduto.requestFocus();
	}

	private void preencheDados() {
		cbProduto.setSelectedItem(reg.getProduto().getNome());
		cbFornecedor.setSelectedItem(reg.getFornecedor().getNome());
		tfData.setText(Converter.date2dmy(reg.getData()));
		tfDoc.setText(reg.getDoc());
		tfQtde.setText(String.valueOf(reg.getQtde()));
		tfValor.setText(String.valueOf(reg.getValor()));
		cbProduto.requestFocus();
	}
}