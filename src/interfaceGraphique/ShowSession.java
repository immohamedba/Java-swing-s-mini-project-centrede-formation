/*package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ShowSession extends JFrame {

	private JPanel contentPane;
	private JTextField idFormationTfiled;
	private JTextField idFormateurTfiled;
	private JTable table;

	public ShowSession() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		getContentPane().add(tabbedPane);
		
		JPanel session = new JPanel();
		tabbedPane.addTab("Session", null, session, null);
		session.setLayout(null);
		
		JLabel lbIdFormation = new JLabel("Id Formation");
		lbIdFormation.setBounds(71, 11, 69, 20);
		session.add(lbIdFormation);
		
		JLabel lbIdFormateur = new JLabel("Id Formateur");
		lbIdFormateur.setBounds(178, 11, 69, 20);
		session.add(lbIdFormateur);
		
		idFormationTfiled = new JTextField();
		idFormationTfiled.setBounds(56, 42, 86, 20);
		session.add(idFormationTfiled);
		idFormationTfiled.setColumns(10);
		
		idFormateurTfiled = new JTextField();
		idFormateurTfiled.setColumns(10);
		idFormateurTfiled.setBounds(161, 42, 86, 20);
		session.add(idFormateurTfiled);
		
		JButton btnCherhcerSession = new JButton("Cherhcer");
		btnCherhcerSession.setBounds(299, 41, 89, 23);
		session.add(btnCherhcerSession);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 78, 398, 119);
		session.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(table);
		
		table.setModel(new DefaultTableModel(
				new Object[][] { },
			new String[] {
				"Fomation ", "Formateur", "Date Debut", "Date FIn", "Heure Debut", "Heure Fin", "Salle"
			}
		));
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAjouter.setBounds(20, 208, 89, 23);
		session.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(158, 208, 89, 23);
		session.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(299, 208, 89, 23);
		session.add(btnSupprimer);
		
		JPanel Etudiant = new JPanel();
		tabbedPane.addTab("Etudiants", null, Etudiant, null);
		
		JPanel formation = new JPanel();
		tabbedPane.addTab("Formation", null, formation, null);
		
		JPanel formateur = new JPanel();
		tabbedPane.addTab("Formateur", null, formateur, null);
		
		JPanel specialite = new JPanel();
		tabbedPane.addTab("Specialite", null, specialite, null);
		
		JPanel Personnelle = new JPanel();
		tabbedPane.addTab("Personnelle ,", null, Personnelle, null);
		
	}
	
}*/
