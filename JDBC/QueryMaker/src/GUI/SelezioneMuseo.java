package GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;

public class SelezioneMuseo extends JFrame {

	private JPanel contentPane;
	static ArrayList<ArrayList> arr = null; //arrayList di arrayList che conterrà il risultato della query
	static String codMuseo;
	//Connesisone al database
	protected static QueryMaker qm = new QueryMaker("jdbc:mysql://localhost/DBMuseo", "root", "a^%!mq7EB9n^eX");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*Query che ci permette di selzionare tutte le colonne dalla tabella Musei. Ciò è necessario per ottenere i nomi dei musei
					e i loro codici*/
					arr = qm.makeQuery("Select * from Musei;");
					qm.makeInsertion("UPDATE Musei SET numeroVisite = 0");
					SelezioneMuseo frame = new SelezioneMuseo ();
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
	public SelezioneMuseo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Benvenuto utente. Seleziona un museo");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBoxSelezioneMuseo = new JComboBox();
		
		/*
		 * Una volta effettuata la query avermo nell'arrayList di arrayList tutte le istanze di musei. Con il cilco for seguente andiamo 
		 * a riempire i campi del comboBox necessario per la selezione del museo andando a selezionare la colonna contenente il nom (1), dell'iesimo 
		 * ArrayList
		 * */
		
		for(int i=1; i <= arr.size()-1; i++) {
			comboBoxSelezioneMuseo.addItem(arr.get(i).get(1));
		}
				
		comboBoxSelezioneMuseo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Una volta selezionato un elemento del comboBox andiamo a prendere l'indice selezionato così da poter memorizzare il codice 
				 * del museo selezionato
				 * */
				int choois = comboBoxSelezioneMuseo.getSelectedIndex();
				codMuseo = (String) arr.get(choois+1).get(0);
				try {
					//Richiama la gui successiva passandogli in codice del museo
					new Gestione(codMuseo).setVisible(true);
					//Chiude la finestra corrente
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(comboBoxSelezioneMuseo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	}

	public static QueryMaker getQm() {
		return qm;
	}
}
