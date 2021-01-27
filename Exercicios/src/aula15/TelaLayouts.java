package aula15;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class TelaLayouts extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnBotoNoTopo;
	private JButton btnBotoEsquerda;
	private JButton btnBotoRodap;
	private JButton btnBotoDireita;
	private JButton btnBotoCentral;
	private JButton btnBoto;
	private JButton btnBoto_1;
	private JButton btnBoto_2;
	private JButton btnBoto_3;
	private JButton btnBoto_4;
	private JButton btnBoto_5;
	private JButton btnBoto_6;
	private JButton btnBoto_7;
	private JTextField txtTextfield;
	private JButton btnBoto_8;
	private JTextField txtTextfield_1;
	private JButton btnBoto_9;
	private JLabel lblLabel;
	private JButton btnBoto_10;
	private JButton btnBoto_11;
	private JButton btnBoto_12;
	private JTextField txtEsteTextfieldDeve;
	private JButton btnNewButton;
	private JRadioButton rdbtnNewRadioButton;
	private JButton btnNewButton_1;
	private JTextField txtAsgafgasdfasddfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs;
	private JLabel lblNewLabel;
	private JCheckBox chckbxNewCheckBox;
	private JComboBox comboBox;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnBoto_13;
	private JButton btnBoto_14;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JRadioButton rdbtnNewRadioButton_3;
	private JLabel lblLabel_1;
	private JTextField txtTextfield_2;
	private JButton btnNewButton_7;
	private JLabel lblSenha;
	private JTextField txtDigiteSuaSenha;
	private JButton btnNewButton_8;
	private JPanel panel_6;
	private JLabel lblLabel_2;
	private JTextField textField;
	private JLabel lblSenha_1;
	private JTextField textField_1;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLayouts frame = new TelaLayouts();
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
	public TelaLayouts() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		tabbedPane.addTab("BorderLayout", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		btnBotoNoTopo = new JButton("Botão no Topo");
		panel.add(btnBotoNoTopo, BorderLayout.NORTH);
		
		btnBotoEsquerda = new JButton("Botão Esquerda");
		panel.add(btnBotoEsquerda, BorderLayout.WEST);
		
		btnBotoRodap = new JButton("Botão Rodapé");
		panel.add(btnBotoRodap, BorderLayout.SOUTH);
		
		btnBotoDireita = new JButton("Botão Direita");
		panel.add(btnBotoDireita, BorderLayout.EAST);
		
		btnBotoCentral = new JButton("Botão Central");
		panel.add(btnBotoCentral, BorderLayout.CENTER);
		
		panel_5 = new JPanel();
		tabbedPane.addTab("GroupLayout", null, panel_5, null);
		
		lblLabel_1 = new JLabel("Login:");
		
		txtTextfield_2 = new JTextField();
		txtTextfield_2.setText("Digite seu login");
		txtTextfield_2.setColumns(10);
		
		btnNewButton_7 = new JButton("Cancelar");
		
		lblSenha = new JLabel("Senha:");
		
		txtDigiteSuaSenha = new JTextField();
		txtDigiteSuaSenha.setText("Digite sua senha");
		txtDigiteSuaSenha.setColumns(10);
		
		btnNewButton_8 = new JButton("Acessar");
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(113)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLabel_1)
						.addComponent(lblSenha))
					.addGap(18)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_5.createSequentialGroup()
							.addComponent(btnNewButton_7)
							.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
							.addComponent(btnNewButton_8))
						.addComponent(txtTextfield_2, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
						.addComponent(txtDigiteSuaSenha, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
					.addGap(216))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(96)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLabel_1)
						.addComponent(txtTextfield_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDigiteSuaSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addGap(42)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_8)
						.addComponent(btnNewButton_7))
					.addContainerGap(102, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("GridLayout", null, panel_1, null);
		panel_1.setLayout(new GridLayout(3, 5, 50, 10));
		
		btnBoto = new JButton("Botão 1");
		panel_1.add(btnBoto);
		
		btnBoto_3 = new JButton("Botão 4");
		panel_1.add(btnBoto_3);
		
		btnBoto_1 = new JButton("Botão 2");
		panel_1.add(btnBoto_1);
		
		btnBoto_2 = new JButton("Botão 3");
		panel_1.add(btnBoto_2);
		
		btnBoto_4 = new JButton("Botão 5");
		panel_1.add(btnBoto_4);
		
		btnBoto_5 = new JButton("Botão 6");
		panel_1.add(btnBoto_5);
		
		btnBoto_6 = new JButton("Botão 7");
		panel_1.add(btnBoto_6);
		
		btnBoto_7 = new JButton("Botão 8");
		panel_1.add(btnBoto_7);
		
		txtTextfield = new JTextField();
		txtTextfield.setText("TextField 1");
		panel_1.add(txtTextfield);
		txtTextfield.setColumns(10);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("BoxLayout", null, panel_2, null);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		btnBoto_8 = new JButton("Botão 1");
		panel_2.add(btnBoto_8);
		
		txtTextfield_1 = new JTextField();
		txtTextfield_1.setText("TextField 1");
		panel_2.add(txtTextfield_1);
		txtTextfield_1.setColumns(10);
		
		btnBoto_9 = new JButton("Botão 2");
		panel_2.add(btnBoto_9);
		
		lblLabel = new JLabel("Label 1");
		panel_2.add(lblLabel);
		
		btnBoto_10 = new JButton("Botão 3");
		panel_2.add(btnBoto_10);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("FlowLayout", null, panel_3, null);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnBoto_11 = new JButton("Botão 1");
		panel_3.add(btnBoto_11);
		
		btnBoto_12 = new JButton("Botão 2");
		panel_3.add(btnBoto_12);
		
		txtEsteTextfieldDeve = new JTextField();
		txtEsteTextfieldDeve.setText("Este TextField deve ficar em um tamanho grande.");
		txtEsteTextfieldDeve.setPreferredSize(new Dimension(100, 27));
		panel_3.add(txtEsteTextfieldDeve);
		txtEsteTextfieldDeve.setColumns(10);
		
		btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel_3.add(rdbtnNewRadioButton);
		
		btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1);
		
		txtAsgafgasdfasddfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs = new JTextField();
		txtAsgafgasdfasddfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs.setText("asgafgasdfasddfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs");
		panel_3.add(txtAsgafgasdfasddfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs);
		txtAsgafgasdfasddfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfadfs.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel);
		
		chckbxNewCheckBox = new JCheckBox("New check box");
		panel_3.add(chckbxNewCheckBox);
		
		comboBox = new JComboBox();
		panel_3.add(comboBox);
		
		btnNewButton_2 = new JButton("New button");
		panel_3.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("New button");
		panel_3.add(btnNewButton_4);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("FormLayout", null, panel_4, null);
		
		btnBoto_13 = new JButton("Botão 1");
		panel_4.add(btnBoto_13);
		
		btnBoto_14 = new JButton("Botão 2");
		panel_4.add(btnBoto_14);
		
		rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel_4.add(rdbtnNewRadioButton_1);
		
		rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		panel_4.add(rdbtnNewRadioButton_2);
		
		btnNewButton_5 = new JButton("New button");
		panel_4.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("New button");
		panel_4.add(btnNewButton_6);
		
		rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		panel_4.add(rdbtnNewRadioButton_3);
		
		panel_6 = new JPanel();
		tabbedPane.addTab("SpringLayout", null, panel_6, null);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		lblLabel_2 = new JLabel("Login:");
		panel_6.add(lblLabel_2);
		
		textField = new JTextField();
		sl_panel_6.putConstraint(SpringLayout.EAST, lblLabel_2, -19, SpringLayout.WEST, textField);
		sl_panel_6.putConstraint(SpringLayout.WEST, textField, 200, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, textField, -186, SpringLayout.EAST, panel_6);
		textField.setText("Digite seu login");
		textField.setColumns(10);
		panel_6.add(textField);
		
		lblSenha_1 = new JLabel("Senha:");
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblSenha_1, 160, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblLabel_2, -37, SpringLayout.NORTH, lblSenha_1);
		sl_panel_6.putConstraint(SpringLayout.EAST, lblSenha_1, 0, SpringLayout.EAST, lblLabel_2);
		panel_6.add(lblSenha_1);
		
		textField_1 = new JTextField();
		sl_panel_6.putConstraint(SpringLayout.SOUTH, textField, -25, SpringLayout.NORTH, textField_1);
		sl_panel_6.putConstraint(SpringLayout.NORTH, textField_1, 154, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		sl_panel_6.putConstraint(SpringLayout.EAST, textField_1, -186, SpringLayout.EAST, panel_6);
		textField_1.setText("Digite sua senha");
		textField_1.setColumns(10);
		panel_6.add(textField_1);
		
		btnNewButton_9 = new JButton("Cancelar");
		panel_6.add(btnNewButton_9);
		
		btnNewButton_10 = new JButton("Acessar");
		sl_panel_6.putConstraint(SpringLayout.NORTH, btnNewButton_10, 212, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, btnNewButton_10, -378, SpringLayout.EAST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.NORTH, btnNewButton_9, 0, SpringLayout.NORTH, btnNewButton_10);
		sl_panel_6.putConstraint(SpringLayout.WEST, btnNewButton_9, 64, SpringLayout.EAST, btnNewButton_10);
		panel_6.add(btnNewButton_10);
	}
}