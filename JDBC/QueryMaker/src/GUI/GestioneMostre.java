package GUI;

import tools.*;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestioneMostre extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataInizio;
	private JTextField textFieldDataFine;
	private JTextField textFieldOraInizio;
	private JTextField textFieldOraFine;
	private JComboBox comboBoxNumero;
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
		comboBoxMostra.setBounds(126, 7, 150, 24);
		contentPane.add(comboBoxMostra);
		
		JLabel lblOpera = new JLabel("Opera");
		lblOpera.setBounds(12, 48, 70, 15);
		contentPane.add(lblOpera);
		
		
		JComboBox comboBoxOpera = new JComboBox();
		comboBoxOpera.setEnabled(false);
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
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeOpera = (String) comboBoxOpera.getSelectedItem();
				String numeroOpera = (String) comboBoxNumero.getSelectedItem();
				String dataOraInizio = (textFieldDataInizio.getText()+ " " +textFieldOraInizio.getText());
				String dataOraFine = (textFieldDataFine.getText()+ " " +textFieldOraFine.getText());
				if (!Tools.checkDate(dataOraInizio, dataOraFine)) {
					JOptionPane.showMessageDialog(contentPane, "Inserire dataOra in questo formato: AAAA:MM:GG HH:MM:SS");
				}
				else {
					nomeOpera = Tools.normalizeString(nomeOpera);
					numeroOpera = Tools.normalizeString(numeroOpera);
					if(comboBoxMostra.getSelectedIndex() == 0) {
						try {
							qm.makeInsertion("INSERT INTO MostraDipinto VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numeroOpera+", '"+dataOraInizio+"', '"+dataOraFine+"');");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(comboBoxMostra.getSelectedIndex() == 1) {
						try {
							qm.makeInsertion("INSERT INTO MostraScultura VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numeroOpera+", '"+dataOraInizio+"', '"+dataOraFine+"');");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					if(comboBoxMostra.getSelectedIndex() == 2) {
						try {
							qm.makeInsertion("INSERT INTO MostraAltro VALUES (\""+codMuseo+"\", \""+nomeOpera+"\", "+numeroOpera+", '"+dataOraInizio+"', '"+dataOraFine+"');");
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
				
				}
			}
		});
		btnAggiungi.setBounds(159, 318, 117, 25);
		contentPane.add(btnAggiungi);
		
		textFieldDataInizio = new JTextField();
		textFieldDataInizio.setBounds(126, 137, 150, 19);
		contentPane.add(textFieldDataInizio);
		textFieldDataInizio.setColumns(10);
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		lblDataInizio.setBounds(3, 139, 85, 15);
		contentPane.add(lblDataInizio);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		lblDataFine.setBounds(12, 180, 70, 15);
		contentPane.add(lblDataFine);
		
		JLabel lblOrainizio = new JLabel("Ora Inizio");
		lblOrainizio.setBounds(12, 225, 70, 15);
		contentPane.add(lblOrainizio);
		
		JLabel lblOraFine = new JLabel("Ora Fine");
		lblOraFine.setBounds(12, 264, 70, 15);
		contentPane.add(lblOraFine);
		
		textFieldDataFine = new JTextField();
		textFieldDataFine.setBounds(126, 178, 150, 19);
		contentPane.add(textFieldDataFine);
		textFieldDataFine.setColumns(10);
		
		textFieldOraInizio = new JTextField();
		textFieldOraInizio.setBounds(126, 223, 150, 19);
		contentPane.add(textFieldOraInizio);
		textFieldOraInizio.setColumns(10);
		
		textFieldOraFine = new JTextField();
		textFieldOraFine.setBounds(126, 262, 150, 19);
		contentPane.add(textFieldOraFine);
		textFieldOraFine.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(12, 75, 70, 15);
		contentPane.add(lblNumero);
		
		comboBoxNumero = new JComboBox();
		comboBoxNumero.setBounds(126, 79, 197, 24);
		contentPane.add(comboBoxNumero);
			
		JButton btnCerca = new JButton("Cerca");
		btnCerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int choise = comboBoxMostra.getSelectedIndex();
				comboBoxOpera.setEnabled(true);
				comboBoxOpera.removeAllItems();
				if( choise == 0) {
					ArrayList<ArrayList> o = null;
					try {
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Dipinto");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxOpera.addItem(QueryMaker.format(o.get(i)));
					}
					
				}
				if(choise  == 1) {
					ArrayList<ArrayList> o = null;
					try {
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Scultura");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxOpera.addItem(QueryMaker.format(o.get(i)));
					}
				}
				if(choise  == 2) {
					ArrayList<ArrayList> o = null;
					try {
						o = qm.makeQuery("SELECT DISTINCT(nome)FROM Altro");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					for(int i=1; i <= o.size()-1; i++) {
						comboBoxOpera.addItem(QueryMaker.format(o.get(i)));
					}
				}
			}
		});
		btnCerca.setBounds(288, 7, 117, 25);
		contentPane.add(btnCerca);
		
		JButton btnCercaNum = new JButton("Cerca");
		btnCercaNum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ArrayList> num = null;
				String nomeOpera = (String) comboBoxOpera.getSelectedItem();
				nomeOpera = Tools.normalizeString(nomeOpera);
				try {
					if(comboBoxMostra.getSelectedIndex() == 0) 
						num = qm.makeQuery("Select numero From Dipinto Where nome = \""+ nomeOpera +"\";");
					if(comboBoxMostra.getSelectedIndex() == 1) 
						num = qm.makeQuery("Select numero From Scultura Where nome = \""+ nomeOpera +"\";");
					if(comboBoxMostra.getSelectedIndex() == 2) 
						num = qm.makeQuery("Select numero From Altro Where nome = \""+ nomeOpera +"\";");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				comboBoxNumero.removeAllItems();
				for(int i=1; i <= num.size()-1; i++) {
					QueryMaker.format(num.get(i));
					comboBoxNumero.addItem(QueryMaker.format(num.get(i)));
				}
				
				
			}
		});
		btnCercaNum.setBounds(335, 43, 117, 25);
		contentPane.add(btnCercaNum);
	}
}
