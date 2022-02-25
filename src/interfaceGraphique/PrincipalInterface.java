package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.DaoFormateur;
import DAO.DaoSession;
import Object.Personelle;
import Object.Session;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;

public class PrincipalInterface extends JFrame {

	private JPanel contentPane;
	private JTextField idFormationTfiled;
	private JTextField idFormateurTfiled;
	private JTable table;
	private DaoSession daoSession ;
	private DaoFormateur daoFormateur;
	private JTextField newFomateurtxfld;
	private JTextField dateFintxtFld;
	private JTextField dateDebuttxtFld;
	private JTextField heurDebutTxtFld;
	private JTextField heurFinTxtField;
	private JTextField newFormtxfld;
	private  JComboBox<String> cbxSalle;
	private JTable table_formateur;
	private JTextField txtfldidFormateur_rech;
	private JTextField txtldNomformateur;
	private JTextField txtldPreNomformateur;
	private JTextField txtlEmailFormateur;
	private JTextField txtldTelformateur;
	private JTextField txtfldIDFormateur;
	private JComboBox<String> cmb_typeContrat;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalInterface frame = new PrincipalInterface();
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
	public PrincipalInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 509);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		JPanel Etudiant = new JPanel();
		tabbedPane.addTab("Etudiants", null, Etudiant, null);
		
		JPanel formation = new JPanel();
		tabbedPane.addTab("Formation", null, formation, null);
		
		JPanel specialite = new JPanel();
		tabbedPane.addTab("Specialite", null, specialite, null);
		
		JPanel Personnelle = new JPanel();
		tabbedPane.addTab("Personnelle ", null, Personnelle, null);
		
		JPanel formateur = new JPanel();
		tabbedPane.addTab("Formateur", null, formateur, null);
		formateur.setLayout(null);
		
		JScrollPane scrollPaneformateur = new JScrollPane();
		scrollPaneformateur.setBounds(260, 88, 523, 211);
		formateur.add(scrollPaneformateur);
		
		table_formateur = new JTable();
		table_formateur.setForeground(Color.GRAY);
		table_formateur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Personelle oldFormateur = getOldFormateur();
			    txtfldIDFormateur.setText(Integer.toString(oldFormateur.getId()));
			    txtldNomformateur.setText(oldFormateur.getNom());
				txtldPreNomformateur.setText(oldFormateur.getPrenom());
				txtldTelformateur.setText(Integer.toString (oldFormateur.getTel()));
				txtlEmailFormateur.setText(oldFormateur.getEmail());
				
				switch (oldFormateur.getType_contrat()) {	
				case "CDI" :  cmb_typeContrat.setSelectedItem("CDI"); break;
				case "CDD" : cmb_typeContrat.setSelectedItem("CDD"); break;
				case "Freelancer" : cmb_typeContrat.setSelectedItem("Freelancer"); break;
				case "freelancer" : cmb_typeContrat.setSelectedItem("Freelancer"); break;
				}
			}
		});
		table_formateur.setBackground(Color.WHITE);
		scrollPaneformateur.setViewportView(table_formateur);
		
		JButton btnAfficherTout = new JButton("Afficher tout");
		btnAfficherTout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAllSession();
			}
		});
		btnAfficherTout.setBounds(337, 364, 112, 34);
		formateur.add(btnAfficherTout);
		
		JButton btnSupFormateur = new JButton("Suprimer");
		btnSupFormateur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table_formateur.getModel();
				
				if(table_formateur.getSelectedRowCount()==1) {
					int row = table_formateur.getSelectedRow();
					
					int id = Integer.parseInt(table_formateur.getModel().getValueAt(row, 0).toString());		
					daoFormateur = new DaoFormateur();
				  boolean succes =  daoFormateur.SupprimerFormateur(id);
				    if (succes) {
				    txtfldIDFormateur.setText("");
					txtlEmailFormateur.setText("");
					txtldNomformateur.setText("");
					txtldPreNomformateur.setText("");
					txtldTelformateur.setText("");
					txtlEmailFormateur.setText("");
					cmb_typeContrat.setSelectedItem("Type Contrats");
					model.removeRow(table_formateur.getSelectedRow());
				    } else JOptionPane.showMessageDialog(null,"Erreur de Suppression !");
				}else {
					if(table_formateur.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"La table est vide");
					}else {JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne"); }
				}
			}
		});
		btnSupFormateur.setBounds(636, 364, 107, 34);
		formateur.add(btnSupFormateur);
		
		JButton btnRechFormateur = new JButton("Rechercher");
		btnRechFormateur.setBounds(596, 54, 89, 23);
		formateur.add(btnRechFormateur);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(499, 33, 46, 14);
		formateur.add(lblId);
		
		txtfldidFormateur_rech = new JTextField();
		txtfldidFormateur_rech.setBounds(462, 55, 86, 20);
		formateur.add(txtfldidFormateur_rech);
		txtfldidFormateur_rech.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 136, 46, 14);
		formateur.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(10, 175, 46, 14);
		formateur.add(lblPrenom);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(10, 208, 46, 14);
		formateur.add(lblEmail);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(10, 241, 46, 14);
		formateur.add(lblTel);
		
		JLabel lblTypeContrat = new JLabel("Type Contrat");
		lblTypeContrat.setBounds(10, 266, 73, 23);
		formateur.add(lblTypeContrat);
		
		txtldNomformateur = new JTextField();
		txtldNomformateur.setBounds(93, 133, 139, 20);
		formateur.add(txtldNomformateur);
		txtldNomformateur.setColumns(10);
		
		txtldPreNomformateur = new JTextField();
		txtldPreNomformateur.setBounds(93, 172, 139, 20);
		formateur.add(txtldPreNomformateur);
		txtldPreNomformateur.setColumns(10);
		
		txtlEmailFormateur = new JTextField();
		txtlEmailFormateur.setBounds(93, 205, 139, 20);
		formateur.add(txtlEmailFormateur);
		txtlEmailFormateur.setColumns(10);
		
		txtldTelformateur = new JTextField();
		txtldTelformateur.setBounds(93, 238, 139, 20);
		formateur.add(txtldTelformateur);
		txtldTelformateur.setColumns(10);
		
				
				cmb_typeContrat = new JComboBox();
				cmb_typeContrat.setBounds(93, 267, 139, 20);
				cmb_typeContrat.addItem("CDD");
				cmb_typeContrat.addItem("CDI");
				cmb_typeContrat.addItem("Freelancer");
				cmb_typeContrat.setSelectedItem("Type Contrats");
				formateur.add(cmb_typeContrat);
				
				JButton btnAjouterFormateur = new JButton("Ajouter");
				btnAjouterFormateur.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//initialiser
						int  id = 0;
						int  tel = 0;
						String nom = null;
						String prenom =null;
						String email =null;
						String  typeContrat=null;

						//recuperer les données 
						id=	Integer.parseInt(txtfldIDFormateur.getText());
						nom = txtldNomformateur.getText();
						prenom =  txtldPreNomformateur.getText();
						tel = Integer.parseInt(txtldTelformateur.getText());
						email =  txtlEmailFormateur.getText();
						typeContrat =  cmb_typeContrat.getSelectedItem().toString();
						//
						if(id !=0 ) {
							daoFormateur = new  DaoFormateur ();
							Personelle P = new Personelle(id, nom, prenom, tel, email, typeContrat, "formateur") ;
							boolean succes = daoFormateur.AjouterFormateur(P);
							if (succes) {
							    txtfldIDFormateur.setText("");txtlEmailFormateur.setText("");
								txtldNomformateur.setText("");txtldPreNomformateur.setText("");
								txtldTelformateur.setText("");txtlEmailFormateur.setText("");
								cmb_typeContrat.setSelectedItem("Type Contrats");
								
							    DefaultTableModel model = new DefaultTableModel();
							    model.setRowCount(0);
							    ShowAllFortmateur();
							JOptionPane.showMessageDialog(null,"Formateur Enregistrer avec succes");
							}else  JOptionPane.showMessageDialog(null,"Erruer d'ajout");
						}else {
							JOptionPane.showMessageDialog(null,"Veuillez renseigner les champs obligatoires");
						}
					
					}
				});
				btnAjouterFormateur.setBounds(17, 364, 100, 34);
				formateur.add(btnAjouterFormateur);
				
				JButton btnModifierFormateur = new JButton("Modifier");
				
				btnModifierFormateur.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int  id = 0;
						int  tel = 0;
						String nom = null;
						String prenom =null;
						String email =null;
						String  typeContrat=null;
						
						Personelle oldFormateur = getOldFormateur();
						//System.out.println( "btnModifier "+oldSession.getFormationId()+ " "+oldSession.getFormateurId() );
						id=	Integer.parseInt(txtfldIDFormateur.getText());
						nom = txtldNomformateur.getText();
						prenom =  txtldPreNomformateur.getText();
						tel = Integer.parseInt(txtldTelformateur.getText());
						email =  txtlEmailFormateur.getText();
						typeContrat =  cmb_typeContrat.getSelectedItem().toString();
						
						if( id !=0) {
							daoFormateur = new  DaoFormateur ();
							Personelle P = new Personelle(id, nom, prenom, tel, email, typeContrat, "formateur") ;
							boolean succes = daoFormateur.ModifierFormateur(P, oldFormateur);
							if(succes ==true) {
								DefaultTableModel model = new DefaultTableModel();
								model.setRowCount(0);
								ShowAllFortmateur ();
							    txtfldIDFormateur.setText("");txtlEmailFormateur.setText("");
								txtldNomformateur.setText("");txtldPreNomformateur.setText("");
								txtldTelformateur.setText("");txtlEmailFormateur.setText("");
								cmb_typeContrat.setSelectedItem("Type Contrats");
								
								JOptionPane.showMessageDialog(null,"Formateur Modifieé avec succès");
							}else JOptionPane.showMessageDialog(null,"Erreur de Modification !");
						}else {
							JOptionPane.showMessageDialog(null,"Erreur !");
						}
					}
				});
				btnModifierFormateur.setBounds(165, 364, 100, 34);
				formateur.add(btnModifierFormateur);
				
				JLabel id_formateur = new JLabel("ID");
				id_formateur.setBounds(10, 99, 46, 23);
				formateur.add(id_formateur);
				
				txtfldIDFormateur = new JTextField();
				txtfldIDFormateur.setBounds(93, 99, 139, 23);
				formateur.add(txtfldIDFormateur);
				txtfldIDFormateur.setColumns(10);
		
		JPanel session = new JPanel();
		tabbedPane.addTab("Session", null, session, null);
		session.setLayout(null);
		
		JLabel lbIdFormation = new JLabel("Id Formation");
		lbIdFormation.setBounds(421, 10, 69, 20);
		session.add(lbIdFormation);
		
		JLabel lbIdFormateur = new JLabel("Id Formateur");
		lbIdFormateur.setBounds(561, 9, 69, 20);
		session.add(lbIdFormateur);
		
		idFormationTfiled = new JTextField();
		idFormationTfiled.setBounds(418, 39, 86, 20);
		session.add(idFormationTfiled);
		idFormationTfiled.setColumns(10);
		idFormateurTfiled = new JTextField();
		idFormateurTfiled.setColumns(10);
		idFormateurTfiled.setBounds(556, 37, 86, 20);
		session.add(idFormateurTfiled);
		
		JButton btnCherhcerSession = new JButton("Cherhcer");
		btnCherhcerSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if( !idFormateurTfiled.getText().equals ("") &&!idFormationTfiled.getText().equals("") ) {
				
				int formationID =  Integer.parseInt(idFormationTfiled.getText());
				int formateurID = Integer.parseInt(	idFormateurTfiled.getText() );
				getSearchedSesssion(formationID,formateurID);
			}else  JOptionPane.showMessageDialog(null,"veuillez introduire les identifiants ");
			}
		});
		btnCherhcerSession.setBounds(686, 38, 95, 23);
		session.add(btnCherhcerSession);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 89, 557, 202);
		session.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		this.ShowAllSession();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Session oldS =  getOldSession();
				newFormtxfld.setText(Integer.toString(oldS.getFormationId()));
				newFomateurtxfld.setText(Integer.toString(oldS.getFormateurId()));
				dateDebuttxtFld.setText(oldS.getDateDebut());
				dateFintxtFld.setText(oldS.getDateFin());
				heurDebutTxtFld.setText(oldS.getHeurDebut());
				heurFinTxtField.setText(oldS.getHeurFin());
				
				switch (oldS.getSalle()) {	
				case "C01" :  cbxSalle.setSelectedItem("C01"); break;
				case "C02" : cbxSalle.setSelectedItem("C02"); break;
				case "C03" : cbxSalle.setSelectedItem("C03"); break;
				}
				
			}
		});
		
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setForeground(Color.GRAY);
		scrollPane.setViewportView(table);
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int  idFormateur = 0;
				int  idFormation = 0;
				String date_fin = null;
				String date_debut =null;
				String heure_D =null;
				String heure_Fin =null;
				String salle =null;
				idFormateur=	Integer.parseInt(newFomateurtxfld.getText());
				idFormation = Integer.parseInt(newFormtxfld.getText());
				date_debut = dateDebuttxtFld.getText();
				date_fin =  dateFintxtFld.getText();
				heure_D =  heurDebutTxtFld.getText();
				heure_Fin =  heurFinTxtField.getText();
				salle =  cbxSalle.getSelectedItem().toString();
				if(idFormateur !=0 && idFormation !=0 && date_debut != null && heure_Fin !=null ) {
					daoSession = new  DaoSession ();
					Session S = new Session (idFormation, idFormateur,date_debut,date_fin,heure_D,heure_Fin,salle  );
					boolean succes = daoSession.AjouterSession(S);
					if (succes) {
					newFomateurtxfld.setText("");  newFormtxfld.setText("");
					dateDebuttxtFld.setText(""); dateFintxtFld.setText("");
					heurDebutTxtFld.setText(""); heurFinTxtField.setText(""); 
					cbxSalle.setSelectedItem("choisir salle");
					DefaultTableModel model = new DefaultTableModel();
					model.setRowCount(0);
					ShowAllSession ();
					JOptionPane.showMessageDialog(null,"Session Enregistrer avec succes");
					}else  JOptionPane.showMessageDialog(null,"Erruer d'ajout");
				}else {
					JOptionPane.showMessageDialog(null,"Veuillez renseigner les champs obligatoires");
				}
			}
		});
		btnAjouter.setBounds(21, 323, 95, 26);
		session.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  idFormateur = 0;
				int  idFormation = 0;
				String date_fin = null;
				String date_debut =null;
				String heure_D =null;
				String heure_Fin =null;
				String salle =null;
				Session oldSession = getOldSession();
				//System.out.println( "btnModifier "+oldSession.getFormationId()+ " "+oldSession.getFormateurId() );
				idFormateur=	Integer.parseInt(newFomateurtxfld.getText());
				idFormation = Integer.parseInt(newFormtxfld.getText());
				date_debut = dateDebuttxtFld.getText();
				date_fin =  dateFintxtFld.getText();
				heure_D =  heurDebutTxtFld.getText();
				heure_Fin =  heurFinTxtField.getText();
				salle =  cbxSalle.getSelectedItem().toString();
				if(idFormateur !=0 && idFormation !=0 && date_debut != null && heure_Fin !=null ) {
					daoSession = new  DaoSession ();
					Session newSession = new Session (idFormation, idFormateur,date_debut,date_fin,heure_D,heure_Fin,salle  );
					boolean succes = daoSession.ModifierSession(newSession, oldSession);
					if(succes ==true) {
						DefaultTableModel model = new DefaultTableModel();
						model.setRowCount(0);
						ShowAllSession ();
						newFomateurtxfld.setText("");  newFormtxfld.setText("");
						dateDebuttxtFld.setText(""); dateFintxtFld.setText("");
						heurDebutTxtFld.setText(""); heurFinTxtField.setText(""); 
						cbxSalle.setSelectedItem("choisir salle");
						JOptionPane.showMessageDialog(null,"Session Modifieé avec succès");
					}else JOptionPane.showMessageDialog(null,"Erreur de Modification !");
				}else {
					JOptionPane.showMessageDialog(null,"Erreur !");
				}
			}
		});
		
		btnModifier.setBounds(159, 323, 104, 27);	
		session.add(btnModifier);
		JButton btnSupprimer = new JButton("Supprimer");
		
			btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				
				if(table.getSelectedRowCount()==1) {
					System.out.println("getSelectedColumn 1");
					int row = table.getSelectedRow();
					int  idFormateur = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
					int idFormation = Integer.parseInt(table.getModel().getValueAt(row, 1).toString());
					String date_debut = (String) table.getModel().getValueAt(row, 2);
					String date_fin =  table.getModel().getValueAt(row, 3).toString();
					daoSession = new  DaoSession ();
					//System.out.println("ROW "+idFormateur +"  "+idFormation+ "  "+date_debut+"  "+date_fin+" ");
				  boolean succes =  daoSession.SupprimerSession(idFormateur , idFormation, date_debut, date_fin);
				    if (succes) {	
					newFomateurtxfld.setText("");  newFormtxfld.setText("");
					dateDebuttxtFld.setText(""); dateFintxtFld.setText("");
					heurDebutTxtFld.setText(""); heurFinTxtField.setText(""); 
					cbxSalle.setSelectedItem("choisir salle");
					model.removeRow(table.getSelectedRow());
				    } else JOptionPane.showMessageDialog(null,"Erreur de Suppression !");
				}else {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"La table est vide");
					}else {JOptionPane.showMessageDialog(null, "veuillez selectionner une ligne"); }
				}
				
			}
		});
			btnSupprimer.setBounds(662, 322, 104, 29);
			session.add(btnSupprimer);
			
			JLabel lblfomation = new JLabel("Fomation");
			lblfomation.setBounds(21, 70, 71, 26);
			session.add(lblfomation);
			
			JLabel lblFormateur = new JLabel("Formateur");
			lblFormateur.setBounds(21, 116, 64, 14);
			session.add(lblFormateur);
			
			JLabel lblDateDebut = new JLabel("Date Debut");
			lblDateDebut.setBounds(21, 149, 81, 24);
			session.add(lblDateDebut);
			
			JLabel lblDateFin = new JLabel("Date Fin");
			lblDateFin.setBounds(21, 184, 54, 14);
			session.add(lblDateFin);
			
			JLabel lblHeureDebut = new JLabel("Heure Debut");
			lblHeureDebut.setBounds(21, 219, 71, 14);
			session.add(lblHeureDebut);
			
			JLabel lblHeureFin = new JLabel("Heure Fin");
			lblHeureFin.setBounds(21, 242, 53, 18);
			session.add(lblHeureFin);
			
            newFormtxfld = new JTextField();
            newFormtxfld.setToolTipText("");
            newFormtxfld.setBounds(102, 76, 107, 20);
            session.add(newFormtxfld);
            newFormtxfld.setColumns(10);
            
            newFomateurtxfld = new JTextField();
            newFomateurtxfld.setBounds(102, 108, 107, 20);
            session.add(newFomateurtxfld);
            newFomateurtxfld.setColumns(10);
            
            dateFintxtFld = new JTextField();
            dateFintxtFld.setBounds(102, 176, 107, 20);
            session.add(dateFintxtFld);
            dateFintxtFld.setColumns(10);
            
            dateDebuttxtFld = new JTextField();
            dateDebuttxtFld.setBounds(102, 147, 107, 20);
            session.add(dateDebuttxtFld);
            dateDebuttxtFld.setColumns(10);
            
            heurDebutTxtFld = new JTextField();
            heurDebutTxtFld.setBounds(102, 216, 107, 20);
            session.add(heurDebutTxtFld);
            heurDebutTxtFld.setColumns(10);
            
            heurFinTxtField = new JTextField();
            heurFinTxtField.setBounds(102, 244, 107, 20);
            session.add(heurFinTxtField);
            heurFinTxtField.setColumns(10);
            
            JLabel lblSalle = new JLabel("Salle");
            lblSalle.setBounds(21, 277, 46, 14);
            session.add(lblSalle);
            
            cbxSalle = new JComboBox<String>();
            cbxSalle.setEditable(true);
            cbxSalle.addItem("C01");
            cbxSalle.addItem("C02");
            cbxSalle.addItem("c03");
            cbxSalle.setSelectedItem("Choisir Salle");
            cbxSalle.setBounds(101, 275, 108, 20);
             session.add(cbxSalle);
             
             JButton btnShowAll = new JButton("Afficher tout");
             btnShowAll.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		ShowAllSession ();
             	}
             });
             btnShowAll.setBounds(383, 325, 107, 29);
             session.add(btnShowAll);
             this.ShowAllFortmateur();
			
	}
	private void ShowAllSession() {	

		  daoSession = new  DaoSession ();
		  updateTableSession (daoSession.ListerSessions());
	}
	public void ShowAllFortmateur () {
		daoFormateur = new DaoFormateur();
		updateTableFormateur(daoFormateur.ListerFormateur());
	}
	
	public void getSearchedSesssion(int idformateur, int idFormation) {
		daoSession = new  DaoSession ();
		 ArrayList<Session> listSession = new  ArrayList<Session> ();
		 listSession = daoSession.chercherSession(idformateur, idFormation);
	//	 updateTableSession (listSession);
	//	  daoSession = new  DaoSession ();
	  if(listSession.isEmpty() ){
		  JOptionPane.showMessageDialog(null, "il n'y a Pas de session");  
		  }else  updateTableSession (listSession);
	}
	
	public void updateTableSession(ArrayList<Session> listSession) {
		DefaultTableModel model = new DefaultTableModel();
		Object[]column= {"Fomation ", "Formateur", "Date Debut", "Date FIn", "Heure Debut", "Heure Fin", "Salle"};// l'entete du jtable
		 model.setColumnIdentifiers(column);
		 table.setModel(model);
		  daoSession = new  DaoSession ();
		// ArrayList<Session> listSession = daoSession.ListerSessions()  ;
		 final  Object[] row  =new Object[7];// les ligens du jtable 
		 for(int i = 0; i< listSession.size(); i++ ) {
			 row[0] = listSession.get(i).getFormationId() ;
			 row[1] = listSession.get(i).getFormateurId();
			 row[2] = listSession.get(i).getDateDebut();
			 row[3] = listSession.get(i).getDateFin();
			 row[4] = listSession.get(i).getHeurDebut();
			 row[5] = listSession.get(i).getHeurFin();
			 row[6] = listSession.get(i).getSalle();
			// System.out.println("DAO "+listSession.get(i).getSalle() );
			 model.addRow(row);
		 }
	}
	public Session getOldSession( ) {
		Session oldSession = new Session();
		int i = table.getSelectedRow();
		TableModel model =table.getModel();
		oldSession.setFormationId(Integer.parseInt( model.getValueAt(i, 0).toString()));
		oldSession.setFormateurId(Integer.parseInt( model.getValueAt(i, 1).toString()));
	 System.out.println( "getOldSession"+oldSession.getFormationId()+ " "+oldSession.getFormateurId() );
		oldSession.setDateDebut(model.getValueAt(i, 2).toString());
		oldSession.setDateFin(model.getValueAt(i, 3).toString());
		oldSession.setHeurDebut(model.getValueAt(i, 4).toString());
		oldSession.setHeurFin(model.getValueAt(i, 5).toString());
		oldSession.setSalle(model.getValueAt(i, 6).toString());		
		return oldSession;
	}
	
	public Personelle getOldFormateur() {
		Personelle oldFormateur  = new Personelle (); 
		int i = table_formateur.getSelectedRow();
		TableModel model =table_formateur.getModel();
		oldFormateur.setId(Integer.parseInt( model.getValueAt(i, 0).toString()));
		oldFormateur.setNom(model.getValueAt(i, 1).toString());
		oldFormateur.setPrenom(model.getValueAt(i, 2).toString());
		oldFormateur.setTel(Integer.parseInt( model.getValueAt(i, 3).toString()));
		oldFormateur.setEmail(model.getValueAt(i, 4).toString());
		oldFormateur.setType_contrat(model.getValueAt(i, 5).toString());
		return oldFormateur;
	}

public void  updateTableFormateur (ArrayList<Personelle > listFormateur) {
	DefaultTableModel model = new DefaultTableModel();
	Object[]column =  {"ID", "Nom", "Prenom", "Tel", "Email", "Type Contrat"};
	 model.setColumnIdentifiers(column);
	 table_formateur.setModel(model);
	 
	 //daoFormateur = new  DaoFormateur ();
	 final  Object[] row  =new Object[6];
	 for(int i = 0; i< listFormateur.size(); i++ ) {
		 row[0] = listFormateur.get(i).getId() ;
		 row[1] = listFormateur.get(i).getNom();
		 row[2] = listFormateur.get(i).getPrenom();
		 row[3] = listFormateur.get(i).getTel();
		 row[4] = listFormateur.get(i).getEmail();
		 row[5] = listFormateur.get(i).getType_contrat();
		// System.out.println("DAO "+listSession.get(i).getSalle() );
		 model.addRow(row);
	 }
}
}


	
