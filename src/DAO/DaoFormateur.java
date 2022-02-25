package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Object.Personelle;

public class DaoFormateur {
	
	
	Connection con; 
	public DaoFormateur() {
		Connexion connexiton = new  Connexion();
		con = connexiton.getConnexion();
	}
	
	
	public boolean  AjouterFormateur(Personelle P) {
		String Rquest = "INSERT INTO personnelle (nom, prenom, tel,email,type_contra, type_perso) VALUES (? , ?, ?, ?, ?, ?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(Rquest);
			stmt.setNString(1, P.getNom());
			stmt.setString(2, P.getPrenom() );
			stmt.setInt(3, P.getTel());
			stmt.setString(4, P.getEmail());
			stmt.setString(5, P.getType_contrat());
			stmt.setString(6,"formateur");
			
			stmt.execute();
			System.out.println(" Formateur Added !");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean  SupprimerFormateur(int id) {
		String Request ="DELETE FROM personnelle WHERE id = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setInt(1,id );
			stmt.execute();
			return true;
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return false;
	}
	
	public void SupprimerFormateurs() {

		String Request ="DELETE FROM personnelle  WHERE type_perso =?" ;
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setString(1,"formateur");
			stmt.execute();
		    //	System.out.println(" delete all  succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public boolean ModifierFormateur(Personelle newpP,Personelle OldP ) {
		
		String Request="UPDATE personnelle SET  nom =?, prenom = ?, tel = ?, email = ?, type_contra= ?, type_perso = ? WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(Request);
			stmt.setNString(1, newpP.getNom());
			stmt.setString(2, newpP.getPrenom() );
			stmt.setInt(3, newpP.getTel());
			stmt.setString(4, newpP.getEmail());
			stmt.setString(5, newpP.getType_contrat());
			stmt.setString(6, "formateur");
			stmt.setInt(7, OldP.getId());
			stmt.execute();
			System.out.println(" updated  !");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Personelle chercherFormateur(int id) {
		 String request = "SELECT * FROM personnelle WHERE  id = ?  and type_perso =? ";
			PreparedStatement stmt;
			Personelle personelle = new Personelle () ;
			boolean exit = false;
			
			try {
				stmt = con.prepareStatement(request);
				stmt.setLong(1, id );
				stmt.setString(2, "formateur" );
				 ResultSet resulat = stmt.executeQuery();
				 while(resulat.next()) {
					 personelle.setId(resulat.getInt(1));
					 personelle.setNom(resulat.getString(2));
					 personelle.setPrenom(resulat.getString(3));
					 personelle.setEmail(resulat.getString(4));
					 personelle.setTel(resulat.getInt(5));
					 personelle.setType_contrat(resulat.getString(6));
				     System.out.println(" Got it !");
				 exit = true;
				 }
			
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
			if(exit==true) { return personelle; }
			else return null;
	 }

	public ArrayList <Personelle>  ListerFormateur () {
		
		ArrayList<Personelle> ListPersonelle = new ArrayList<Personelle>();
		String request = "SELECT * FROM personnelle WHERE type_perso = ? ";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(request);
			stmt.setNString(1,"formateur");
			 ResultSet resulat = stmt.executeQuery();
			 
			while(resulat.next()) {
			Personelle personelle = new Personelle () ;
			 personelle.setId(resulat.getInt(1));
			 personelle.setNom(resulat.getString(2));
			 personelle.setPrenom(resulat.getString(3));
			 personelle.setTel(resulat.getInt(4));
			 personelle.setEmail(resulat.getString(5));
			 personelle.setType_contrat(resulat.getString(6));
			 ListPersonelle.add(personelle);
			}
					
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return ListPersonelle;
	}
}
