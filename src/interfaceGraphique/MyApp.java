package interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Color;

public class MyApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyApp window = new MyApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(tabbedPane);
		
		JMenu sessionMenu = new JMenu("");
		tabbedPane.addTab("Session", null, sessionMenu, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		
		JMenu formationMenu = new JMenu("Formation");
		tabbedPane.addTab("NFormation", null, formationMenu, null);
		
		JMenu formateurMenu = new JMenu("Formateur");
		tabbedPane.addTab("Formateur", null, formateurMenu, null);
		
		JMenu etudiantMenu = new JMenu("Etudiant");
		tabbedPane.addTab("Etudiant", null, etudiantMenu, null);
		
		JMenu personelleMenu = new JMenu("Personelle");
		tabbedPane.addTab("Personelle", null, personelleMenu, null);
		
		JMenu specialiteMenu = new JMenu("Specialite");
		tabbedPane.addTab("New tab", null, specialiteMenu, null);
	}

}
