package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Object.Etudiant;

public class DaoEtudiant {
	
	Connection con; 
	public DaoEtudiant() {
		Connexion connexiton = new  Connexion();
		con = connexiton.getConnexion();
	}
	
	public void AjouterEtudiant(Etudiant E) {
		String Rquest = "INSERT INTO etudiant (nom, prenom, email,tel, adresse ) VALUES (? , ?, ?, ?, ?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(Rquest);
			System.out.println(" Rquest!");
			stmt.setNString(1, E.getNom());
			stmt.setString(2, E.getPrenom() );
			stmt.setString(3, E.getEmail ());
			stmt.setInt(4, E.getTel() );
			stmt.setString(5, E.getAdresse());
			stmt.execute();
			System.out.println(" Student Added !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void SupprimerEtudiant(int id) {
		
		String Request ="DELETE FROM etudiant WHERE id = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setInt(1,id );
			stmt.execute();
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public void SupprimerEtudiants() {
		String Request ="DELETE FROM etudiant ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.execute();
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public void ModifierEtudiant(Etudiant E) {
		
		String Request="UPDATE etudiant SET  nom =?, prenom = ?, email = ?, tel = ?, daresse = ? WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(Request);
			stmt.setNString(1, E.getNom());
			stmt.setString(2, E.getPrenom() );
			stmt.setString(3, E.getPrenom() );
			stmt.setInt(4, E.getTel() );
			stmt.setString(5, E.getAdresse());
			stmt.setInt(6, E.getId());
			stmt.execute();
			System.out.println(" updated  !");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public Etudiant chercherEtudiant(int id) {
		String request = "SELECT * FROM etudiant WHERE  id = ?  ";
		PreparedStatement stmt;
		Etudiant etudiant = new Etudiant () ;
		boolean exit = false;
		
		try {
			stmt = con.prepareStatement(request);
			stmt.setLong(1, id );
			 ResultSet resulat = stmt.executeQuery();
			 while(resulat.next()) {
			 etudiant.setId(resulat.getInt(1));
			 etudiant.setNom(resulat.getString(2));
			 etudiant.setPrenom(resulat.getString(3));
			 etudiant.setTel(resulat.getInt(4));
			 etudiant.setEmail(resulat.getString(5));
			 etudiant.setAdresse(resulat.getString(6));
			 System.out.println(" Got it !");
			 exit = true;
			 }
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		if(exit==true) { return etudiant; }
		else return null;
	}
	
	public ArrayList <Etudiant>  ListerEtudiants() {
		
		ArrayList<Etudiant> ListEtudiant = new ArrayList<Etudiant>();
		String request = "SELECT * FROM etudiant ";
		PreparedStatement stmt;
		Etudiant etudiant = new Etudiant () ;
		try {
			stmt = con.prepareStatement(request);
			 ResultSet resulat = stmt.executeQuery();
			 while(resulat.next()) {
			 etudiant.setId(resulat.getInt(1));
			 etudiant.setNom(resulat.getString(2));
			 etudiant.setPrenom(resulat.getString(3));
			 etudiant.setTel(resulat.getInt(4));
			 etudiant.setEmail(resulat.getString(5));
			 etudiant.setAdresse(resulat.getString(6));
			 ListEtudiant.add(etudiant);
			}
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		return ListEtudiant;
	}

}





