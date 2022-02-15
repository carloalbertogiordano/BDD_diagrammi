package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import queryMaker.QueryMaker;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

public class Gestione extends JFrame {

	private JPanel contentPane;
	private static QueryMaker qm = SelezioneMuseo.getQm();

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
		
		JLabel label = new JLabel("");
		label.setBounds(125, 0, 403, 25);
		contentPane.add(label);
		
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
		
		JButton btnGestioneMostre = new JButton("Gestione Mostre");
		btnGestioneMostre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
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
		panel.setBounds(22, 75, 534, 216);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		//Ricerca quali mostre sono o saranno in esposizione e le mostra
		JTextArea textArea = new JTextArea();
		textArea.setText("MOSTRE SCULTURE:\nData inizio   Ora inizio   Data fine     Ora fine\n");
		textArea.setText(textArea.getText() + "\n\nMOSTRE DIPINTI:\nData inizio   Ora inizio   Data fine     Ora fine\n");
		textArea.setText(textArea.getText() + "\n\nMOSTRE ALTRO:\nData inizio   Ora inizio   Data fine     Ora fine\n");
		String q = "Select M.dataOraInizio, M.dataOraFine from MostraScultura M where M.codiceMuseo = \"" + codMuseo + "\" AND M.dataOraInizio >= now() group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine";
		ArrayList<ArrayList> o = qm.makeQuery(q);
		for(int i=1; i <= o.size()-1; i++) {
			textArea.append(QueryMaker.format(o.get(i))+ "\n");
		}
		q = "Select M.dataOraInizio, M.dataOraFine from MostraDipinto M where M.codiceMuseo = \"" + codMuseo + "\" AND M.dataOraInizio >= now() group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine";
		o = qm.makeQuery(q);
		for(int i=1; i <= o.size()-1; i++) {
			textArea.append(QueryMaker.format(o.get(i))+ "\n");
		}
		q = "Select M.dataOraInizio, M.dataOraFine from MostraAltro M where M.codiceMuseo = \"" + codMuseo + "\" AND M.dataOraInizio >= now() group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine";
		o = qm.makeQuery(q);
		for(int i=1; i <= o.size()-1; i++) {
			textArea.append(QueryMaker.format(o.get(i))+ "\n");
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane);
		
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Richiama la finestra precedente
				new SelezioneMuseo().setVisible(true);
				dispose();
			}
		});
		
		btnAnnulla.setBounds(12, 320, 117, 25);
		contentPane.add(btnAnnulla);
	}
}
