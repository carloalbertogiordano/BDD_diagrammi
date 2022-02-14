package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import queryMaker.*;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SelezioneMuseo extends JFrame {

	private JPanel contentPane;
	static ArrayList<ArrayList> arr = null;
	static String codMuseo;
	protected static QueryMaker qm = new QueryMaker("jdbc:mysql://localhost:3306/DBMuseo", "userMuseo", "2001");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					arr = qm.makeQuery("Select nome from Musei;");
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
		panel.add(comboBoxSelezioneMuseo);
		
		JButton btnSeleziona = new JButton("Seleziona");
		btnSeleziona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = comboBoxSelezioneMuseo.getSelectedIndex();
				if(indice == 0)
					codMuseo = "A1";
				else if(indice == 1)
					codMuseo = "A2";
				else if(indice == 2)
					codMuseo = "A3";
				else if(indice == 3)
					codMuseo = "A4";
				
				try {
					new Gestione(codMuseo).setVisible(true);
					setVisible(false);
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		panel.add(btnSeleziona);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for(int i=1; i <= arr.size()-1; i++) {
			comboBoxSelezioneMuseo.addItem(QueryMaker.format(arr.get(i)));
		}
	}

	public static QueryMaker getQm() {
		return qm;
	}

}
