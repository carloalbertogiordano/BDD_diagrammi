package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class NuovoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private static QueryMaker qm = SelezioneMuseo.getQm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuovoCliente frame = new NuovoCliente(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param  
	 */
	public NuovoCliente(String codMuseo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(68, 10, 142, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(12, 56, 92, 15);
		contentPane.add(lblCognome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(94, 54, 147, 19);
		contentPane.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita:");
		lblDataDiNascita.setBounds(12, 101, 124, 15);
		contentPane.add(lblDataDiNascita);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Elimina la finestra corrente e richiama la precedente
					dispose();
					new GestioneVisita(codMuseo).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnAnnulla.setBounds(248, 221, 117, 25);
		contentPane.add(btnAnnulla);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(143, 97, 167, 19);
		contentPane.add(dateChooser);
		SimpleDateFormat x = new SimpleDateFormat("Y-MM-dd");
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			//Inserisce nel database il nuovo cliente
			public void actionPerformed(ActionEvent arg0) {
				//Formatta come necessario a sql
				String nome = textFieldNome.getText();
				String cognome = textFieldCognome.getText();
				String ddn = x.format(dateChooser.getDate());
				
				try {
					qm.makeInsertion("INSERT INTO Clienti (nome, cognome, ddnascita) VALUES (\""+nome+"\", \""+cognome+"\", '"+ddn+"');");
					JOptionPane.showMessageDialog(btnOk, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(btnOk, "Errore nell inserimento", "Error!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnOk.setBounds(94, 221, 117, 25);
		contentPane.add(btnOk);
	}
}
