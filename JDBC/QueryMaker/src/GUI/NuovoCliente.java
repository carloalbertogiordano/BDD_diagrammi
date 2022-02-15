package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NuovoCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldDdn;
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
		setBounds(100, 100, 156, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 70, 15);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(22, 30, 114, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome:");
		lblCognome.setBounds(12, 56, 92, 15);
		contentPane.add(lblCognome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(22, 76, 114, 19);
		contentPane.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		JLabel lblDataDiNascita = new JLabel("Data di nascita:");
		lblDataDiNascita.setBounds(12, 101, 124, 15);
		contentPane.add(lblDataDiNascita);
		
		textFieldDdn = new JTextField();
		textFieldDdn.setBounds(22, 124, 114, 19);
		contentPane.add(textFieldDdn);
		textFieldDdn.setColumns(10);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dispose();
					new GestioneVisita(codMuseo).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnAnnulla.setBounds(12, 167, 117, 25);
		contentPane.add(btnAnnulla);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome = textFieldNome.getText();
				String cognome = textFieldCognome.getText();
				String ddn = textFieldDdn.getText();
				try {
					qm.makeInsertion("INSERT INTO Clienti (nome, cognome, ddnascita) VALUES (\""+nome+"\", \""+cognome+"\", '"+ddn+"');");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(12, 205, 117, 25);
		contentPane.add(btnOk);
	}
}
