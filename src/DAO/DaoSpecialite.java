package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Object.Etudiant;
import Object.Specialite;

public class DaoSpecialite {
	
	Connection con; 
	public DaoSpecialite() {
		Connexion connexiton = new  Connexion();
		con = connexiton.getConnexion();
	}
	
	
	public void AjouterSpecialite(Specialite S) {
		//public Specialite(int id, String nomSpecialite, String desciption)
		
		String Rquest = "INSERT INTO specialite (nomSpecialite, desciption ) VALUES (? , ?)";
		try {
			
			PreparedStatement stmt = con.prepareStatement(Rquest);
			System.out.println(" Rquest!");
			stmt.setNString(1, S.getNomSpecialite());
			stmt.setString(2, S.getDesciption());
			stmt.execute();
			System.out.println(" specialite Added !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void SupprimerSpecialite(int id) {
		
		String Request ="DELETE FROM Specialite WHERE id = ? ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.setInt(1,id );
			stmt.execute();
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	public void SupprimerSpecialite() {
		String Request ="DELETE FROM specialite ";
		try {
			PreparedStatement stmt = con.prepareStatement(Request);
			stmt.execute();
		    //	System.out.println(" delete succes !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ModifierSpecialite(Specialite S) {
	
		String Request="UPDATE specialite SET  nomSpecialite =? , desciption = ? WHERE id = ?";
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(Request);
			stmt.setNString(1, S.getNomSpecialite());
			stmt.setString(2, S.getDesciption());
			stmt.setInt(6, S.getId());
			stmt.execute();
			System.out.println(" specialite updated  !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Specialite chercherSpecialite(int id) {
		String request = "SELECT * FROM specialite WHERE  id = ?  ";
		PreparedStatement stmt;
		Specialite specialite = new Specialite () ;
		boolean exit = false;
		
		try {
			stmt = con.prepareStatement(request);
			stmt.setLong(1, id );
			 ResultSet resulat = stmt.executeQuery();
			 while(resulat.next()) {
				 specialite.setId(resulat.getInt(1));
				 specialite.setNomSpecialite(resulat.getString(2));
				 specialite.setDesciption((resulat.getString(3)));
			 System.out.println(" Got it !");
			 exit = true;
			 }
		
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		if(exit==true) { return specialite; }
		else return null;
	}
	
	public ArrayList <Specialite>  ListerSpecialites() {
			ArrayList<Specialite> ListSpecialite = new ArrayList<Specialite>();
			String request = "SELECT * FROM specialite ";
			PreparedStatement stmt;
			Specialite specialite = new Specialite () ;
			try {
				stmt = con.prepareStatement(request);
				 ResultSet resulat = stmt.executeQuery();
				 while(resulat.next()) {
					 specialite.setId(resulat.getInt(1));
					 specialite.setId(resulat.getInt(1));
					 specialite.setNomSpecialite(resulat.getString(2));
					 specialite.setDesciption((resulat.getString(3)));
					 ListSpecialite.add(specialite);
				}
			
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
			return ListSpecialite;
		} 
		
		
		
}
