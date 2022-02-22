package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;import javax.swing.event.CaretEvent;

import com.toedter.calendar.JDateChooser;

import queryMaker.QueryMaker;
import tools.Tools;
import com.toedter.components.JSpinField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GestioneMostre extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBoxNumero;
	//ereditiamo l'oggetto QueryManager in modo da non doverlo istanziare nuovamente passandogli URL, UNAME, PASS
	private static QueryMaker qm = SelezioneMuseo.getQm();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneMostre frame = new GestioneMostre(null);
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
	public GestioneMostre(String codMuseo) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMostra = new JLabel("Mostra");
		lblMostra.setBounds(12, 12, 76, 15);
		contentPane.add(lblMostra);
		
		String[] contentMostra = { "Dipinto", "Scultura", "Altro" };
		JComboBox comboBoxMostra = new JComboBox(contentMostra);
		JComboBox comboBoxOpera = new JComboBox();
		
		comboBoxMostra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choise = comboBoxMostra.getSelectedIndex();
				comboBoxOpera.setEnabled(true);
				comboBoxNumero.setEnabled(true);
				comboBoxOpera.removeAllItems();
				if( choise == 0) {
					ArrayList<ArrayList> o = null;
					try {
						/*
						 * Questa query ci permette di proiettare tutte le opere, in base alla tipologia selezionata
						 * */
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Dipinto");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxOpera.addItem(o.get(i).get(0));
					}
					
				}
				if(choise  == 1) {
					ArrayList<ArrayList> o = null;
					try {
						/*
						 * Questa query ci permette di proiettare tutte le opere, in base alla tipologia selezionata
						 * */
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Scultura");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxOpera.addItem(o.get(i).get(0));
					}
				}
				if(choise  == 2) {
					ArrayList<ArrayList> o = null;
					try {
						/*
						 * Questa query ci permette di proiettare tutte le opere, in base alla tipologia selezionata
						 * */
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Altro");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxOpera.addItem(o.get(i).get(0));
					}
				}
			}
		});
		
		comboBoxOpera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<ArrayList> num = null;
				String nomeOpera = (String) comboBoxOpera.getSelectedItem();
				nomeOpera = Tools.normalizeString(nomeOpera);
				try {
					if(comboBoxMostra.getSelectedIndex() == 0) 
						/*
						 * Questa query ci permette di salvare i valori disponibili relativi al campo "numero" di ogni opera, in base all'opera selezionata
						 * */
						num = qm.makeQuery("Select numero From Dipinto Where nome = \""+ nomeOpera +"\";");
					if(comboBoxMostra.getSelectedIndex() == 1) 
						/*
						 * Questa query ci permette di salvare i valori disponibili relativi al campo "numero" di ogni opera, in base all'opera selezionata
						 * */
						num = qm.makeQuery("Select numero From Scultura Where nome = \""+ nomeOpera +"\";");
					if(comboBoxMostra.getSelectedIndex() == 2) 
						/*
						 * Questa query ci permette di salvare i valori disponibili relativi al campo "numero" di ogni opera, in base all'opera selezionata
						 * */
						num = qm.makeQuery("Select numero From Altro Where nome = \""+ nomeOpera +"\";");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				comboBoxNumero.removeAllItems();
				for(int i=1; i <= num.size()-1; i++) {
					comboBoxNumero.addItem(num.get(i).get(0));
				}
			}
		});

		comboBoxMostra.setBounds(126, 7, 150, 24);
		contentPane.add(comboBoxMostra);
		
		JLabel lblOpera = new JLabel("Opera");
		lblOpera.setBounds(12, 48, 70, 15);
		contentPane.add(lblOpera);
		
		comboBoxNumero = new JComboBox();
		comboBoxNumero.setBounds(126, 79, 197, 24);
		contentPane.add(comboBoxNumero);

		comboBoxOpera.setEnabled(false);
		comboBoxNumero.setEnabled(false);
		comboBoxOpera.setBounds(126, 43, 197, 24);
		contentPane.add(comboBoxOpera);
		
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
		btnAnnulla.setBounds(12, 318, 117, 25);
		contentPane.add(btnAnnulla);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDate(new Date());
		SimpleDateFormat x=new SimpleDateFormat("Y-MM-dd");	
		
		dateChooser.setBounds(126, 135, 197, 24);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser.setDate(new Date());
		dateChooser_1.setBounds(126, 180, 197, 24);
		contentPane.add(dateChooser_1);
		
		ArrayList<ArrayList> musei = qm.makeQuery("SELECT m.orarioApertura, m.orarioChiusura FROM Musei m WHERE m.codice = \""+codMuseo+"\"");
		String OraInizio = (String) musei.get(1).get(0);
		String OraFine= (String) musei.get(1).get(1);
		
		String[] oraFormatStart = OraInizio.split(":");
		String[] oraFormatFinish = OraFine.split(":");
		
		JComboBox comboBoxMinutiInizio = new JComboBox();
		comboBoxMinutiInizio.setBounds(180, 216, 45, 24);
		contentPane.add(comboBoxMinutiInizio);
		
		JComboBox comboBoxOraInizio = new JComboBox();
		
		for(int i = Integer.parseInt(oraFormatStart[0]); i <= Integer.parseInt(oraFormatFinish[0])-4; i++) {
			comboBoxOraInizio.addItem(i);
		}
		
		comboBoxOraInizio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				if(comboBoxOraInizio.getSelectedIndex() == 0) {
					i = Integer.parseInt(oraFormatStart[1]);
				}
				
				for(; i <= 59; i++) {
					comboBoxMinutiInizio.addItem(i);
				}
			}
		});
		
		comboBoxOraInizio.setBounds(126, 216, 45, 24);
		contentPane.add(comboBoxOraInizio);
		
		JComboBox comboBoxMinutiFine = new JComboBox();
		comboBoxMinutiFine.setBounds(180, 247, 45, 24);
		contentPane.add(comboBoxMinutiFine);
		
		JComboBox comboBoxOraFine = new JComboBox();
		
		for(int i = Integer.parseInt(oraFormatStart[0]) + 4; i <= Integer.parseInt(oraFormatFinish[0]); i++) {
			comboBoxOraFine.addItem(i);
		}
		
		comboBoxOraFine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int max = 59;
				if((int)comboBoxOraFine.getSelectedItem() == Integer.parseInt(oraFormatFinish[0])) {
					max = Integer.parseInt(oraFormatFinish[1]);
				}
				for(int i = 0; i <= max; i++) {
					comboBoxMinutiFine.addItem(i);
				}
			}
		});
		
		comboBoxOraFine.setBounds(126, 247, 45, 24);
		contentPane.add(comboBoxOraFine);	
		
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBoxMinutiInizio.getSelectedItem() != null && comboBoxMinutiFine.getSelectedItem() != null) {
					String dataInizio = x.format(dateChooser.getDate());
					String dataFine = x.format(dateChooser_1.getDate());
					String nomeOpera = (String) comboBoxOpera.getSelectedItem();
					nomeOpera = Tools.normalizeString(nomeOpera);
					String numeroOpera = (String) comboBoxNumero.getSelectedItem();
					numeroOpera = Tools.normalizeString(numeroOpera);
					if(comboBoxMostra.getSelectedIndex() == 0) {
						try {
						/*
						 * Questa query ci permette di inserire una nuova mostra di dipinti nella teballa MostraDipinto, con i campi relativi ad un'opera
						 * specifica
						 * */
							qm.makeInsertion("INSERT INTO MostraDipinto VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numeroOpera+", '"+dataInizio+"', '"+dataFine+"');");
							JOptionPane.showMessageDialog(btnAggiungi, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(btnAggiungi, "Errore durante l'inserimento: controllare che i campi siano tutti inseriti correttamente o che non esista già una mostra con gli stessi valori", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
					if(comboBoxMostra.getSelectedIndex() == 1) {
						try {
						/*
						 * Questa query ci permette di inserire una nuova mostra di sculture nella teballa MostraScultura, con i campi relativi ad un'opera
						 * specifica
						 * */
							qm.makeInsertion("INSERT INTO MostraScultura VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numeroOpera+", '"+dataInizio+"', '"+dataFine+"');");
							JOptionPane.showMessageDialog(btnAggiungi, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(btnAggiungi, "Errore durante l'inserimento: controllare che i campi siano tutti inseriti correttamente o che non esista già una mostra con gli stessi valori", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}
					if(comboBoxMostra.getSelectedIndex() == 2) {
						try {
						/*
						 * Questa query ci permette di inserire una nuova mostra di opere di altro tipo nella teballa MostraAltro, con i campi relativi ad un'opera
						 * specifica
						 * */
							qm.makeInsertion("INSERT INTO MostraAltro VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numeroOpera+", '"+dataInizio+"', '"+dataFine+"');");
							JOptionPane.showMessageDialog(btnAggiungi, "Inserimento avvenuto con successo", "Done!", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(btnAggiungi, "Errore durante l'inserimento: controllare che i campi siano tutti inseriti correttamente o che non esista già una mostra con gli stessi valori", "Error!", JOptionPane.ERROR_MESSAGE);
						}
					}

				}
				else {
					JOptionPane.showMessageDialog(btnAggiungi, "Selezionare I campi mancanti", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAggiungi.setBounds(159, 318, 117, 25);
		contentPane.add(btnAggiungi);
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		lblDataInizio.setBounds(12, 137, 85, 15);
		contentPane.add(lblDataInizio);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		lblDataFine.setBounds(12, 182, 70, 15);
		contentPane.add(lblDataFine);
		
		JLabel lblOrainizio = new JLabel("Ora Inizio");
		lblOrainizio.setBounds(12, 225, 70, 15);
		contentPane.add(lblOrainizio);
		
		JLabel lblOraFine = new JLabel("Ora Fine");
		lblOraFine.setBounds(12, 252, 70, 15);
		contentPane.add(lblOraFine);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(12, 75, 70, 15);
		contentPane.add(lblNumero);
	}
}
