package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;

public class GestioneVisita extends JFrame {

	private JPanel contentPane;
	//Ereditiamo l'oggetto QueryMaker in modo da non doverlo istanziare nuovamente passandogli i valori URL, UNAME, PASS
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
		setBounds(100, 100, 299, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(12, 12, 70, 15);
		contentPane.add(lblCliente);
		
		JComboBox comboBoxListaClienti = new JComboBox();
		//Ultimo item, rappresenta l'inserimento di un nuovo cliente
		comboBoxListaClienti.addItem("--NUOVO--");
		comboBoxListaClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxListaClienti.getSelectedItem().equals("--NUOVO--")) {
					new NuovoCliente(codMuseo).setVisible(true);
					dispose();
				}
			}
		});
		comboBoxListaClienti.setBounds(81, 7, 202, 24);
		contentPane.add(comboBoxListaClienti);
		/*
		 * Questa query ci permette di salvare tutti i nomi e cognomi dei clienti e inserirli nel comboBox
		 * */
		ArrayList<ArrayList> o = qm.makeQuery("SELECT nome, cognome, id FROM Clienti");
		for(int i=1; i <= o.size()-1; i++) {
			comboBoxListaClienti.addItem(o.get(i).get(0)+" "+o.get(i).get(1)+" "+o.get(i).get(2));
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String cliente = (String) (comboBoxListaClienti.getSelectedItem());
				String[] campiCliente = cliente.split(" ");

				try {
					/*
					 * Questa query ci permette di inserire una nuova visita nella tabella Visita con i dati inseriti
					 * */
					qm.makeInsertion("INSERT INTO Visita VALUES (" + campiCliente[2] + ", \""+codMuseo+"\", current_timestamp())");
					JOptionPane.showMessageDialog(btnOk, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
					qm.makeInsertion("UPDATE Musei SET numeroVisite = numeroVisite + 1 WHERE codice = \""+codMuseo+"\"");
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(btnOk, "L'elemento è già presente nella mostra", "Error!", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnOk.setBounds(156, 55, 117, 25);
		contentPane.add(btnOk);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			//Torna alla finestra precedente
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Gestione(codMuseo).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnAnnulla.setBounds(12, 55, 117, 25);
		contentPane.add(btnAnnulla);
	}
}
