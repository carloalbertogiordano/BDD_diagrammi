package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import queryMaker.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGestioneVisite = new JButton("Gestione Visite");
		btnGestioneVisite.setBounds(22, 5, 142, 25);
		contentPane.add(btnGestioneVisite);
		
		JButton btnGestioneMostre = new JButton("Gestione Mostre");
		btnGestioneMostre.setBounds(253, 5, 172, 25);
		contentPane.add(btnGestioneMostre);
		
		JTextPane textPaneMostre = new JTextPane();
		textPaneMostre.setBounds(22, 37, 405, 177);
		contentPane.add(textPaneMostre);
		
		textPaneMostre.setText("MOSTRE SCULTURE:\n");
		String q = "Select M.dataOraInizio, M.dataOraFine from MostraScultura M where M.codiceMuseo = \"" + codMuseo + "\" AND M.dataOraInizio >= now() group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine";
		ArrayList<ArrayList> o = qm.makeQuery(q);
		for(int i=1; i <= o.size()-1; i++) {
			textPaneMostre.setText(textPaneMostre.getText() + QueryMaker.format(o.get(i)));
		}
		q = "Select M.dataOraInizio, M.dataOraFine from MostraDipinto M where M.codiceMuseo = \"" + codMuseo + "\" AND M.dataOraInizio >= now() group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine";
		textPaneMostre.setText(textPaneMostre.getText() + "\n\nMOSTRE DIPINTI:\n");
		o = qm.makeQuery(q);
		for(int i=1; i <= o.size()-1; i++) {
			textPaneMostre.setText( textPaneMostre.getText() + QueryMaker.format(o.get(i)));
		}
		textPaneMostre.setText(textPaneMostre.getText() + "\n\nMOSTRE ALTRO:\n");
		q = "Select M.dataOraInizio, M.dataOraFine from MostraAltro M where M.codiceMuseo = \"" + codMuseo + "\" AND M.dataOraInizio >= now() group by M.codiceMuseo, M.dataOraInizio, M.dataOraFine";
		o = qm.makeQuery(q);
		for(int i=1; i <= o.size()-1; i++) {
			textPaneMostre.setText( textPaneMostre.getText() + QueryMaker.format(o.get(i)));
		}
		
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new SelezioneMuseo().setVisible(true);
				dispose();
			}
		});
		btnAnnulla.setBounds(12, 226, 117, 25);
		contentPane.add(btnAnnulla);
	}
}
