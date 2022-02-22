package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import queryMaker.QueryMaker;

public class Gestione extends JFrame {

	private JPanel contentPane;
	//Ereditiamo l'oggetto QueryMaker dall'interfaccia di selezione del museo così da non dover creare una nuova istanza inserendo nuovamente URL, UNAME e PASS
	private static QueryMaker qm = SelezioneMuseo.getQm();
	private JTable table;
	private LocalDate currentDate = LocalDate.of(2022, 02, 21);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestione frame = new Gestione(null);
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
	public Gestione(String codMuseo) throws SQLException {		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		
		/*
		 * Questa query è composta dall'unione di tre query, ognuna delle quali ci permette di selezionare tutte le mostre future, rispettivamente di
		 * dipinti, sculture e opere di altro tipo, in base al museo che abbiamo selezionato precedentemente
		 * */
		String q = "SELECT m.nome, d.codiceMuseo, d.dataOraInizio, d.dataOraFine FROM MostraDipinto d, Musei m WHERE d.codiceMuseo = \""+codMuseo+"\" "
				+ "AND d.codiceMuseo = m.codice AND d.dataOraFine < current_timestamp() GROUP BY d.codiceMuseo, d.dataOraInizio, d.dataOraFine \n"
				+ "UNION \n"
				+ "SELECT m.nome, s.codiceMuseo, s.dataOraInizio, s.dataOraFine FROM MostraScultura s, Musei m WHERE s.codiceMuseo = \""+codMuseo+"\" "
				+ "AND s.codiceMuseo = m.codice AND s.dataOraFine < current_timestamp() GROUP BY s.codiceMuseo, s.dataOraInizio, s.dataOraFine \n"
				+ "UNION \n"
				+ "SELECT m.nome, a.codiceMuseo, a.dataOraInizio, a.dataOraFine FROM MostraAltro a, Musei m WHERE a.codiceMuseo = \""+codMuseo+"\" "
				+ "AND a.codiceMuseo = m.codice AND a.dataOraFine < current_timestamp() GROUP BY a.codiceMuseo, a.dataOraInizio, a.dataOraFine;";
		
		ArrayList<ArrayList> o = qm.makeQuery(q);
		
		JButton btnGestioneVisite = new JButton("Gestione Visite");
		btnGestioneVisite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Richiama la finestra di gestione delle visite e elimina la finestra corrente
					new GestioneVisita(codMuseo).setVisible(true);
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnGestioneVisite.setBounds(12, 38, 142, 25);
		contentPane.add(btnGestioneVisite);
		
		JButton btnGestioneMostre = new JButton("Inerimento Mostra");
		btnGestioneMostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//richiama la finestra per l'inserimento di una nuova mostra
					new GestioneMostre(codMuseo).setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnGestioneMostre.setBounds(180, 38, 172, 25);
		contentPane.add(btnGestioneMostre);
		
		JPanel panel = new JPanel();
		DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
               //all cells false
               return false;
            }
        };
		
        /*
         * controllo che non sia stata selzionata la riga con le intestazioni di colonna oppure che non sia stata selezionata nessuna riga
         * */
		JButton btnInseirsciOperaIn = new JButton("Inseirsci opera in una mostra");
		btnInseirsciOperaIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				int numrowselected=table.getSelectedRowCount();
				if(row != 0 && numrowselected == 1) {
					InserimentoOperaMostra.main(o.get(table.getSelectedRow()));
				}
			}
		});
		
		btnInseirsciOperaIn.setBounds(364, 38, 267, 25);
		contentPane.add(btnInseirsciOperaIn);
		panel.setBounds(12, 75, 619, 232);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(table, BorderLayout.CENTER);
		
		table.setModel(model);
		
		Vector<String> tmp1 = new Vector<String>(o.get(0));
		
	    for(int i = 0; i < o.get(0).size(); i++) {
	       	model.addColumn(tmp1.get(i));
	    }
	    
        for(int j=0;j<= o.size()-1;j++) {
        	Vector<String> tmp = new Vector<String>(o.get(j));
	       	model.addRow(tmp);
	    }
		
		JButton btnAnnulla = new JButton("Indietro");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Richiama la finestra precedente
				new SelezioneMuseo().setVisible(true);
				dispose();
			}
		});
		
		btnAnnulla.setBounds(12, 320, 117, 25);
		contentPane.add(btnAnnulla);
		
		/*
		 * Questa query ci permette di visualizzare il numero di visite odierne di ogni museo
		 * */
		ArrayList<ArrayList> numVisite = qm.makeQuery("SELECT numeroVisite FROM Musei WHERE codice = \""+codMuseo+"\"");
		
		
		JLabel lblNumeroVisiteOdierne = new JLabel("Numero visite odierne: "+numVisite.get(1).get(0));
		lblNumeroVisiteOdierne.setBounds(318, 325, 225, 15);
		contentPane.add(lblNumeroVisiteOdierne);
	}
}
