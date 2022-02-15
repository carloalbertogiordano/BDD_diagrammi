package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GestioneMostre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneMostre frame = new GestioneMostre();
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
	public GestioneMostre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 288, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMostra = new JLabel("Mostra");
		lblMostra.setBounds(12, 12, 76, 15);
		contentPane.add(lblMostra);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(126, 7, 106, 24);
		contentPane.add(comboBox);
		
		JLabel lblOpera = new JLabel("Opera");
		lblOpera.setBounds(12, 64, 70, 15);
		contentPane.add(lblOpera);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(126, 59, 106, 24);
		contentPane.add(comboBox_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(12, 329, 117, 25);
		contentPane.add(btnAnnulla);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setBounds(159, 318, 117, 25);
		contentPane.add(btnAggiungi);
		
		textField = new JTextField();
		textField.setBounds(126, 95, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		lblDataInizio.setBounds(12, 102, 85, 15);
		contentPane.add(lblDataInizio);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		lblDataFine.setBounds(12, 139, 70, 15);
		contentPane.add(lblDataFine);
		
		JLabel lblOrainizio = new JLabel("Ora Inizio");
		lblOrainizio.setBounds(12, 184, 70, 15);
		contentPane.add(lblOrainizio);
		
		JLabel lblOraFine = new JLabel("Ora Fine");
		lblOraFine.setBounds(18, 230, 70, 15);
		contentPane.add(lblOraFine);
	}
}
