package aula13;


	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.SpringLayout;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.EtchedBorder;

	/*
	 * criar uma segunda textfield para digitação no email
	 * e listar o nome e email digitados
	 */
	public class Tela extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JTextField tfEmail;

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
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 559, 362);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			JPanel painelTopo = new JPanel();
			painelTopo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			painelTopo.setBackground(new Color(51, 102, 255));
			contentPane.add(painelTopo, BorderLayout.NORTH);
			
			JLabel lblTtuloDaAplicao = new JLabel("Título da Aplicação");
			lblTtuloDaAplicao.setForeground(new Color(255, 255, 255));
			lblTtuloDaAplicao.setFont(new Font("Manjari", Font.PLAIN, 32));
			painelTopo.add(lblTtuloDaAplicao);
			
			JPanel painelCentral = new JPanel();
			painelCentral.setBackground(new Color(255, 204, 0));
			contentPane.add(painelCentral, BorderLayout.CENTER);
			SpringLayout sl_painelCentral = new SpringLayout();
			painelCentral.setLayout(sl_painelCentral);
			
			JLabel lblNome = new JLabel("Nome:");
			sl_painelCentral.putConstraint(SpringLayout.NORTH, lblNome, 94, SpringLayout.NORTH, painelCentral);
			sl_painelCentral.putConstraint(SpringLayout.WEST, lblNome, 38, SpringLayout.WEST, painelCentral);
			painelCentral.add(lblNome);
			
			textField = new JTextField();
			sl_painelCentral.putConstraint(SpringLayout.NORTH, textField, 90, SpringLayout.NORTH, painelCentral);
			sl_painelCentral.putConstraint(SpringLayout.WEST, textField, 18, SpringLayout.EAST, lblNome);
			sl_painelCentral.putConstraint(SpringLayout.EAST, textField, 283, SpringLayout.EAST, lblNome);
			painelCentral.add(textField);
			textField.setColumns(10);
			
			JButton btnCliqueaqui = new JButton("CliqueAqui");
			sl_painelCentral.putConstraint(SpringLayout.SOUTH, btnCliqueaqui, -58, SpringLayout.SOUTH, painelCentral);
			sl_painelCentral.putConstraint(SpringLayout.EAST, btnCliqueaqui, -110, SpringLayout.EAST, painelCentral);
			btnCliqueaqui.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listaNome();
				}
			});
			painelCentral.add(btnCliqueaqui);
			
			JLabel lblEmail = new JLabel("Email:");
			sl_painelCentral.putConstraint(SpringLayout.NORTH, lblEmail, 40, SpringLayout.SOUTH, lblNome);
			sl_painelCentral.putConstraint(SpringLayout.EAST, lblEmail, 0, SpringLayout.EAST, lblNome);
			painelCentral.add(lblEmail);
			
			tfEmail = new JTextField();
			sl_painelCentral.putConstraint(SpringLayout.NORTH, tfEmail, -2, SpringLayout.NORTH, lblEmail);
			sl_painelCentral.putConstraint(SpringLayout.WEST, tfEmail, 18, SpringLayout.EAST, lblNome);
			sl_painelCentral.putConstraint(SpringLayout.EAST, tfEmail, 0, SpringLayout.EAST, textField);
			painelCentral.add(tfEmail);
			tfEmail.setColumns(10);		
		}
		
		private void listaNome() {
			String nome = textField.getText();
			String email = tfEmail.getText();
			System.out.println(nome + "\t" + email);
		}
	}


