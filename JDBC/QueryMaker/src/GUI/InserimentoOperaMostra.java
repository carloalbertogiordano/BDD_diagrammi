package GUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import queryMaker.QueryMaker;
import tools.Tools;

public class InserimentoOperaMostra {

	private JFrame frame;
	private static ArrayList<String> mostra1;
	//ereditiamo l'oggetto di tipo QueryMaker così da non doverlo istanziare nuovamente con URL, UNAME, PASS
	private static QueryMaker qm = SelezioneMuseo.getQm();

	/**
	 * Launch the application.
	 * Quando questa finestra viene richiamata gli viene passato l'arrayList contenente le informazioni relative alla mostra selezionata
	 * le quali vengono salvate all'interno di un ArrayList di tipo string
	 */
	public static void main(ArrayList<String> mostra) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InserimentoOperaMostra window = new InserimentoOperaMostra();
					window.frame.setVisible(true);
					mostra1=mostra;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InserimentoOperaMostra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 542, 272);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 31, 530, 115);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 3, 10, 10));
		
		JLabel lblMostra = new JLabel("Tipo Opera");
		panel.add(lblMostra);
		
		String[] contentTipo = {"Dipinto", "Scultura", "Altro"};
		JComboBox comboBoxTipo = new JComboBox(contentTipo);
		JComboBox comboBoxNome = new JComboBox();
		JComboBox comboBoxNumero = new JComboBox();
		
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//salviamo l'indice dell'elemento selezionato, che ci indica quale tipo di opera si vuole inserire nella mostra
				int choois = comboBoxTipo.getSelectedIndex();
				comboBoxNome.setEnabled(true);
				comboBoxNome.removeAllItems();
				if(choois == 0) {
					ArrayList<ArrayList> o = null;
					try {
						/*
						 * Questa query ci permette di selezionare tutte le opere di tipo dipinto presenti all'interno del DB, prese una sola volta
						 * nel caso in cui siano presenti più versioni dell'opera (operatore DISTINCT)
						 * */
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Dipinto");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					/*
					 *Aggiungiamo al comboBoxNome tutte le opere del tipo selezionato
					 * */
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxNome.addItem(o.get(i).get(0));
					}
				}
				else if(choois == 1) {
					ArrayList<ArrayList> o = null;
					try {
						/*
						 * Questa query ci permette di selezionare tutte le opere di tipo scultura presenti all'interno del DB, prese una sola volta
						 * nel caso in cui siano presenti più versioni dell'opera (operatore DISTINCT)
						 * */
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Scultura");
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					/*
					 *Aggiungiamo al comboBoxNome tutte le opere del tipo selezionato
					 * */
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxNome.addItem(o.get(i).get(0));
					}
				}
				else if(choois == 2) {
					ArrayList<ArrayList> o = null;
					try {
						/*
						 * Questa query ci permette di selezionare tutte le opere di tipo scultura presenti all'interno del DB, prese una sola volta
						 * nel caso in cui siano presenti più versioni dell'opera (operatore DISTINCT)
						 * */
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Altro");
					} catch (SQLException e3) {
						e3.printStackTrace();
					}
					/*
					 *Aggiungiamo al comboBoxNome tutte le opere del tipo selezionato
					 * */
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxNome.addItem(o.get(i).get(0));
					}
				}
			}
		});
		
		comboBoxNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ArrayList> num = null;
				//salviamo il nome dell dell'opera selezionata
				String nomeOpera = (String) comboBoxNome.getSelectedItem();
				comboBoxNumero.setEnabled(true);
				nomeOpera = Tools.normalizeString(nomeOpera);
				try {
					if(comboBoxTipo.getSelectedIndex() == 0) 
						/*
						 * Se è stato selezionato il tipo dipinto, andiamo a effettuare una proiezione della colonna "numero", indicante
						 * la versione dell'opera, dalla tabella Dipinto utilizzando come condizione l'ugualgianza del campo nome
						 * */
						num = qm.makeQuery("Select numero From Dipinto Where nome = \""+ nomeOpera +"\";");
					if(comboBoxTipo.getSelectedIndex() == 1) 
						/*
						 * Se è stato selezionato il tipo scultura, andiamo a effettuare una proiezione della colonna "numero", indicante
						 * la versione dell'opera, dalla tabella Scultura utilizzando come condizione l'ugualgianza del campo nome
						 * */
						num = qm.makeQuery("Select numero From Scultura Where nome = \""+ nomeOpera +"\";");
					if(comboBoxTipo.getSelectedIndex() == 2)
						/*
						 * Se è stato selezionato il tipo altro, andiamo a effettuare una proiezione della colonna "numero", indicante
						 * la versione dell'opera, dalla tabella Altro utilizzando come condizione l'ugualgianza del campo nome
						 * */
						num = qm.makeQuery("Select numero From Altro Where nome = \""+ nomeOpera +"\";");
				} catch (SQLException e4) {
					e4.printStackTrace();
				}
				comboBoxNumero.removeAllItems();
				for(int i=1; i <= num.size()-1; i++) {
					comboBoxNumero.addItem(num.get(i).get(0));
				}
			}
		});

		panel.add(comboBoxTipo);
		
		JLabel lblNewLabel = new JLabel("Nome Opera");
		panel.add(lblNewLabel);
		
		panel.add(comboBoxNome);
		comboBoxNome.setEnabled(false);
		
		JLabel lblNewLabel_1 = new JLabel("Numero");
		panel.add(lblNewLabel_1);
		
		panel.add(comboBoxNumero);
		comboBoxNumero.setEnabled(false);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*
					 * Salviamo le informazioni mancanti della mostra selezionata (codiceMuseo, dataOraInizio, dataOraFine)
					 * */
					String codMuseo = mostra1.get(1);
					String dataOraInizio = mostra1.get(2);
					String dataOraFine = mostra1.get(3);
					
					/*
					 * Salviamo le informazioni che sono state inserite riguardanti l'opera da aggiungere (tipo, nome, numero)
					 * */
					String nomeOpera = (String) comboBoxNome.getSelectedItem();
					nomeOpera = Tools.normalizeString(nomeOpera);
					String numOpera = (String) comboBoxNumero.getSelectedItem();
					numOpera = Tools.normalizeString(numOpera);
					int numOp = Integer.parseInt(numOpera);
					int choois = comboBoxTipo.getSelectedIndex();
					if(choois == 0) {
						//dipinto
						try {
							/*
							 * Questa query ci permette di inserire un dipinto all'interno della tabella MostraDipinto, con le informazioni prima salvate
							 * */
							qm.makeInsertion("INSERT INTO MostraDipinto VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numOp+", '"+dataOraInizio+"', '"+dataOraFine+"');");
							JOptionPane.showMessageDialog(btnAggiungi, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(btnAggiungi, "L'elemento è già presente nella mostra", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if(choois == 1) {
						//scultura
						try {
							/*
							 * Questa query ci permette di inserire un scultur all'interno della tabella MostraScultura, con le informazioni prima salvate
							 * */
							qm.makeInsertion("INSERT INTO MostraScultura VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numOpera+", '"+dataOraInizio+"', '"+dataOraFine+"');");
							JOptionPane.showMessageDialog(btnAggiungi, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(btnAggiungi, "L'elemento è già presente nella mostra", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
					else if(choois == 2) {
						//altro
						try {
							/*
							 * Questa query ci permette di inserire un'opera di altro tipo all'interno della tabella MostraAltro, con le informazioni prima salvate
							 * */
							qm.makeInsertion("INSERT INTO MostraAltro VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numOpera+", '"+dataOraInizio+"', '"+dataOraFine+"');");
							JOptionPane.showMessageDialog(btnAggiungi, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(btnAggiungi, "L'elemento è già presente nella mostra", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(btnAggiungi, "Inserimento non riuscito", "Error!", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnAggiungi.setBounds(111, 168, 117, 25);
		frame.getContentPane().add(btnAggiungi);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnAnnulla.setBounds(271, 168, 117, 25);
		frame.getContentPane().add(btnAnnulla);
		
		
	}
}
