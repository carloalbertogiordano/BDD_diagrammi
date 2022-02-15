package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class GestioneVisita extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldData;
	private JTextField textFieldOraIngresso;
	private JTextField textFieldOraUscita;
	private JTextPane textPaneResult;
	private static QueryMaker qm = SelezioneMuseo.getQm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneVisita frame = new GestioneVisita(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public GestioneVisita(String codMuseo) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 12, 70, 15);
		contentPane.add(lblCliente);
		
		JComboBox comboBoxListaClienti = new JComboBox();
		comboBoxListaClienti.setBounds(81, 7, 202, 24);
		contentPane.add(comboBoxListaClienti);
		ArrayList<ArrayList> o = qm.makeQuery("SELECT nome, cognome FROM Clienti");
		for(int i=1; i <= o.size()-1; i++) {
			comboBoxListaClienti.addItem(QueryMaker.format(o.get(i)));
		}
		comboBoxListaClienti.addItem("--NUOVO--");
		
		JLabel lblVisita = new JLabel("Data:");
		lblVisita.setBounds(12, 72, 70, 15);
		contentPane.add(lblVisita);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(22, 93, 114, 19);
		contentPane.add(textFieldData);
		textFieldData.setColumns(10);
		
		JLabel lblOraIngresso = new JLabel("Ora Ingresso:");
		lblOraIngresso.setBounds(12, 124, 99, 15);
		contentPane.add(lblOraIngresso);
		
		textFieldOraIngresso = new JTextField();
		textFieldOraIngresso.setBounds(22, 142, 114, 19);
		contentPane.add(textFieldOraIngresso);
		textFieldOraIngresso.setColumns(10);
		
		JLabel lblOraUscita = new JLabel("Ora Uscita:");
		lblOraUscita.setBounds(12, 173, 99, 15);
		contentPane.add(lblOraUscita);
		
		textFieldOraUscita = new JTextField();
		textFieldOraUscita.setBounds(22, 188, 114, 19);
		contentPane.add(textFieldOraUscita);
		textFieldOraUscita.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxListaClienti.getSelectedItem().equals("--NUOVO--")) {
					new NuovoCliente(codMuseo).setVisible(true);
					dispose();
				}
				String dataOraIngresso, dataOraUscita;
				dataOraIngresso = textFieldData.getText() + " " + textFieldOraIngresso.getText();
				dataOraUscita = textFieldData.getText() + " " + textFieldOraUscita.getText();
				int IDutente = 1 + (comboBoxListaClienti.getSelectedIndex());						
				try {
					qm.makeInsertion("INSERT INTO Visita VALUES (" + IDutente + ", \""+codMuseo+"\", '"+dataOraIngresso+"', '"+dataOraUscita+"')");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnOk.setBounds(166, 252, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Gestione(codMuseo).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnAnnulla.setBounds(12, 252, 117, 25);
		contentPane.add(btnAnnulla);
		
		textPaneResult = new JTextPane();
		textPaneResult.setEditable(false);
		textPaneResult.setBounds(166, 211, 117, 21);
		contentPane.add(textPaneResult);
		textPaneResult.setVisible(false);
	}
}
