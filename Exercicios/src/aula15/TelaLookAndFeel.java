package aula15;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class TelaLookAndFeel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtTextfield;
	private JButton btAlterar;
	private JRadioButton rdbtnRadioButton;
	private JCheckBox chckbxCheckBox;
	private JSpinner spinner;
	private JProgressBar progressBar;
	private JSlider slider;
	private JScrollBar scrollBar;
	private JPanel panel_1;
	private JPanel panel_2;
	private JComboBox cbLAF;
	private JLabel lblLookAndFeel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLookAndFeel frame = new TelaLookAndFeel();
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
	public TelaLookAndFeel() {
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		lblNewLabel = new JLabel("Isto é um label:");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 62, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 30, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);
		
		txtTextfield = new JTextField();
		txtTextfield.setText("TextField");
		sl_panel.putConstraint(SpringLayout.WEST, txtTextfield, 10, SpringLayout.EAST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, txtTextfield, 159, SpringLayout.EAST, lblNewLabel);
		panel.add(txtTextfield);
		txtTextfield.setColumns(10);
		
		btAlterar = new JButton("Altera L&F");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLookAndFeel();
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btAlterar, 26, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, btAlterar, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(btAlterar);
		
		rdbtnRadioButton = new JRadioButton("Radio Button");
		sl_panel.putConstraint(SpringLayout.SOUTH, txtTextfield, -20, SpringLayout.NORTH, rdbtnRadioButton);
		sl_panel.putConstraint(SpringLayout.WEST, rdbtnRadioButton, 39, SpringLayout.EAST, btAlterar);
		sl_panel.putConstraint(SpringLayout.NORTH, rdbtnRadioButton, 0, SpringLayout.NORTH, btAlterar);
		panel.add(rdbtnRadioButton);
		
		chckbxCheckBox = new JCheckBox("Check Box");
		sl_panel.putConstraint(SpringLayout.NORTH, chckbxCheckBox, 1, SpringLayout.NORTH, btAlterar);
		sl_panel.putConstraint(SpringLayout.WEST, chckbxCheckBox, 37, SpringLayout.EAST, rdbtnRadioButton);
		panel.add(chckbxCheckBox);
		
		spinner = new JSpinner();
		sl_panel.putConstraint(SpringLayout.NORTH, spinner, 0, SpringLayout.NORTH, txtTextfield);
		sl_panel.putConstraint(SpringLayout.WEST, spinner, 19, SpringLayout.EAST, txtTextfield);
		sl_panel.putConstraint(SpringLayout.EAST, spinner, -91, SpringLayout.EAST, panel);
		panel.add(spinner);
		
		progressBar = new JProgressBar();
		progressBar.setValue(50);
		sl_panel.putConstraint(SpringLayout.NORTH, progressBar, 30, SpringLayout.SOUTH, btAlterar);
		sl_panel.putConstraint(SpringLayout.WEST, progressBar, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, progressBar, -256, SpringLayout.EAST, panel);
		panel.add(progressBar);
		
		slider = new JSlider();
		sl_panel.putConstraint(SpringLayout.NORTH, slider, 0, SpringLayout.NORTH, progressBar);
		sl_panel.putConstraint(SpringLayout.EAST, slider, -27, SpringLayout.EAST, panel);
		panel.add(slider);
		
		scrollBar = new JScrollBar();
		sl_panel.putConstraint(SpringLayout.NORTH, scrollBar, 0, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, scrollBar, 123, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, scrollBar, -31, SpringLayout.EAST, panel);
		panel.add(scrollBar);
		
		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 63, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -21, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 31, SpringLayout.EAST, btAlterar);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		
		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 31, SpringLayout.SOUTH, slider);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 99, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -19, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -31, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel_2);
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3), "Isto \u00E9 um Panel", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		cbLAF = new JComboBox();
		cbLAF.setModel(new DefaultComboBoxModel(new String[] {"Metal", "Nimbus", "CDE/Motif", "GTK+"}));
		sl_panel.putConstraint(SpringLayout.NORTH, cbLAF, 16, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, cbLAF, 447, SpringLayout.WEST, panel);
		panel.add(cbLAF);
		
		lblLookAndFeel = new JLabel("Look And Feel:");
		sl_panel.putConstraint(SpringLayout.WEST, cbLAF, 17, SpringLayout.EAST, lblLookAndFeel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblLookAndFeel, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblLookAndFeel, 0, SpringLayout.WEST, lblNewLabel);
		panel.add(lblLookAndFeel);
	}
	
	private void setLookAndFeel() {
		String laf = (String) cbLAF.getSelectedItem();
		try {
			for (LookAndFeelInfo info: UIManager.getInstalledLookAndFeels() ) {
				if (laf.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					SwingUtilities.updateComponentTreeUI(this);
					this.repaint();
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException |
				 IllegalAccessException | UnsupportedLookAndFeelException e) {
						e.printStackTrace();
		}
	}
	
}