package aula22;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class TelaMascara extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMascara frame = new TelaMascara();
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
	public TelaMascara() {
		
		//tfCelular.setFormatterFactory( new DefaultFormatterFactory(Mascara.celular()));
		//segunda forma de se fazer o mask....
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lbData = new JLabel("Data:\r\n");
		
		sl_panel.putConstraint(SpringLayout.NORTH, lbData, 85, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lbData, 81, SpringLayout.WEST, panel);
		panel.add(lbData);
		
		JLabel lbCelular = new JLabel("Celular:\r\n");
		
		sl_panel.putConstraint(SpringLayout.NORTH, lbCelular, 53, SpringLayout.SOUTH, lbData);
		sl_panel.putConstraint(SpringLayout.WEST, lbCelular, 0, SpringLayout.WEST, lbData);
		panel.add(lbCelular);
		
		JLabel lbCEP = new JLabel("CEP:\r\n");
		sl_panel.putConstraint(SpringLayout.NORTH, lbCEP, 50, SpringLayout.SOUTH, lbCelular);
		sl_panel.putConstraint(SpringLayout.WEST, lbCEP, 0, SpringLayout.WEST, lbData);
		panel.add(lbCEP);
		
		JFormattedTextField tfData = new JFormattedTextField(Mascara.data());
		
		sl_panel.putConstraint(SpringLayout.NORTH, tfData, -3, SpringLayout.NORTH, lbData);
		sl_panel.putConstraint(SpringLayout.WEST, tfData, 47, SpringLayout.EAST, lbData);
		panel.add(tfData);
		
		JFormattedTextField tfCelular = new JFormattedTextField(Mascara.celular());
		
		sl_panel.putConstraint(SpringLayout.WEST, tfCelular, 37, SpringLayout.EAST, lbCelular);
		sl_panel.putConstraint(SpringLayout.EAST, tfCelular, -325, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, tfData, 0, SpringLayout.EAST, tfCelular);
		sl_panel.putConstraint(SpringLayout.NORTH, tfCelular, -3, SpringLayout.NORTH, lbCelular);
		panel.add(tfCelular);
		
		JFormattedTextField tfCPF = new JFormattedTextField();
		
		sl_panel.putConstraint(SpringLayout.NORTH, tfCPF, 44, SpringLayout.SOUTH, tfCelular);
		sl_panel.putConstraint(SpringLayout.WEST, tfCPF, 47, SpringLayout.EAST, lbCEP);
		sl_panel.putConstraint(SpringLayout.EAST, tfCPF, -385, SpringLayout.EAST, panel);
		panel.add(tfCPF);
		
		JLabel lbTitulo = new JLabel("M\u00E1scara de Formata\u00E7\u00E3o");
		sl_panel.putConstraint(SpringLayout.NORTH, lbTitulo, 22, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lbTitulo, 179, SpringLayout.WEST, panel);
		lbTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lbTitulo);
	}
}
