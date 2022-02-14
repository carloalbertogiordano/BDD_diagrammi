package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Manager.QueryMaker;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class SelezioneMuseo2 extends JFrame {

	private JPanel contentPane;
	static final String DB_URL="jdbc:mysql://localhost/DBMuseo";
	static final String USER="root";
	static final String PAS="a^%!mq7EB9n^eX";
	static ArrayList<ArrayList> arr = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryMaker qm = new QueryMaker(DB_URL, USER, PAS);
					arr = qm.makeQuery("Select nome from Musei;");
					SelezioneMuseo2 frame = new SelezioneMuseo2();
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
	public SelezioneMuseo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 151);
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
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Seleziona");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for(int i=1; i <= arr.size()-1; i++) {
			comboBox.addItem(QueryMaker.format(arr.get(i)));
		}
	}

}
